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
            // get the position of the mouse
            Vec2 mousePos = new Vec2(
                    (float) MousePositionTracker.getMouseLocation().getX(),
                    (float) MousePositionTracker.getMouseLocation().getY());
            Vec2 target = mousePos.sub(playerPos);
            Vec2 start = target.sub(new Vec2(45, 45));
            for (int i = 0; i < 5; i++) {
                if (i < 3) {
                    start = start.add(new Vec2(15, 15));
                } else if (i >= 3){
                    start = start.sub(new Vec2(0, 15));
                }
                Bullet bullet = new Bullet(playerPos.x, playerPos.y, ATTACK_RANGE);
                bullet.setOrigin(new Vec2(playerPos.x, playerPos.y));
                bullet.getBulletSprite().setRotate(30);
                BulletManager.addBullets(bullet);
                float targetMag = MathUtils.sqrt(start.x * start.x + start.y * start.y);
                // get the unit vector to apply linear velocity
                Vec2 normalized = new Vec2(start.x / targetMag, start.y / targetMag);
                bullet.getBody().setLinearVelocity(normalized.mul(500));
                System.out.println(start);
            }
        }
    }
}
