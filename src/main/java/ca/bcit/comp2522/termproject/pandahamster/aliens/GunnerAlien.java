package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type GunnerAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class GunnerAlien extends AbstractEnemy {
    private static final float GUNNER_ALIEN_SPEED = 10f;
    private static final long GUNNER_ALIEN_HEALTH = 100;

    /**
     * Constructs an object of type GunnerAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     * @param someWidth               width of class as a long
     * @param someHeight              height of class as a long
     * @param someKillMoneyValue the amount of money the player receives for killing the enemy
     * @param someKillExperienceValue the amount of experience the player receives for killing the enemy
     */
    public GunnerAlien(final long someXPosition, final long someYPosition,
                       final long someWidth, final long someHeight,
                       final long someKillMoneyValue, final long someKillExperienceValue) {
        super(someXPosition, someYPosition, someWidth, someHeight, someKillMoneyValue, someKillExperienceValue,
                GUNNER_ALIEN_SPEED, GUNNER_ALIEN_HEALTH);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}