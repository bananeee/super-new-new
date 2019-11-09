package sample;

import Database.Config;
import Database.Data;
import Database.MapDrawer;
import Entity.NormalEnemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Example6 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("run");

        StackPane pane = new StackPane();
        Scene scene = new Scene(pane);
        scene.getStylesheets().add("test.css");


        Canvas canvas_animation = new Canvas(Config.TILE_SIZE * Config.SCREEN_WITDH, Config.TILE_SIZE * Config.SCREEN_HEIGHT);
        Canvas canvas_background = new Canvas(Config.TILE_SIZE * Config.SCREEN_WITDH, Config.TILE_SIZE * Config.SCREEN_HEIGHT);

        pane.getChildren().addAll(canvas_animation, canvas_background);

        // đặt canvas động ra trc
        canvas_animation.toFront();

        GraphicsContext gc_animation = canvas_animation.getGraphicsContext2D();
        GraphicsContext gc_background = canvas_background.getGraphicsContext2D();

        //vẽ map
        new MapDrawer().draw(gc_background);

        new Controller().click(scene, gc_background);

        //walk_man man = new walk_man();


        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            int i = 0;

            //SpawnNormalEnemy spawnNormalEnemy = new SpawnNormalEnemy();
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                i++;
                gc_animation.clearRect(0, 0, Config.TILE_SIZE * Config.SCREEN_WITDH, Config.TILE_SIZE * Config.SCREEN_HEIGHT);

                new GameRun(gc_animation).run();
                //spawnNormalEnemy.tick();
                //spawnNormalEnemy.doSpawn();
                //System.out.println(Data.bulletsList.isEmpty());
                //người bắt đầu chạy
                //man.Walk(gc_animation, t);
                //if (Data.towersList.isEmpty() == false) {
                    //System.out.println(Math.cos(Data.bulletsList.get(0).getDegree()));
                   // System.out.println(Data.towersList.get(0).checkEnemy());
//                    System.out.println(Data.bulletsList.get(0).getEnemyY());
//                    System.out.println(Data.bulletsList.get(0).getTowerX());
//                    System.out.println(Data.bulletsList.get(0).getTowerY());
                //}
//                if (Data.enemiesList.isEmpty() == false)
//                    System.out.println((double) Data.enemiesList.get(0).getCenterX() / Config.TILE_SIZE);
                if (i % 100 == 0)
                    Data.enemiesList.add(new NormalEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 2));
            }
        }.start();


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
