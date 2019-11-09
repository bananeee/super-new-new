package Entity;

import javafx.scene.image.Image;
import Database.Config;
import Database.Data;

public class NormalTower extends Tower {


    public NormalTower(int posX, int posY) {
        super(posX, posY);
        price = Config.NORMAL_TOWER_PRICE;
        frequence = Config.NORMAL_TOWER_FREQUENCE;
        range = Config.NORMAL_TOWER_RANGE;
        Data.playerMoney -= price;
        image = new Image("tower.png");
    }

//    public NormalTower(Tower newTower) {
//        super(newTower);
//    }

    @Override
    protected void creatBullet() {
        Data.bulletsList.add(new NormalBullet(this));
    }
}
