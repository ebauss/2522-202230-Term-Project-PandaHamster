package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type SpeedyAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class SpeedyAlien extends AbstractEnemy {
    private static final float SPEEDY_ALIEN_SPEED = 10f;
    private static final long SPEEDY_ALIEN_HEALTH = 100;
    private static final long SPEEDY_ALIEN_WIDTH = 10;
    private static final long SPEEDY_ALIEN_HEIGHT = 10;
    private static final long SPEEDY_ALIEN_KILL_MONEY = 70;
    private static final long SPEEDY_ALIEN_KILL_EXPERIENCE = 70;
    private static final String SPEEDY_ALIEN_SPRITE_IMAGE_FILE_NAME = "speedyAlien.png";

    /**
     * Constructs an object of type SpeedyAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     */
    public SpeedyAlien(final long someXPosition, final long someYPosition) {
        super(someXPosition, someYPosition, SPEEDY_ALIEN_WIDTH, SPEEDY_ALIEN_HEIGHT,
                SPEEDY_ALIEN_KILL_MONEY, SPEEDY_ALIEN_KILL_EXPERIENCE, SPEEDY_ALIEN_SPEED, SPEEDY_ALIEN_HEALTH,
                SPEEDY_ALIEN_SPRITE_IMAGE_FILE_NAME);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
