package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.shape.Rectangle;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

/**
 * Represents a bullet.
 */
public class Bullet extends GameEntity {
    private static final ArrayList<Bullet> bullets = new ArrayList<>();
    private GameEntityType originator;
    private Rectangle bulletSprite;
    private Vec2 origin;
    private float maxRange;
    private boolean markedForRemoval;
    /**
     * Makes a new bullet.
     * @param x x
     * @param y y
     */
    public Bullet(final float x, final float y, final float maxRange, final GameEntityType originator) {
        super(x, y, 2, 2);
        bulletSprite = new Rectangle(x, y, 2, 2);
        this.maxRange = maxRange;
        this.originator = originator;
    }

    /**
     * Sets the x position of the bullet, this will also update the position of
     * the bulletSprite.
     * @param x of class as a float
     */
    @Override
    public void setXPosition(final float x) {
        xPosition = x;
        bulletSprite.setX(xPosition);
    }

    /**
     * Sets the y position of the bullet, this will also update the position of
     * the bulletSprite.
     * @param y of class as a long
     */
    @Override
    public void setYPosition(final float y) {
        yPosition = y;
        bulletSprite.setY(y);
    }

    /**
     * Returns the sprite of the bullet.
     * @return the sprite of the bullet as a rectangle.
     */
    public Rectangle getBulletSprite() {
        return bulletSprite;
    }

    /**
     * Returns the origin.
     * @return the origin
     */
    public Vec2 getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of this bullet.
     * @param origin the origin
     */
    public void setOrigin(final Vec2 origin) {
        this.origin = origin;
    }
    /**
     * Returns boolean value of markedForRemoval.
     * @return a boolean
     */
    public boolean markedForRemoval() {
        return markedForRemoval;
    }
    /**
     * Sets the markedForRemoval to the specified value.
     * @param markedForRemoval a boolean
     */
    public void setMarkedForRemoval(final boolean markedForRemoval) {
        this.markedForRemoval = markedForRemoval;
    }

    /**
     * Checks if a bullet has travelled its max range.
     * @return true if it has distance travelled has reached max range
     */
    public boolean reachedMaxRange() {
        return distanceTravelled() >= maxRange;
    }

    /**
     * Determines the distance the bullet has currently travelled.
     * @return the distance
     */
    private float distanceTravelled() {
        Vec2 currentPosition = new Vec2(getXPosition(), getYPosition());
        return MathUtils.distance(currentPosition, origin);
    }
}
