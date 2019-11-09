package Entity;

import javafx.scene.image.Image;
import Database.Config;

public class NormalBullet extends Bullet {

    public NormalBullet(Tower tower) {
        super(tower);
        damage = Config.NORMAL_BULLET_DAMAGE;
        range = Config.NORMAL_BULLET_RANGE;
        velocity = Config.NORMAL_BULLET_VELOCITY;
        image = new Image("bullet.png");
        setup();
    }

}
