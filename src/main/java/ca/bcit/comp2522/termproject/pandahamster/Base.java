package ca.bcit.comp2522.termproject.pandahamster;

import java.util.ArrayList;

/**
 * Contains all logic for the base.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class Base {
    private long health;
    private int alienAttackCounter;
    // TODO Implement towers so that you can uncomment this.
//    private ArrayList<AbstractTower> towerCollection;

    /**
     * Constructs an object of type Base.
     */
    public Base() {
        this.health = 3000;
        this.alienAttackCounter = 0;
    }

    public int getAlienAttackCounter() {
        return alienAttackCounter;
    }

    public void incrementAlienAttackCounter() {
        this.alienAttackCounter++;
    }

    public void resetAlienAttackCounter() {
        this.alienAttackCounter = 0;
    }

    /**
     * Gets the base health.
     *
     * @return base health
     */
    public long getHealth() {
        return health;
    }

    /**
     * Reduces the base health;
     */
    public void reduceBaseHealth() {
        this.health -= 100;
    }

    /**
     * Resets the health of the base.
     */
    public void resetBaseHeatlh() {
        this.health = 3000;
     }
}
