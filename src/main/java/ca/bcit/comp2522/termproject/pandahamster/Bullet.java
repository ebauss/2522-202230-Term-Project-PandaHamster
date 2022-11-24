package ca.bcit.comp2522.termproject.pandahamster;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.contacts.Contact;

import java.util.ArrayList;

public class Bullet extends GameEntity implements ContactListener {
    private static final ArrayList<Bullet> bullets = new ArrayList<>();
    private Rectangle bulletSprite;
    private Point2D bulletOrigin;
    private float distanceTravelled;
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
    public Point2D getBulletOrigin() {
        return bulletOrigin;
    }

    /**
     * Adds the bullet to the map and world.
     */
    public void addToGame() {
        bulletOrigin = new Point2D(getXPosition(), getYPosition());
        this.inWorld = true;
        bullets.add(this);
        PandaHamster.getGroup().getChildren().add(this.getBulletSprite());
        WorldManager.getInstance().createDynamicRectangle(this, 0.2f);
    }
    /**
    Remove bullets when a bullet hits a valid collidable object.
     */
    public static void removeFromGame() {
        for (Bullet bullet: bullets) {
            if (bullet.getBulletOrigin().distance(bullet.getXPosition(), bullet.getYPosition()) > 600) {
                WorldManager.getInstance().removeBody(bullet.getBody());
                PandaHamster.getGroup().getChildren().remove(bullet.getBulletSprite());
            }
        }
    }

    @Override
    public void beginContact(final Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

    }

    @Override
    public void endContact(final Contact contact) {

    }

    @Override
    public void preSolve(final Contact contact, final Manifold manifold) {

    }

    @Override
    public void postSolve(final Contact contact, final ContactImpulse contactImpulse) {

    }
}
