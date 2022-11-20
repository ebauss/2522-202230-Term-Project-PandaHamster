package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.AbstractWeapon;

/**
 * Represents an object of type Grenade.
 * Grenades have high damage, medium range, hit multiple targets and slow fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Grenade extends AbstractWeapon {
    /**
     * The grenade damage.
     */
    public static final float DAMAGE = 50f;
    /**
     * The grenade attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 1.5f;
    /**
     * If the grenade can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = true;
    /**
     * The grenade attack range in pixels.
     */
    public static final long ATTACK_RANGE = 75;
    /**
     * The grenade cost in the shop.
     */
    public static final long COST = 4500;
    /**
     * The grenade ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 80;
    /**
     * The grenade clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 5;
    /**
     * A string representation of the name of the object.
     */
    public static final String NAME = "Grenade";

    /**
     * Constructs an object of type Grenade.
     */
    public Grenade() {
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
