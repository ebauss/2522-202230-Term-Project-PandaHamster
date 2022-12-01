package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type TankAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class TankAlien extends AbstractEnemy {
    private static final float TANK_ALIEN_SPEED = 10f;
    private static final long TANK_ALIEN_HEALTH = 100;
    private static final long TANK_ALIEN_WIDTH = 30;
    private static final long TANK_ALIEN_HEIGHT = 30;
    private static final long TANK_ALIEN_KILL_MONEY = 100;
    private static final long TANK_ALIEN_KILL_EXPERIENCE = 100;

    /**
     * Constructs an object of type TankAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     */
    public TankAlien(final long someXPosition, final long someYPosition) {
        super(someXPosition, someYPosition, TANK_ALIEN_WIDTH, TANK_ALIEN_HEIGHT,
                TANK_ALIEN_KILL_MONEY, TANK_ALIEN_KILL_EXPERIENCE, TANK_ALIEN_SPEED, TANK_ALIEN_HEALTH);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
