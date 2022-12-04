package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type BossAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class BossAlien extends AbstractEnemy {
    private static final float BOSS_ALIEN_SPEED = 10f;
    private static final long BOSS_ALIEN_HEALTH = 1000;
    private static final long BOSS_ALIEN_WIDTH =  100;
    private static final long BOSS_ALIEN_HEIGHT = 100;
    private static final long BOSS_ALIEN_KILL_MONEY = 200;
    private static final long BOSS_ALIEN_KILL_EXPERIENCE = 200;
    private static final String BOSS_ALIEN_SPRITE_IMAGE_FILE_NAME = "bossAlien.png";

    /**
     * Constructs an object of type BossAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     */
    public BossAlien(final long someXPosition, final long someYPosition) {
        super(someXPosition, someYPosition, BOSS_ALIEN_WIDTH, BOSS_ALIEN_HEIGHT, BOSS_ALIEN_KILL_MONEY,
                BOSS_ALIEN_KILL_EXPERIENCE, BOSS_ALIEN_SPEED, BOSS_ALIEN_HEALTH, BOSS_ALIEN_SPRITE_IMAGE_FILE_NAME);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
