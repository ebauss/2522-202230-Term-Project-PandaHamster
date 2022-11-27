package ca.bcit.comp2522.termproject.pandahamster;

/**
 * Represents an interface of type DynamicEntity.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public interface DynamicEntity {
    /**
     * Moves the object on the map.
     *
     * @param mapHeight the height dimension of the map
     * @param mapWidth the width dimension of the map
     */
    default void move(final float mapHeight, final float mapWidth) { }
    /**
     * Moves the dynamic entity up.
     */
    default void moveUp() { }
    /**
     * Moves the dynamic entity left.
     */
    default void moveLeft() { }
    /**
     * Moves the dynamic entity down.
     */
    default void moveDown() { }
    /**
     * Moves the dynamic entity right.
     */
    default void moveRight() { }
}
