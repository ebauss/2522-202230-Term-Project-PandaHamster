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
     */
    default void move() { }
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
