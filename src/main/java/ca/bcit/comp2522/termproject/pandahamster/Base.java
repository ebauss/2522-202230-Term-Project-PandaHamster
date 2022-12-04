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
    private boolean isAlienDamagingBase;
    // TODO Implement towers so that you can uncomment this.
//    private ArrayList<AbstractTower> towerCollection;

    /**
     * Constructs an object of type Base.
     */
    public Base() {
        this.health = 3000;
        this.isAlienDamagingBase = false;
    }

    /**
     * Gets the variable.
     *
     * @return a boolean
     */
    public boolean isAlienDamagingBase() {
        return isAlienDamagingBase;
    }

    /**
     * Sets the variables
     *
     * @param alienDamagingBase a boolean
     */
    public void setAlienDamagingBase(final boolean alienDamagingBase) {
        isAlienDamagingBase = alienDamagingBase;
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
