package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.AbstractWeapon;
import ca.bcit.comp2522.termproject.pandahamster.Bullet;
import ca.bcit.comp2522.termproject.pandahamster.GameTimer;
import ca.bcit.comp2522.termproject.pandahamster.MousePositionTracker;
import org.jbox2d.common.Vec2;

/**
 * Represents an object of type Sniper.
 * Snipers have high damage at long range, can attack a single target only and a low fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Sniper extends AbstractWeapon {
    /**
     * The sniper damage.
     */
    public static final float DAMAGE = 1000f;
    /**
     * The sniper attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 2f;
    /**
     * If the sniper can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = false;
    /**
     * The sniper attack range in pixels.
     */
    public static final long ATTACK_RANGE = 500;
    /**
     * The sniper cost in the shop.
     */
    public static final long COST = 4500;
    /**
     * The sniper ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 60;
    /**
     * The sniper clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 5;
    /**
     * A string representation of the object.
     */
    public static final String NAME = "Sniper";

    /**
     * Constructs an object of type Sniper.
     */
    public Sniper() {
        super(DAMAGE, ATTACK_SPEED, HAS_AOE, ATTACK_RANGE, COST, AMMO_CAPACITY, CLIP_SIZE, NAME);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {
        if (GameTimer.getElapsedSeconds() - getLastAttackTimeInSeconds() >= getAttackSpeed()) {
            setLastAttackTimeInSeconds(GameTimer.getElapsedSeconds());
            Vec2 target = getMouseDirection();
            fireSingleShot(ATTACK_RANGE, MousePositionTracker.getMouseLocation(), target, DAMAGE);
        }
    }

    @Override
    public void createBulletEffect(Bullet bullet) {

    }
}
