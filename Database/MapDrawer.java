package Database;

import Database.Config;
import Database.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;


public class MapDrawer {
    Rectangle normalTower = new Rectangle();
    Rectangle sniperlTower = new Rectangle();

    public void draw(GraphicsContext gc) {
        for (int i = 0; i < Map.map.length; i++)
            for (int j = 0; j < Map.map[0].length; j++)
                if (Map.map[i][j] == 2 || Map.map[i][j] == 4 || Map.map[i][j] == 6 || Map.map[i][j] == 8) {
                    Image image = new Image("road5.png");
                    gc.drawImage(image, j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                } else
                    gc.drawImage(new Image("wall.png"),j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);

        gc.drawImage(new Image("tower.png"),Config.NORMAL_TOWER_COORDINATE[0],Config.NORMAL_TOWER_COORDINATE[1],Config.TILE_SIZE,Config.TILE_SIZE);
        gc.drawImage(new Image("tower.png"),Config.SNIPER_TOWER_COORDINATE[0],Config.SNIPER_TOWER_COORDINATE[1],Config.TILE_SIZE,Config.TILE_SIZE);
        gc.drawImage(new Image("tower.png"),Config.MACHINE_TOWER_COORDINATE[0],Config.MACHINE_TOWER_COORDINATE[1],Config.TILE_SIZE,Config.TILE_SIZE);
    }


}