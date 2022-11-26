package ca.bcit.comp2522.termproject.pandahamster.aliens;

import ca.bcit.comp2522.termproject.pandahamster.Attacker;
import ca.bcit.comp2522.termproject.pandahamster.DynamicEntity;
import ca.bcit.comp2522.termproject.pandahamster.GameEntity;
import javafx.scene.shape.Rectangle;

/**
 * Contains logic for all enemies.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public abstract class AbstractEnemy extends GameEntity implements Attacker, DynamicEntity {
    private final long killMoneyValue;
    private final long killExperienceValue;
    private final float speed;
    private long healthPoints;
    private Rectangle alienSprite;

    /**
     * Constructs an object of type AbstractEnemy.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     * @param someWidth               width of class as a long
     * @param someHeight              height of class as a long
     * @param someKillMoneyValue      the amount of money the player receives for killing the enemy
     * @param someKillExperienceValue the amount of experience the player receives for killing the enemy
     * @param someSpeed               the speed of the alien
     * @param someHealthPoints        the health of the alien
     */
    public AbstractEnemy(final long someXPosition, final long someYPosition,
                         final long someWidth, final long someHeight,
                         final long someKillMoneyValue, final long someKillExperienceValue, final float someSpeed,
                         final long someHealthPoints) {
        super(someXPosition, someYPosition, someWidth, someHeight);
        this.killMoneyValue = someKillMoneyValue;
        this.killExperienceValue = someKillExperienceValue;
        this.speed = someSpeed;
        this.healthPoints = someHealthPoints;
        alienSprite = new Rectangle(100, 100, 16, 16);
    }

    /**
     * Gets the alienSprite Rectangle object.
     *
     * @return the alien Rectangle object
     */
    public Rectangle getAlienSprite() {
        return alienSprite;
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
    public void move(final float mapHeight, final float mapWidth) {
        DynamicEntity.super.move(mapHeight, mapWidth);
        // The center of the map contains the base. The aliens need to move towards the base.
        final float centerXPosition = mapWidth / 2;
        final float centerYPosition = mapHeight / 2;
    }
}
