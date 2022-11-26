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
    private Rectangle bulletSprite;
    private Vec2 origin;
    private float maxRange;
    /**
     * Makes a new bullet.
     * @param x x
     * @param y y
     */
    public Bullet(final float x, final float y) {
        super(x, y, 2, 2);
        bulletSprite = new Rectangle(x, y, 2, 2);
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
     * Checks if a bullet has travelled its max range.
     * @return true if it has distance travelled has reached max range
     */
    public boolean reachedMaxRange() {
        return distanceTravelled() >= maxRange;
    }

    /**
     * Determines the current distance travelled using Pythogoreas Theorem.
     * @return the distance
     */
    private float distanceTravelled() {
        Vec2 currentPosition = new Vec2(getXPosition(), getYPosition());
        Vec2 travelled = currentPosition.sub(origin);
        return MathUtils.sqrt((travelled.x * travelled.y) + (travelled.y * travelled.y));
    }
}
