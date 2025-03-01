package gg.generations.rarecandy.tools.gui;

import gg.generations.rarecandy.pokeutils.PixelAsset;
import gg.generations.rarecandy.pokeutils.reader.ITextureLoader;
import gg.generations.rarecandy.renderer.LoggerUtil;
import gg.generations.rarecandy.renderer.animation.*;
import gg.generations.rarecandy.renderer.components.AnimatedMeshObject;
import gg.generations.rarecandy.renderer.components.MeshObject;
import gg.generations.rarecandy.renderer.components.MultiRenderObject;
import gg.generations.rarecandy.renderer.loading.ModelLoader;
import gg.generations.rarecandy.renderer.model.material.PipelineRegistry;
import gg.generations.rarecandy.renderer.rendering.ObjectInstance;
import gg.generations.rarecandy.renderer.rendering.RareCandy;
import gg.generations.rarecandy.renderer.rendering.RenderStage;
import gg.generations.rarecandy.renderer.storage.AnimatedObjectInstance;
import gg.generations.rarecandy.tools.TextureLoader;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11C;
import org.lwjgl.opengl.awt.AWTGLCanvas;
import org.lwjgl.opengl.awt.GLData;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class RareCandyCanvas extends AWTGLCanvas {
    public static Matrix4f projectionMatrix;

    private static float lightLevel = 0.950f;
    private static double time;

    public final Matrix4f viewMatrix = new Matrix4f();
    public final List<AnimatedObjectInstance> instances = new ArrayList<>();
    private final int scaleModifier = 0;
    public double startTime = System.currentTimeMillis();
    public String currentAnimation = null;
    private RareCandy renderer;
    private MultiRenderObject<MeshObject> plane;

    public MultiRenderObject<AnimatedMeshObject> loadedModel;
    public AnimatedObjectInstance loadedModelInstance;
    private static float previousLightLevel;

    public static void setLightLevel(float lightLevel) {
        previousLightLevel = RareCandyCanvas.lightLevel;
        RareCandyCanvas.lightLevel = lightLevel;
    }

     static float getLightLevel() {
        return lightLevel;
    }

    public RareCandyCanvas() {
        super(defaultData());
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                projectionMatrix = new Matrix4f().perspective((float) Math.toRadians(100), (float) getWidth() / getHeight(), 0.1f, 1000.0f);
            }
        });
    }

    private static GLData defaultData() {
        var data = new GLData();
        data.profile = GLData.Profile.CORE;
        data.forwardCompatible = true;
        data.api = GLData.API.GL;
        data.majorVersion = 3;
        data.minorVersion = 2;
        return data;
    }

    public static double getTime() {
        return time;
    }

    public static void setup(RareCandyCanvas canvas) {
        canvas.attachArcBall();

        ITextureLoader.setInstance(new TextureLoader());

        PipelineRegistry.setFunction(s-> switch(s) {
            case "masked" -> GuiPipelines.MASKED;
            case "layered" -> GuiPipelines.LAYERED;
            case "paradox" -> GuiPipelines.PARADOX;
            case "plane" -> GuiPipelines.PLANE;
            default -> GuiPipelines.SOLID;
        });

        var renderLoop = new Runnable() {
            @Override
            public void run() {
                if (canvas.isValid()) canvas.render();
                SwingUtilities.invokeLater(this);
            }
        };

        SwingUtilities.invokeLater(renderLoop);
    }

    public void openFile(PixelAsset pkFile) throws IOException {
        openFile(pkFile, () -> {});
    }

    public void openFile(PixelAsset pkFile, Runnable runnable) throws IOException {
        currentAnimation = null;
        renderer.objectManager.clearObjects();
        renderer.objectManager.add(plane, new ObjectInstance(new Matrix4f(), viewMatrix, null));
        if(loadedModel != null) loadedModel.close();

        if(pkFile == null) return;

        loadPokemonModel(renderer, pkFile, model -> {
            var i = 0;

            loadedModel = model;
            var variants = model.availableVariants();

            var variant = !variants.isEmpty() ? variants.iterator().next() : null;
            var instance = new AnimatedObjectInstance(new Matrix4f(), viewMatrix, variant);
            instance.transformationMatrix().scale(loadedModel.scale);
            loadedModelInstance = renderer.objectManager.add(model, instance);
            model.updateDimensions();
            runnable.run();
        });
    }

    @Override
    public void initGL() {
        projectionMatrix = new Matrix4f().perspective((float) Math.toRadians(100), (float) getWidth() / getHeight(), 0.1f, 1000.0f);
        GL.createCapabilities(true);
        GuiPipelines.onInitialize();
        this.renderer = new RareCandy();

        GL11C.glClearColor(0, 0, 0, 1);
        GL11C.glEnable(GL11C.GL_DEPTH_TEST);

        loadPlane(renderer, 100, 100, model -> {
            plane = model;
            renderer.objectManager.add(model, new ObjectInstance(new Matrix4f(), viewMatrix, null));
        });
    }

    private MultiRenderObject<MeshObject> loadPlane(RareCandy renderer, int width, int length, Consumer<MultiRenderObject<MeshObject>> onFinish) {
        return renderer.getLoader().generatePlane(width, length, onFinish);
    }

    private Vector3f size = new Vector3f();

    private double fraciton = 1/16f;
    @Override
    public void paintGL() {
        GL11C.glClear(GL11C.GL_COLOR_BUFFER_BIT | GL11C.GL_DEPTH_BUFFER_BIT);
        if (loadedModelInstance != null) {
            loadedModelInstance.transformationMatrix().identity().scale(loadedModel.scale);

            size.set(loadedModel.dimensions).mul(loadedModel.scale);
        }

        time = (System.currentTimeMillis() - startTime) / 1000f;

        renderer.render(false, time, RenderStage.SOLID);
        renderer.render(false, time, RenderStage.TRANSPARENT);
        swapBuffers();

        if (instances.size() > 1) {
            ((MultiRenderObject<AnimatedMeshObject>) instances.get(0).object()).onUpdate(a -> {
                for (var instance : instances) {
                    if(a.animations != null) {
                        var newAnimation = a.animations.get(currentAnimation);

                        if(newAnimation != null) {
                            instance.changeAnimation(createInstance(newAnimation));
                        }
                    }
                }
            });
        }

        for (var instance : instances) {
            if (scaleModifier != 0) {
                var newScale = 1 - (scaleModifier * 0.1f);
                instance.transformationMatrix().scale(newScale);
            }
        }
    }

    public AnimationInstance createInstance(Animation animation) {
        return new AnimationInstance(animation);
    }

    protected void loadPokemonModel(RareCandy renderer, PixelAsset is, Consumer<MultiRenderObject<AnimatedMeshObject>> onFinish) {
        load(renderer, is, onFinish, AnimatedMeshObject::new);
    }

    protected <T extends MeshObject> void load(RareCandy renderer, PixelAsset is, Consumer<MultiRenderObject<T>> onFinish, Supplier<T> supplier) {
        var loader = renderer.getLoader();
        loader.createObject(
                () -> is,
                (gltfModel, smdFileMap, gfbFileMap, tramnAnimations, images, config, object) -> {
                    var glCalls = new ArrayList<Runnable>();
                    ModelLoader.create2(object, gltfModel, smdFileMap, gfbFileMap, tramnAnimations, images, config, glCalls, supplier);
                    object.objects.forEach(t -> glCalls.add(t.model::upload));

                    return glCalls;
                },
                onFinish
        );
    }

    public void setAnimation(@NotNull String animation) {
        AnimatedMeshObject object = loadedModel.objects.get(0);

        if (object.animations != null)
            LoggerUtil.print(animation);
        if (Objects.requireNonNull(object.animations).containsKey(animation)) {
            loadedModelInstance.changeAnimation(createInstance(object.animations.get(animation)));
        }
    }

    public void updateLoadedModel(Consumer<AnimatedMeshObject> consumer) {
        loadedModel.onUpdate(consumer);
    }

    public void setVariant(String variant) {
        loadedModelInstance.setVariant(variant);
    }

    public void attachArcBall() {
        var arcballOrbit = new ArcballOrbit(viewMatrix, 3f, 0.125f, 0f);
        this.addMouseMotionListener(arcballOrbit);
        this.addMouseWheelListener(arcballOrbit);
        this.addMouseListener(arcballOrbit);
        this.addKeyListener(arcballOrbit);
    }

    public static class ArcballOrbit implements MouseMotionListener, MouseWheelListener, MouseListener, KeyListener {
        private final Matrix4f viewMatrix;
        private float radius;
        private float angleX;
        private float angleY;
        private int lastX, lastY;
        private float offsetX, offsetY;

        private final Vector3f centerOffset = new Vector3f();

        public ArcballOrbit(Matrix4f viewMatrix, float radius, float angleX, float angleY) {
            this.viewMatrix = viewMatrix;
            this.radius = radius;
            this.angleX = angleX;
            this.angleY = angleY;
            update();
        }

        public void update() {
            viewMatrix.identity().arcball(radius, centerOffset.x, centerOffset.y, centerOffset.z, (angleY + offsetY) * (float) Math.PI * 2f, (angleX + offsetX) * (float) Math.PI * 2f);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            offsetX = (x - lastX) * 0.001f;
            offsetY = (y - lastY) * 0.001f;
            update();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            int scrollAmount = e.getWheelRotation();
            radius += scrollAmount * 0.1f;
            update();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            offsetX = 0;
            offsetY = 0;

            lastX = e.getX();
            lastY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            angleX += offsetX;
            angleY += offsetY;
            offsetX = 0;
            offsetY = 0;
            lastX = 0;
            lastY = 0;

            update();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            float lateralStep = 0.001f; // Adjust the step size as needed

            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> centerOffset.x -= lateralStep;
                case KeyEvent.VK_RIGHT -> centerOffset.x += lateralStep;
                case KeyEvent.VK_UP -> centerOffset.z += lateralStep;
                case KeyEvent.VK_DOWN -> centerOffset.z -= lateralStep;
                case KeyEvent.VK_PAGE_UP -> centerOffset.y += lateralStep;
                case KeyEvent.VK_PAGE_DOWN -> centerOffset.y -= lateralStep;
            }

            update();
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}

