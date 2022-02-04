package cf.hydos.engine.core;

import cf.hydos.engine.Window;
import cf.hydos.engine.rendering.RenderingEngine;

public class LoopManager {

    private final Window window;
    private final RenderingEngine renderer;
    private final RenderingApplication application;
    private boolean isRunning;

    public LoopManager(int width, int height, String title, RenderingApplication application) {
        this.isRunning = false;
        this.application = application;
        this.window = new Window(title, width, height);
        this.renderer = new RenderingEngine(this.window);
        application.setRenderer(this);
    }

    public void stop() {
        if (!isRunning)
            return;

        isRunning = false;
    }

    public void start() {
        isRunning = true;
        application.init();

        while (isRunning) {
            if (this.window.shouldClose()) {
                stop();
            }

            this.window.pollEvents();
            this.application.update();
            this.application.render(this.renderer);
            this.window.swapBuffers();
        }

        clean();
    }

    private void clean() {
        this.window.destroy();
    }
}
