package ca.bcit.comp2522.termproject.pandahamster;

/**
 * Represents an abstract class of type AbstractWeapon.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public abstract class AbstractWeapon extends AbstractShooter {
    private long ammoCapacity;
    private long clipSize;
    private long currentClipCount;
    private float lastAttackTimeInSeconds;

    /**
     * Constructs an object of type AbstractWeapon.
     *
     * @param damage                    the amount of damage the object deals a float
     * @param attackSpeed               the speed of the attack as a float
     * @param shotDamageMultipleEnemies whether the object has AOE damage as a boolean
     * @param attackRange               how far the object can deal damage as a long
     * @param cost                      the cost to purchase the object as a long
     * @param ammoCapacity              the ammo capacity as a long
     * @param clipSize                  the size of the magazine as a long
     * @param name                      the name of the weapon
     */
    public AbstractWeapon(final float damage, final float attackSpeed, final boolean shotDamageMultipleEnemies,
                          final long attackRange, final long cost, final long ammoCapacity, final long clipSize,
                          final String name) {
        super(damage, attackSpeed, shotDamageMultipleEnemies, attackRange, cost, name);
        this.ammoCapacity = ammoCapacity;
        this.clipSize = clipSize;
        this.currentClipCount = clipSize;
    }

    /**
     * Reloads the current magazine.
     */
    public void reload() {
        this.currentClipCount = this.clipSize;
    }
    /**
     * Gets the last attack time for the current weapon in seconds.
     * @return last attack time of current weapon in seconds
     */
    public float getLastAttackTimeInSeconds() {
        return lastAttackTimeInSeconds;
    }
    /**
     * Sets the last attack time in seconds of the current weapon to the specified value.
     * @param lastAttackTimeInSeconds a float representing the time when the current weapon attack was triggered.
     */
    public void setLastAttackTimeInSeconds(final float lastAttackTimeInSeconds) {
        this.lastAttackTimeInSeconds = lastAttackTimeInSeconds;
    }
}
