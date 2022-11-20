package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.AbstractWeapon;

/**
 * Represents an object of type Shotgun.
 * Shotguns have high damage at close range, damages multiple aliens per shot and a low fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Shotgun extends AbstractWeapon {
    /**
     * The shotgun damage.
     */
    public static final float DAMAGE = 25f;
    /**
     * The shotgun attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 1f;
    /**
     * If the shotgun can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = true;
    /**
     * The shotgun attack range in pixels.
     */
    public static final long ATTACK_RANGE = 40;
    /**
     * The shotgun cost in the shop.
     */
    public static final long COST = 2500;
    /**
     * The shotgun ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 200;
    /**
     * The shotgun clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 8;
    /**
     * A string representation of the object.
     */
    public static final String NAME = "Shotgun";

    /**
     * Constructs an object of type Shotgun.
     */
    public Shotgun() {
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
