package ca.bcit.comp2522.termproject.pandahamster.aliens;

import ca.bcit.comp2522.termproject.pandahamster.Attacker;
import ca.bcit.comp2522.termproject.pandahamster.GameEntity;

/**
 * Contains logic for all enemies.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public abstract class AbstractEnemy extends GameEntity implements Attacker {
    private long killMoneyValue;
    private long killExperienceValue;

    /**
     * Constructs an object of type AbstractEnemy.
     *
     * @param someXPosition xPosition of class as a long
     * @param someYPosition yPosition of class as a long
     * @param someWidth     width of class as a long
     * @param someHeight    height of class as a long
     */
    public AbstractEnemy(final long someXPosition, final long someYPosition,
                         final long someWidth, final long someHeight,
                         final long someKillMoneyValue, final long someKillExperienceValue) {
        super(someXPosition, someYPosition, someWidth, someHeight);
        this.killMoneyValue = someKillMoneyValue;
        this.killExperienceValue = someKillExperienceValue;
    }
}
