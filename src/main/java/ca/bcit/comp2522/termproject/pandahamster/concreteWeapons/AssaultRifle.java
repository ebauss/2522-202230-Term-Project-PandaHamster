package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.AbstractWeapon;

/**
 * Represents an object of type AssaultRifle.
 * ARs have medium damage at medium range, can damage a single target only and a medium fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class AssaultRifle extends AbstractWeapon {
    /**
     * The assault rifle damage.
     */
    public static final float DAMAGE = 5f;
    /**
     * The assault rifle attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 0.1f;
    /**
     * If the assault rifle can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = false;
    /**
     * The assault rifle attack range in pixels.
     */
    public static final long ATTACK_RANGE = 100;
    /**
     * The assault rifle cost in the shop.
     */
    public static final long COST = 1000;
    /**
     * The assault rifle ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 600;
    /**
     * The assault rifle clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 30;

    /**
     * A string representation of the name of the class.
     */
    public static final String NAME = "Assault Rifle";
    /**
     * Constructs an object of type AssaultRifle.
     */
    public AssaultRifle() {
        super(DAMAGE, ATTACK_SPEED, HAS_AOE, ATTACK_RANGE, COST, AMMO_CAPACITY, CLIP_SIZE, NAME);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {
        // TODO Implement this
    }
}
