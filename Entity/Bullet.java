package Entity;

import Database.Config;
import Database.Data;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;

public abstract class Bullet extends Changable {
    protected int damage;

    private Tower tower;
    private int towerX;
    private int towerY;

    private Enemy enemy;
    private int enemyX;
    private int enemyY;

    private int posX;
    private int posY;

    protected int range;
    private Circle arena;

    protected double velocity;

    protected Image image;

    private double degree;
    private double velocityX;
    private double velocityY;

    public Bullet(Tower tower) {
        this.tower = tower;
        towerX = tower.getPosX();
        towerY = tower.getPosY();

        enemy = tower.getEnemy();
        enemyX = enemy.getCenterX();
        enemyY = enemy.getCenterY();
        posX = towerX;
        posY = towerY;
        degree = Math.atan2(enemyY - towerY, enemyX - towerX);

    }

    protected void setup() {
        velocityX = velocity * Math.cos(degree);
        velocityY = velocity * Math.sin(degree);
        arena = new Circle(towerX, towerY, range / 2);
    }

    public void onUpdate() {
        run();
        arena.setCenterX(posX);
        arena.setCenterY(posY);
        doDamage();
    }

    private void run() {
//        posX = towerX + ((int) velocityX) * tickCount;
//        posY = towerY + ((int) velocityY) * tickCount;
        posX += ((int) velocityX);
        posY += ((int) velocityY);
    }

    private boolean doDamage() {
        if (Math.sqrt(Math.pow(posX - enemy.getCenterX(), 2) + Math.pow(posY - enemy.getCenterY(), 2)) <= range + enemy.getRange()) {
            Data.bulletsList.remove(this);
            enemy.isDamage(true, damage);
            return true;
        } else
            return false;
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(image, posX - Config.TILE_SIZE / 2, posY - Config.TILE_SIZE / 2, range, range);
    }

    public int getDamage() {
        return damage;
    }

    public Tower getTower() {
        return tower;
    }

    public int getTowerX() {
        return towerX;
    }

    public int getTowerY() {
        return towerY;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getRange() {
        return range;
    }

    public Circle getArena() {
        return arena;
    }

    public double getVelocity() {
        return velocity;
    }

    public Image getImage() {
        return image;
    }

    public double getDegree() {
        return degree;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }
}
