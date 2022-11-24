package ca.bcit.comp2522.termproject.pandahamster.aliens;

import ca.bcit.comp2522.termproject.pandahamster.Attacker;
import ca.bcit.comp2522.termproject.pandahamster.DynamicEntity;
import ca.bcit.comp2522.termproject.pandahamster.GameEntity;

/**
 * Contains logic for all enemies.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public abstract class AbstractEnemy extends GameEntity implements Attacker, DynamicEntity {
    private final long killMoneyValue;
    private final long killExperienceValue;

    /**
     * Constructs an object of type AbstractEnemy.
     *
     * @param someXPosition xPosition of class as a long
     * @param someYPosition yPosition of class as a long
     * @param someWidth     width of class as a long
     * @param someHeight    height of class as a long
     * @param someKillMoneyValue the amount of money the player receives for killing the enemy
     * @param someKillExperienceValue the amount of experience the player receives for killing the enemy
     */
    public AbstractEnemy(final long someXPosition, final long someYPosition,
                         final long someWidth, final long someHeight,
                         final long someKillMoneyValue, final long someKillExperienceValue) {
        super(someXPosition, someYPosition, someWidth, someHeight);
        this.killMoneyValue = someKillMoneyValue;
        this.killExperienceValue = someKillExperienceValue;
    }

    /**
     * Gets the killMoneyValue.
     *
     * @return the killMoneyValue as a long
     */
    public long getKillMoneyValue() {
        return killMoneyValue;
    }

    /**
     * Gets the killExperienceValue.
     *
     * @return the killExperienceValue as a long
     */
    public long getKillExperienceValue() {
        return killExperienceValue;
    }

    /**
     * Moves the enemy toward the base.
     */
    @Override
    public void move() {
        DynamicEntity.super.move();
    }
}
