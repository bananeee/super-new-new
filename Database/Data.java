package Database;

import Entity.Bullet;
import Entity.Enemy;
import Entity.Tower;

import java.util.ArrayList;

public class Data {
    public static boolean check = false;
    public static boolean checkDraw = false;

    public static int playerHealth = 1;
    public static int playerMoney = 10000;
    public static boolean endGame = false;

    public static ArrayList<Enemy> enemiesList = new ArrayList<>();
    public static ArrayList<Tower> towersList = new ArrayList<>();
    public static ArrayList<Bullet> bulletsList = new ArrayList<>();

}
