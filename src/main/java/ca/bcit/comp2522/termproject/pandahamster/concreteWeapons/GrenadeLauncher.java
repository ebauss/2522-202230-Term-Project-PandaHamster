package ca.bcit.comp2522.termproject.pandahamster.concreteWeapons;

import ca.bcit.comp2522.termproject.pandahamster.*;
import ca.bcit.comp2522.termproject.pandahamster.Screens.GameScreen;
import javafx.application.Platform;
import javafx.scene.shape.Circle;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.FixtureDef;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents an object of type GrenadeLauncher.
 * Grenade launchers have high damage, medium range, hit multiple targets and slow fire rate.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class GrenadeLauncher extends AbstractWeapon {
    /**
     * The grenade launcher damage.
     */
    public static final float DAMAGE = 100f;
    /**
     * The grenade launchere attack speed. The time it takes to do a single attack in seconds.
     */
    public static final float ATTACK_SPEED = 1.5f;
    /**
     * If the grenade launcher can hit multiple enemies with a single attack.
     */
    public static final boolean HAS_AOE = true;
    /**
     * The grenade launcher attack range in pixels.
     */
    public static final long ATTACK_RANGE = 200;
    /**
     * The grenade launcher cost in the shop.
     */
    public static final long COST = 4500;
    /**
     * The grenade launcher ammo capacity, total ammo of the grenade launcher.
     */
    public static final long AMMO_CAPACITY = 80;
    /**
     * The grenade launcher clip size, how many shots can be fired before reloading is required.
     */
    public static final long CLIP_SIZE = 5;
    /**
     * A string representation of the name of the object.
     */
    public static final String NAME = "Grenade Launcher";

    /**
     * Constructs an object of type Grenade.
     */
    public GrenadeLauncher() {
        super(DAMAGE, ATTACK_SPEED, HAS_AOE, ATTACK_RANGE, COST, AMMO_CAPACITY, CLIP_SIZE, NAME);
    }

    /**
     * Performs the attack method for a grenade launcher. Shoots a single bullet which will explode in a radius.
     */
    @Override
    public void attack() {
        if (GameTimer.getElapsedSeconds() - getLastAttackTimeInSeconds() >= getAttackSpeed()) {
            setLastAttackTimeInSeconds(GameTimer.getElapsedSeconds());
            Vec2 target = getMouseDirection();
            fireSingleShot(ATTACK_RANGE, new Vec2(MousePositionTracker.getMouseLocation()), target, DAMAGE, 30f, 1f);
        }
    }
}
