package ca.bcit.comp2522.termproject.pandahamster;

/**
 * Represents an abstract class of type AbstractShooter.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public abstract class AbstractShooter implements Attacker {
    private float damage;
    private float attackSpeed;
    /* If true, that means this object can damage multiple enemies; i.e. Area of Effect Damage. */
    private boolean shotDamageMultipleEnemies;
    private long attackRange;
    /* cost to purchase the object. */
    private long cost;
    private String name;

    /**
     * Constructs an object of type AbstractShooter.
     *
     * @param damage                    the amount of damage the object deals a float
     * @param attackSpeed               the speed of the attack as a float
     * @param shotDamageMultipleEnemies whether the object has AOE damage as a boolean
     * @param attackRange               how far the object can deal damage as a long
     * @param cost                      the cost to purchase the object as a long
     * @param name                      the name of the object
     */
    public AbstractShooter(final float damage, final float attackSpeed, final boolean shotDamageMultipleEnemies,
                           final long attackRange, final long cost, final String name) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.shotDamageMultipleEnemies = shotDamageMultipleEnemies;
        this.attackRange = attackRange;
        this.cost = cost;
        this.name = name;
    }

    /**
     * Gets method for the name variable.
     *
     * @return the name variable
     */
    public String getName() {
        return name;
    }
}
