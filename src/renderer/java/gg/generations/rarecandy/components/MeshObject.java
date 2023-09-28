package gg.generations.rarecandy.components;

import gg.generations.rarecandy.model.GLModel;
import gg.generations.rarecandy.model.material.Material;
import gg.generations.rarecandy.pipeline.Pipeline;
import gg.generations.rarecandy.rendering.ObjectInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class MeshObject extends RenderObject {
    public GLModel model;
    public String name;

    public void setup(Map<String, Material> variants, List<String> shouldRender, GLModel model, Function<String, Pipeline> pipeline, String name) {
        this.name = name;
        this.variants = variants;
        this.shouldRenderList = shouldRender;
        this.model = model;
        this.pipeline = pipeline;
        this.defaultVariant = new ArrayList<>(variants.keySet()).get(0);
        this.ready = true;
    }

    public <T extends RenderObject> void render(List<ObjectInstance> instances, T object) {
        Map<String, List<Consumer<Pipeline>>> map = new HashMap<>();

        for (var instance : instances) {
            if (object.shouldRender(instance)) {
                continue;
            }

            var material = object.getMaterial(instance.variant());

            var type = material.getType();

            map.computeIfAbsent(type, a -> new ArrayList<>()).add(pipeline -> {
                pipeline.updateOtherUniforms(instance, object);
                pipeline.updateTexUniforms(instance, object);
                model.runDrawCalls();
            });
        }

        map.forEach((k, v) -> {
            var pl = pipeline.apply(k);
            pl.bind();
            v.forEach(a -> a.accept(pl));
            pl.unbind();
        });
    }
}
