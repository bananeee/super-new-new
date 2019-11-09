package Entity;

import javafx.scene.canvas.GraphicsContext;

public abstract class Changable {
    protected int tickCount = 0;

    public void tick() {
        tickCount ++;
    }

    public void draw(GraphicsContext gc) {};
    public void onUpdate() {};
}
