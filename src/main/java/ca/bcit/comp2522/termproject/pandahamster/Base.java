package ca.bcit.comp2522.termproject.pandahamster;

import java.util.ArrayList;

/**
 * Contains all logic for the base.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class Base {
    private static final long MAX_HEALTH = 3000;
    private long health;
    private int alienAttackCounter;
    private static Base base;
    // TODO Implement towers so that you can uncomment this.
//    private ArrayList<AbstractTower> towerCollection;

    /**
     * Constructs an object of type Base.
     */
    private Base() {
        this.health = MAX_HEALTH;
        this.alienAttackCounter = 0;
    }
    public static Base getInstance() {
        if (base == null) {
            base = new Base();
        }
        return base;
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

    public void setHealth(final long health) {
        this.health = health;
    }

    public static long getMaxHealth() {
        return MAX_HEALTH;
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
        this.health = MAX_HEALTH;
     }
}
