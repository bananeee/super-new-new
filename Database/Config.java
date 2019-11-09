package Database;

public class Config {
    public static final int TILE_SIZE = 48; // có thể thay đổi tùy ý
    public static final int SCREEN_WITDH = 20; // có thể thay đổi tùy ý
    public static final int SCREEN_HEIGHT = 18; // có thể thay đổi tùy ý


    public static final int[] NORMAL_TOWER_COORDINATE = {TILE_SIZE * 5, TILE_SIZE * 16};
    public static final int[] SNIPER_TOWER_COORDINATE = {TILE_SIZE * 10, TILE_SIZE * 16};
    public static final int[] MACHINE_TOWER_COORDINATE = {TILE_SIZE * 15, TILE_SIZE * 16};

    public static final int NORMAL_TOWER = 10000;
    public static final int SNIPER_TOWER = 20000;
    public static final int MACHINE_TOWER = 30000;

    public static final int BUTTON_SIZE = TILE_SIZE;

    public static final int NORMAL_BULLET_DAMAGE = 15;
    public static final int NORMAL_BULLET_RANGE = TILE_SIZE / 2;
    public static final int NORMAL_BULLET_VELOCITY = 5;

    public static final int NORMAL_TOWER_PRICE = 100000;
    public static final int NORMAL_TOWER_RANGE = TILE_SIZE * 10;
    public static final int NORMAL_TOWER_FREQUENCE = 15;

    public static final int NORMAL_ENEMY_HEALTH = 100;
    public static final int NORMAL_ENEMY_VELOCITY = 2;
    public static final int NORMAL_ENEMY_REWARD = 500;
    public static final int NORMAL_ENEMY_RANGE = TILE_SIZE;

    public static int GATEX = 1 * TILE_SIZE;
    public static int GATEY = 11 * TILE_SIZE;

}
