package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.AbstractWeapon;

/**
 * Represents an object of type SubMachineGun.
 * SMGs have low damage at low range, can damage a single target only and fast fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class SubMachineGun extends AbstractWeapon {
    /**
     * The SMG damage.
     */
    public static final float DAMAGE = 3f;
    /**
     * The SMG attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 0.05f;
    /**
     * If the SMG can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = false;
    /**
     * The SMG attack range in pixels.
     */
    public static final long ATTACK_RANGE = 75;
    /**
     * The SMG cost in the shop.
     */
    public static final long COST = 1500;
    /**
     * The SMG ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 1200;
    /**
     * The SMG clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 100;
    /**
     * Constructs an object of type SubMachineGun.
     */
    public SubMachineGun() {
        super(DAMAGE, ATTACK_SPEED, HAS_AOE, ATTACK_RANGE, COST, AMMO_CAPACITY, CLIP_SIZE);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {
        // TODO Implement this
    }
}
