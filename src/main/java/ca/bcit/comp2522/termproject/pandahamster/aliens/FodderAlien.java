package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type FodderAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class FodderAlien extends AbstractEnemy {
    /**
     * Constructs an object of type FodderAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     * @param someWidth               width of class as a long
     * @param someHeight              height of class as a long
     * @param someKillMoneyValue the amount of money the player receives for killing the enemy
     * @param someKillExperienceValue the amount of experience the player receives for killing the enemy
     * @param someSpeed               the speed of the alien
     * @param someHealthPoints        the health of the alien
     */
    public FodderAlien(final long someXPosition, final long someYPosition,
                       final long someWidth, final long someHeight,
                       final long someKillMoneyValue, final long someKillExperienceValue, final float someSpeed,
                       final long someHealthPoints) {
        super(someXPosition, someYPosition, someWidth, someHeight, someKillMoneyValue, someKillExperienceValue,
                someSpeed, someHealthPoints);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
