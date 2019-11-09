package Entity;

import javafx.scene.image.Image;
import Database.Config;

public class NormalEnemy extends Enemy {
    public NormalEnemy(int posX, int posY) {
        super(posX, posY);
        range = Config.NORMAL_ENEMY_RANGE;
        health = Config.NORMAL_ENEMY_HEALTH;
        velocity = Config.NORMAL_ENEMY_VELOCITY;
        reward = Config.NORMAL_ENEMY_REWARD;
        image = new Image("enemy2.png");
        setup();
    }
}
