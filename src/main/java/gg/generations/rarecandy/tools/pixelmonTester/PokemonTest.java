package gg.generations.rarecandy.tools.pixelmonTester;

import gg.generations.rarecandy.arceus.model.generator.PlaneGenerator;
import gg.generations.rarecandy.legacy.animation.Animation;
import gg.generations.pokeutils.util.ResourceLocation;
import gg.generations.rarecandy.loading.gltf.VariantInstance;
import gg.generations.rarecandy.loading.gltf.VariantScene;
import gg.generations.rarecandy.loading.pk.Loader;
import org.joml.Matrix4f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokemonTest {
    public List<VariantInstance.InstanceProxy> instances = new ArrayList<>();
//    private final Path path;
    public VariantScene renderer;
    public Pipelines pipelines;
    private boolean rotate;

    public PokemonTest(String[] args) {
        Animation.animationModifier = (animation, s) -> animation.ticksPerSecond = 16;
//        this.path = Paths.get(args[0]);
//        if (args.length == 3) this.rotate = Boolean.parseBoolean(args[2]);
    }

    private static int clamp(int value, int max) {
        return Math.min(Math.max(value, 0), max);
    }

    public void init(VariantScene scene, Matrix4f projectionMatrix, Matrix4f viewMatrix) {
        this.renderer = scene;

        try {
        var shader = PlaneGenerator.simple(projectionMatrix, viewMatrix);
        var model = Loader.load(new ResourceLocation(null, "pm0040_00_01.pk"), type -> shader); //PlaneGenerator.generatePlane(projectionMatrix, viewMatrix, 1.0f, 1.0f);
        instances = model.generateInstance().instances();
            for (var instance : instances) this.renderer.addInstance(instance);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        loadPokemonModel(scene, this::getAsset, model -> {
//            var variants = List.of("none-normal");//, "none-shiny");
//
//            for (int i = 0; i < variants.size(); i++) {
//                var instance = new VariantInstance();
//                instance.getTransform()
//                        .translate(new Vector3f(i * 4 - 2, -1f, 2))
//                        .rotate((float) Math.toRadians(-180), new Vector3f(0, 1, 0))
//                        .scale(0.4f);
//
//                if (rotate) instance.getTransform()
//                        .rotate((float) Math.toRadians(-90), new Vector3f(0, 1, 0));
//
//                instances.add(scene.objectManager.add(model, instance));
//            }
//        });
    }

//    private PixelAsset getAsset() {
//        try {
//            return new LoosePixelAsset(path);
//        } catch (Exception e) {
//            throw new RuntimeException("Fuck", e);
//        }
//    }

//    protected void load(RareCandy renderer, Supplier<PixelAsset> asset, Function<String, ShaderProgram> pipelineFactory, Consumer<MultiRenderObject<T>> onFinish, Supplier<T> supplier) {
//        var loader = renderer.getLoader();
//        loader.createObject(
//                asset,
//                (gltfModel, smdFileMap, gfbFileMap, images, config, object) -> {
//                    var glCalls = new ArrayList<Runnable>();
//                    try {
//                        ModelLoader.create2(object, gltfModel, smdFileMap, gfbFileMap, images, config, glCalls, pipelineFactory, supplier);
//                    } catch (Exception e) {
//                        throw new RuntimeException("Failed to interpret data", e);
//                    }
//                    return glCalls;
//                },
//                onFinish
//        );
//    }
//
//    protected void loadPokemonModel(RareCandy renderer, Supplier<PixelAsset> assetSupplier, Consumer<MultiRenderObject<AnimatedMeshObject>> onFinish) {
//        load(renderer, assetSupplier, s -> pipelines.animated, onFinish, AnimatedMeshObject::new);
//    }
//
//    public void leftTap() {
//        var map = instances.get(0).getAnimationsIfAvailable();
//
//        for (var instance : instances) {
//            if (instance.currentAnimation instanceof ThreeStageAnimationInstance threeStageAnimationInstance) {
//                threeStageAnimationInstance.finish(() -> instance.changeAnimation(new AnimationInstance(map.get("idle"))));
//            } else instance.changeAnimation(new AnimationInstance(map.get("idle")));
//        }
//    }
//
//    public void rightTap() {
//        var map = instances.get(0).getAnimationsIfAvailable();
//
//        for (var instance : instances) {
//            //instance.changeAnimation(new AnimationInstance(map.get("walk")));
//            instance.changeAnimation(new ThreeStageAnimationInstance(map, "rest_start", "rest_loop", "rest_end", "idle", "walk"));
//        }
//    }
//
//    public void space() {
//        for (var instance : instances) {
//            if (instance.currentAnimation != null) {
//                if (instance.currentAnimation.isPaused()) instance.currentAnimation.unpause();
//                else instance.currentAnimation.pause();
//            }
//        }
//    }
}
