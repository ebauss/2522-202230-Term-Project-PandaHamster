package ca.bcit.comp2522.termproject.pandahamster;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;

import java.util.ArrayList;

public class Bullet extends GameEntity {
    private static final ArrayList<Bullet> bullets = new ArrayList<>();
    private Rectangle bulletSprite;
    private Vec2 origin;
    private float maxRange;
    private boolean inWorld = false;
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
    public Vec2 getBulletOrigin() {
        return origin;
    }

    /**
     * Returns true if bullet has reached the max range.
     * @return
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
