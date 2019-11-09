package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Database.Config;
import Database.Data;

public abstract class Tower extends Changable {
    private int posX; // = x +tile_size/2
    private int posY;
    private int centerX;
    private int centerY;

    protected int range;
    protected int frequence;
    protected int price;
    protected Image image;

    private Enemy enemy;

    public Tower(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.centerX = posX + Config.TILE_SIZE / 2;
        this.centerY = posY + Config.TILE_SIZE / 2;
    }

//    public Tower(Tower newTower) {
//        this.posX = newTower.posX;
//        this.posY = newTower.posY;
//        this.centerX = newTower.centerX;
//        this.centerY = newTower.centerY;
//        this.enemy = newTower.enemy;
//    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    private boolean inRange(int x, int y) {
        return Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)) <= range;
    }

    public void onUpdate() {
        if (enemy == null || enemy.isDestroyed() || inRange(enemy.getCenterX(), enemy.getCenterY()) == false) {
            enemy = null;
            for (int i = Data.enemiesList.size() - 1; i >= 0; i--)
                if (inRange(Data.enemiesList.get(i).getCenterX(), Data.enemiesList.get(i).getCenterY())) {
                    enemy = Data.enemiesList.get(i);
                    break;
                }
        }

        if (tickCount % frequence == 0 && enemy != null)
            creatBullet();
//        {
//            System.out.println(Math.atan2(enemy.getCenterY() - centerY, enemy.getCenterX() - centerX));
//        }
    }

    protected abstract void creatBullet();

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, posX - Config.TILE_SIZE / 2, posY - Config.TILE_SIZE / 2, Config.TILE_SIZE, Config.TILE_SIZE);
    }

    public boolean checkEnemy() {
        if (inRange(enemy.getCenterX(), enemy.getCenterY()) && enemy != null)
            return false;
        else
            return true;
    }


}
