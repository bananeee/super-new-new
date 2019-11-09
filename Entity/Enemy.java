package Entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import Database.Config;
import Database.Data;
import Database.Map;

public abstract class Enemy extends Changable {
    private int posX;
    private int posY;
    private boolean left;
    protected int range;

    private int centerX;
    private int centerY;

    private Circle arena;

    protected int health;
    protected int velocity;
    protected int reward;
    protected Image image;

    public Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        centerX = posX + Config.TILE_SIZE / 2;
        centerY = posY + Config.TILE_SIZE / 2;
    }

    protected void setup() {
        arena = new Circle(posX, posY, range / 2);
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

    public int getRange() {
        return range;
    }

    public void isDamage(boolean yes, int damage) {
        health -= damage;
    }

    public boolean isDestroyed() {
        if (health <= 0 || isPass())
            Data.enemiesList.remove(this);
        return true;
    }

    public boolean isPass() {
        if (posX == Config.GATEX && posY == Config.GATEY) {
            Data.playerHealth--;
            return true;
        } else
            return false;
    }

    public void Walk() {
        posX += velocity * Direction(posX, posY)[0];
        posY += velocity * Direction(posX, posY)[1];
        centerX = posX + Config.TILE_SIZE / 2;
        centerY = posY + Config.TILE_SIZE / 2;
    }

    private int[] Direction(double x, double y) {
        boolean checkX;
        if (x - (int) (x / Config.TILE_SIZE) * Config.TILE_SIZE > velocity)
            checkX = false;
        else
            checkX = true;
        int cox = (int) x / Config.TILE_SIZE;
        int coy = (int) y / Config.TILE_SIZE;
        int[] dir = new int[2];
        switch (Map.map[coy][cox]) {
            case 4:
                dir[0] = -1;
                dir[1] = 0;
                left = true;
                break;
            case 6:
                dir[0] = 1;
                dir[1] = 0;
                left = false;
                break;
            case 2:
                if (checkX == false) {
                    dir[0] = -1;
                    dir[1] = 0;
                } else {
                    dir[0] = 0;
                    dir[1] = 1;
                }
                break;
            case 8:
                dir[0] = 0;
                dir[1] = -1;
                break;
        }
        return dir;
    }

    public void onUpdate() {
        Walk();
        if (isPass())
            isDestroyed();
        arena.setCenterX(centerX);
        arena.setCenterY(centerY);
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, posX, posY, range, range);
    }

    public int getHealth() {
        return health;
    }
}
