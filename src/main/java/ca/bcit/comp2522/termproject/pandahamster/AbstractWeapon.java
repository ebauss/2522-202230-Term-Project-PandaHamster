package ca.bcit.comp2522.termproject.pandahamster;

import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

import java.util.Timer;
import java.util.TimerTask;

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
        final AbstractWeapon currentWeapon = Player.getInstance().getCurrentWeapon();
        final float timeOfReload = GameTimer.getElapsedSeconds();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // if player switches weapon when reloading, stop reloading
                if (Player.getInstance().getCurrentWeapon() != currentWeapon) {
                    timer.cancel();
                }
                // if one second passed without switching weapon, reload the weapon
                if (GameTimer.getElapsedSeconds() - timeOfReload >= 1) {
                    setCurrentClipCount(getCurrentClipCount());
                    timer.cancel();
                }
            }
        };
        final long period = (long) ((1 / 60f) * 1000);
        // runs the timer task every frame
        timer.schedule(timerTask, 0, period);
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
    public long getCurrentClipCount() {
        return currentClipCount;
    }
    public void setCurrentClipCount(final long currentClipCount) {
        // get amount required to fill magazine back to full
        long amountToReload = clipSize - currentClipCount;
        // check if there is enough ammo to fill the clip back up
        if (amountToReload > ammoCapacity) {
            // if there isn't, the amount to reload will just be whatever ammo is left
            amountToReload = ammoCapacity;
        }
        // decrease ammo by how much was filled in the magazine
        ammoCapacity -= amountToReload;
        // fill up the clip
        this.currentClipCount = currentClipCount + amountToReload;
        System.out.println("amount reloaded: " + amountToReload);
    }
    public long getClipSize() {
        return clipSize;
    }

    public long getAmmoCapacity() {
        return ammoCapacity;
    }
    public void setAmmoCapacity(long ammoCapacity) {
        this.ammoCapacity = ammoCapacity;
    }

    /**
     * Gets the direction vector of the mouse in relation to the center of the player.
     * @return the direction vector
     */
    public Vec2 getMouseDirection() {
        Vec2 playerPos = new Vec2(Player.getInstance().getXPosition() + Player.getInstance().getWidth()
                / 2f, Player.getInstance().getYPosition() + Player.getInstance().getHeight() / 2f);
        // get the position of the mouse
        Vec2 mousePos = new Vec2(MousePositionTracker.getMouseLocation());
        // calculate target position
        return mousePos.sub(playerPos);
    }

    /**
     * Fires a single bullet in the direction of the mouse. Should only be used by weapons that just require a single
     * bullet to be fired in the direction of the mouse.
     * @param attackRange attack range of the weapon this method
     * @param vecForMag vector to use to calculate magnitude
     * @param target the direction vector of where to fire the bullet
     */
    public void fireSingleShot(final float attackRange, final Vec2 vecForMag, final Vec2 target) {
        decreaseCurrentClip(1);
        Vec2 playerPos = new Vec2(Player.getInstance().getXPosition() + Player.getInstance().getWidth()
                / 2f, Player.getInstance().getYPosition() + Player.getInstance().getHeight() / 2f);
        Bullet bullet = new Bullet(playerPos.x, playerPos.y, attackRange, GameEntityType.Player);
        bullet.setOrigin(new Vec2(bullet.getXPosition(), bullet.getYPosition()));
        BulletManager.addBullets(bullet);
        bullet.getBody().getFixtureList().m_isSensor = true;
        applyVelocity(bullet, vecForMag, target);
    }

    /**
     * Sets the bullet's linear velocity in the target direction. Only for weapons that shoot a single bullet.
     * @param bullet the bullet to move
     * @param vecForMag vector for calculating the magnitude
     * @param target the direction to fire
     */
    public void applyVelocity(final Bullet bullet, final Vec2 vecForMag, final Vec2 target) {
        // get the length of the vector
        float targetMag = MathUtils.sqrt(vecForMag.x * vecForMag.x + vecForMag.y * vecForMag.y);
        // get the unit vector to apply impulses
        Vec2 normalized = new Vec2(target.x / targetMag, target.y / targetMag);
        final int speed = 500;
        bullet.getBody().setLinearVelocity(normalized.mul(speed));
    }
    /**
     * Creates a bullet effect when a bullet has hit an obstacle or enemy.
     * @param bullet the bullet for the effect
     */
    public abstract void createBulletEffect(Bullet bullet);
    private void decreaseCurrentClip(final int bulletsShot) {
        currentClipCount -= bulletsShot;
    }
}
