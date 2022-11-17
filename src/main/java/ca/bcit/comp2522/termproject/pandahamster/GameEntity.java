package ca.bcit.comp2522.termproject.pandahamster;

/**
 * Represents an abstract class of type GameEntity.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public abstract class GameEntity {
    private long xPosition;
    private long yPosition;
    private final long width;
    private final long height;

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
    public long getXPosition() {
        return xPosition;
    }

    /**
     * Sets the xPosition instance variable.
     *
     * @param newXPosition of class as a long
     */
    public void setXPosition(final long newXPosition) {
        this.xPosition = newXPosition;
    }

    /**
     * Gets the yPosition instance variable.
     *
     * @return yPosition of class as a long
     */
    public long getYPosition() {
        return yPosition;
    }

    /**
     * Sets the yPosition instance variable.
     *
     * @param newYPosition of class as a long
     */
    public void setYPosition(final long newYPosition) {
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
}
