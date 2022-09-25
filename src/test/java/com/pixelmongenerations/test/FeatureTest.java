package com.pixelmongenerations.test;

import com.pixelmongenerations.pkl.PixelAsset;
import com.pixelmongenerations.pkl.reader.GlbReader;
import com.pixelmongenerations.rarecandy.OldModelLoader;
import com.pixelmongenerations.rarecandy.components.RenderObject;
import com.pixelmongenerations.rarecandy.rendering.RareCandy;
import org.joml.Matrix4f;

import java.util.Objects;

public abstract class FeatureTest {
    public final String id;
    public final String description;

    protected FeatureTest(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void init(RareCandy scene, Matrix4f viewMatrix);

    public abstract void update(RareCandy scene, double deltaTime);

    protected RenderObject loadStaticModel(String name) {
        PixelAsset model = new PixelAsset(Objects.requireNonNull(FeatureTest.class.getResourceAsStream("/" + name + ".pk"), "Failed to read /" + name + ".pk"));
        return model.createStaticObject(Pipelines.staticPipeline(() -> FeatureTester.PROJECTION_MATRIX));
    }

    protected RenderObject loadAnimatedModel(String name) {
        PixelAsset model = new PixelAsset(Objects.requireNonNull(FeatureTest.class.getResourceAsStream("/" + name + ".pk"), "Failed to read /" + name + ".pk"));
        return OldModelLoader.loadAnimatedFile(model.scene, ((GlbReader) model.reader).rawScene, Pipelines.animatedPipeline(() -> FeatureTester.PROJECTION_MATRIX));
    }
}
