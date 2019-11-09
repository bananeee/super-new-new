
import Database.Data;
import Entity.Changable;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class GameRun {
    private GraphicsContext gc;
    private ArrayList<Changable> entitiesList = new ArrayList<>();

    public GameRun(GraphicsContext gc) {
        this.gc = gc;
        entitiesList.addAll(Data.towersList);
        entitiesList.addAll(Data.enemiesList);
        entitiesList.addAll(Data.bulletsList);
    }

    private void render() {
        for (Changable entity : entitiesList)
            entity.draw(gc);
    }

    private void doRun() {
        for (Changable entity : entitiesList) {
            entity.tick();
            entity.onUpdate();
        }
    }

    public void run() {
        doRun();
        render();
    }
}
