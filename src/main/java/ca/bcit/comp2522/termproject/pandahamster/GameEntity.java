package ca.bcit.comp2522.termproject.pandahamster;

import org.jbox2d.dynamics.Body;

/**
 * Represents an abstract class of type GameEntity.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public abstract class GameEntity {
    /**
     * The x position of the game entity on the map.
     */
    protected float xPosition;
    /**
     * The y position of the game entity on the map.
     */
    protected float yPosition;
    private final long width;
    private final long height;
    private Body body;

    /**
     * Constructs an object of type GameEntity.
     *
     * @param someXPosition xPosition of class as a long
     * @param someYPosition yPosition of class as a long
     * @param someWidth width of class as a long
     * @param someHeight height of class as a long
     */
    public GameEntity(final long someXPosition, final long someYPosition, final long someWidth, final long someHeight) {
        this.xPosition = someXPosition;
        this.yPosition = someYPosition;
        this.width = someWidth;
        this.height = someHeight;
    }

    /**
     * Gets the xPosition instance variable.
     *
     * @return xPosition of class as a long
     */
    public float getXPosition() {
        return xPosition;
    }

    /**
     * Sets the xPosition instance variable.
     *
     * @param newXPosition of class as a long
     */
    public void setXPosition(final float newXPosition) {
        this.xPosition = newXPosition;
    }

    /**
     * Gets the yPosition instance variable.
     *
     * @return yPosition of class as a long
     */
    public float getYPosition() {
        return yPosition;
    }

    /**
     * Sets the yPosition instance variable.
     *
     * @param newYPosition of class as a long
     */
    public void setYPosition(final float newYPosition) {
        this.yPosition = newYPosition;
    }

    /**
     * Gets the width instance variable.
     *
     * @return width of class as a long
     */
    public long getWidth() {
        return width;
    }

    /**
     * Gets the height instance variable.
     *
     * @return height of class as a long
     */
    public long getHeight() {
        return height;
    }
    /**
     * Gets the body instance variable.
     * @return body instance variable as a Body
     */
    public Body getBody() {
        return body;
    }
    /**
     * Reassigns the body instance variable to the specified body.
     * @param body the new body
     */
    public void setBody(final Body body) {
        this.body = body;
    }
}
