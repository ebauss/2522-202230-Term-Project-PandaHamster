package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.*;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

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
    public static final long ATTACK_RANGE = 400;
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
     * Performs the attack method for a shotgun. Shoots a fan of bullets in the direction of the mouse.
     */
    @Override
    public void attack() {
        if (GameTimer.getElapsedSeconds() - getLastAttackTimeInSeconds() >= getAttackSpeed()) {
            setLastAttackTimeInSeconds(GameTimer.getElapsedSeconds());
            Vec2 playerPos = new Vec2(Player.getInstance().getXPosition() + Player.getInstance().getWidth()
                    / 2f, Player.getInstance().getYPosition() + Player.getInstance().getHeight() / 2f);
            Vec2 target = getMouseDirection();
            /*
                Since each bullet will be (15, 15) away from each other, subtract 45 so the center bullet is
                where mouse position was when pressed. Bullets will be initially placed in a cone arrangement.
             */
            final float bulletDistance = 15;
            final int totalPellets = 5;
            final int middlePellet = totalPellets / 2 + 1;
            Vec2 start = target.sub(
                    new Vec2(bulletDistance * (middlePellet), bulletDistance * (middlePellet)));
            for (int i = 0; i < totalPellets; i++) {
                // first 3 bullets will be first half of the cone
                if (i < totalPellets / 2 + 1) {
                    start = start.add(new Vec2(bulletDistance, bulletDistance));
                } else {
                    start = start.sub(new Vec2(0, bulletDistance));
                }
                fireSingleShot(ATTACK_RANGE, start, start);
            }
        }
    }

    @Override
    public void createBulletEffect(Bullet bullet) {

    }
}
