package sample;

import Database.Config;
import Database.Data;
import Database.Map;
import Entity.NormalTower;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;


public class Controller {
    Rectangle normalTower = new Rectangle(Config.NORMAL_TOWER_COORDINATE[0], Config.NORMAL_TOWER_COORDINATE[1], Config.NORMAL_TOWER_COORDINATE[0] + Config.BUTTON_SIZE, Config.NORMAL_TOWER_COORDINATE[1] + Config.BUTTON_SIZE);
    Rectangle machineTower = new Rectangle(Config.SNIPER_TOWER_COORDINATE[0], Config.SNIPER_TOWER_COORDINATE[1], Config.SNIPER_TOWER_COORDINATE[0] + Config.BUTTON_SIZE, Config.SNIPER_TOWER_COORDINATE[1] + Config.BUTTON_SIZE);
    Rectangle sniperTower = new Rectangle(Config.MACHINE_TOWER_COORDINATE[0], Config.MACHINE_TOWER_COORDINATE[1], Config.MACHINE_TOWER_COORDINATE[0] + Config.BUTTON_SIZE, Config.MACHINE_TOWER_COORDINATE[1] + Config.BUTTON_SIZE);
    private boolean check = false;
    private int getTower;

    public void click(Scene scene, GraphicsContext gc) {
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (check == false)
                    doClick(event);
                else
                    doRelease(event);
            }
        });

//        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                doClick(event);
//            }
//        });
//
//        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                doRelease(event);
//            }
//        });

    }

    private void doClick(MouseEvent event) {
        if (event.getX() >= Config.NORMAL_TOWER_COORDINATE[0]
                && event.getX() <= Config.NORMAL_TOWER_COORDINATE[0] + Config.BUTTON_SIZE
                && event.getY() >= Config.NORMAL_TOWER_COORDINATE[1]
                && event.getY() <= Config.NORMAL_TOWER_COORDINATE[1] + Config.BUTTON_SIZE) {

            check = true;
            getTower = Config.NORMAL_TOWER;

        } else if (event.getX() >= Config.SNIPER_TOWER_COORDINATE[0]
                && event.getX() <= Config.SNIPER_TOWER_COORDINATE[0] + Config.BUTTON_SIZE
                && event.getY() >= Config.SNIPER_TOWER_COORDINATE[1]
                && event.getY() <= Config.SNIPER_TOWER_COORDINATE[1] + Config.BUTTON_SIZE) {

            check = true;
            getTower = Config.SNIPER_TOWER;

        } else if (event.getX() >= Config.MACHINE_TOWER_COORDINATE[0]
                && event.getX() <= Config.MACHINE_TOWER_COORDINATE[0] + Config.BUTTON_SIZE
                && event.getY() >= Config.MACHINE_TOWER_COORDINATE[1]
                && event.getY() <= Config.MACHINE_TOWER_COORDINATE[1] + Config.BUTTON_SIZE) {

            check = true;
            getTower = Config.MACHINE_TOWER;

        }
    }

    private void doRelease(MouseEvent event) {
        if (check == true) {
            int x = (int) (event.getX() / Config.TILE_SIZE);
            int y = (int) (event.getY() / Config.TILE_SIZE);
            //Data.towerList.add("NormalTower" + "-" + x + "-" + y);
            if (Map.map[y][x] == 1 || Map.map[y][x] == 0)
                //gc.drawImage(new Image("tower.png"), x * Config.TILE_SIZE, y * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                Data.towersList.add(new NormalTower(x * Config.TILE_SIZE + Config.TILE_SIZE / 2,y * Config.TILE_SIZE + Config.TILE_SIZE / 2));
            check = false;
            //System.out.println(check);
        }
    }
}
