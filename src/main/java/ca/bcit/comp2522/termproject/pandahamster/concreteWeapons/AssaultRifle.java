package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.*;
import javafx.geometry.Point2D;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

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
    public static final long ATTACK_RANGE = 300;
    /**
     * The assault rifle cost in the shop.
     */
    public static final long COST = 1000;
    // TODO A few of these might not need to be contants since they need to change. I.e ammo capacity.
    // TODO Possibly add a constant that stores the value of the Maximum ammo capacity for that weapon.
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
     * Performs the attack method for an assault rifle. Shoots a single bullet in the direction of the mouse.
     */
    @Override
    public void attack() {
        if (GameTimer.getElapsedSeconds() - getLastAttackTimeInSeconds() >= getAttackSpeed()) {
            setLastAttackTimeInSeconds(GameTimer.getElapsedSeconds());
            Vec2 target = getMouseDirection();
            fireSingleShot(ATTACK_RANGE, MousePositionTracker.getMouseLocation(), target, DAMAGE, 5f, 0.1f);
        }
    }
}
