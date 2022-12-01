package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type FodderAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class FodderAlien extends AbstractEnemy {
    private static final float FODDER_ALIEN_SPEED = 10f;
    private static final long FODDER_ALIEN_HEALTH = 100;
    private static final long FODDER_ALIEN_WIDTH = 16;
    private static final long FODDER_ALIEN_HEIGHT = 16;
    private static final long FODDER_ALIEN_KILL_MONEY = 50;
    private static final long FODDER_ALIEN_KILL_EXPERIENCE = 50;

    /**
     * Constructs an object of type FodderAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     */
    public FodderAlien(final long someXPosition, final long someYPosition) {
        super(someXPosition, someYPosition, FODDER_ALIEN_WIDTH, FODDER_ALIEN_HEIGHT,
                FODDER_ALIEN_KILL_MONEY, FODDER_ALIEN_KILL_EXPERIENCE, FODDER_ALIEN_SPEED, FODDER_ALIEN_HEALTH);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
