package ca.bcit.comp2522.termproject.pandahamster.aliens;

import ca.bcit.comp2522.termproject.pandahamster.Attacker;
import ca.bcit.comp2522.termproject.pandahamster.DynamicEntity;
import ca.bcit.comp2522.termproject.pandahamster.GameEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jbox2d.common.Vec2;

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
    private final ImageView alienSprite;

    /**
     * Constructs an object of type AbstractEnemy.
     *
     * @param someXPosition            xPosition of class as a long
     * @param someYPosition            yPosition of class as a long
     * @param someWidth                width of class as a long
     * @param someHeight               height of class as a long
     * @param someKillMoneyValue       the amount of money the player receives for killing the enemy
     * @param someKillExperienceValue  the amount of experience the player receives for killing the enemy
     * @param someSpeed                the speed of the alien
     * @param someHealthPoints         the health of the alien
     * @param someAlienSpriteImageFileName the file name of the image
     */
    public AbstractEnemy(final long someXPosition, final long someYPosition,
                         final long someWidth, final long someHeight,
                         final long someKillMoneyValue, final long someKillExperienceValue, final float someSpeed,
                         final long someHealthPoints, final String someAlienSpriteImageFileName) {
        super(someXPosition, someYPosition, someWidth, someHeight);
        this.killMoneyValue = someKillMoneyValue;
        this.killExperienceValue = someKillExperienceValue;
        this.speed = someSpeed;
        this.healthPoints = someHealthPoints;
        this.xPosition = someXPosition;
        this.yPosition = someYPosition;
        alienSprite = new ImageView(new Image(someAlienSpriteImageFileName));
        alienSprite.setFitHeight(someHeight);
        alienSprite.setFitWidth(someWidth);
    }

    /**
     * Gets the healthPoints variable.
     *
     * @return the healthPoints of the alien as a long
     */
    public long getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets the healthPoints variable.
     *
     * @param healthPoints the health of the alien as a long
     */
    public void setHealthPoints(final long healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Sets the x position of this alien. The alien rectangle position will also be updated accordingly.
     * @param newXPosition of class as a long
     */
    @Override
    public void setXPosition(final float newXPosition) {
        super.xPosition = newXPosition;
        alienSprite.setX(xPosition);
    }

    /**
     * Sets the y position of this alien. The alien rectangle position will also be updated accordingly.
     * @param newYPosition of class as a long
     */
    @Override
    public void setYPosition(final float newYPosition) {
        super.yPosition = newYPosition;
        alienSprite.setY(yPosition);

    }

    /**
     * Gets the alienSprite Rectangle object.
     *
     * @return the alien Rectangle object
     */
    public ImageView getAlienSprite() {
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

        // Move the alien towards the base using a bunch of vector algebra.
        Vec2 baseVector = new Vec2(mapWidth/2, (mapHeight)/2);
        Vec2 enemyVector = new Vec2(xPosition, yPosition);
        Vec2 directionVector = baseVector.sub(enemyVector);

        Vec2 unitVector = new Vec2(directionVector.x / directionVector.length(),
                directionVector.y / directionVector.length());

        getBody().setLinearVelocity(unitVector.mul(speed));
    }
}
