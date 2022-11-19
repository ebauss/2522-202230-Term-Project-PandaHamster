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
     * Constructs an object of type Shotgun.
     *
     * @param damage the amount of damage the object deals a float
     * @param attackSpeed the speed of the attack as a float
     * @param shotDamageMultipleEnemies whether the object has AOE damage as a boolean
     * @param attackRange how far the object can deal damage as a long
     * @param cost the cost to purchase the object as a long
     * @param ammoCapacity the ammo capacity as a long
     * @param clipSize the size of the magazine as a long
     */
    public Shotgun(final float damage, final float attackSpeed, final boolean shotDamageMultipleEnemies,
                   final long attackRange, final long cost, final long ammoCapacity, final long clipSize) {
        // TODO Remove parameters in constructor and create final immutable values for parameters in super()
        super(damage, attackSpeed, shotDamageMultipleEnemies, attackRange, cost, ammoCapacity, clipSize);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {
        // TODO Implement this
    }
}
