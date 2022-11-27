package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.*;
import javafx.scene.image.ImageView;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

/**
 * Represents an object of type Pistol.
 * Pistols have medium damage at medium range, can damage a single target only and a low fire rate.
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Pistol extends AbstractWeapon {
    /**
     * The pistol damage.
     */
    public static final float DAMAGE = 5f;
    /**
     * The pistol attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 0.5f;
    /**
     * If the pistol can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = false;
    /**
     * The pistol attack range in pixels.
     */
    public static final long ATTACK_RANGE = 200;
    /**
     * The pistol cost in the shop.
     */
    public static final long COST = 0;
    /**
     * The pistol ammo capacity, total ammo of the assault rifle.
     */
    public static final long AMMO_CAPACITY = 100;
    /**
     * The pistol clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 8;

    /**
     * A string representation of the name of the class.
     */
    public static final String NAME = "Pistol";
    /**
     * Constructs an object of type Pistol.
     */
    public Pistol() {
        super(DAMAGE, ATTACK_SPEED, HAS_AOE, ATTACK_RANGE, COST, AMMO_CAPACITY, CLIP_SIZE, NAME);
    }

    /**
     * Performs the attack method for a pistol. Shoots a single bullet in the direction of the mouse.
     */
    @Override
    public void attack() {
        if (GameTimer.getElapsedSeconds() - getLastAttackTimeInSeconds() >= getAttackSpeed()) {
            setLastAttackTimeInSeconds(GameTimer.getElapsedSeconds());
            Vec2 targetPos = getMouseDirection();
            fireSingleShot(ATTACK_RANGE, targetPos);
        }
    }

    @Override
    public void createBulletEffect(Bullet bullet) {

    }
}
