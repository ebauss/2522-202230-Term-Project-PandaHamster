package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.shape.Rectangle;
import org.jbox2d.dynamics.Body;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an object of type Player.
 *
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public class Player extends GameEntity implements DynamicEntity {
    private static final long MAX_LEVEL = 20;
    private static final int THREE = 3;
    private static final int ONE_HUNDRED = 100;
    private String name;
    private long level;
    private long currentExp;
    private long money;
    // TODO make AbstractWeapon so that the line below can be uncommented
    private List<AbstractWeapon> weaponInventory;
    private AbstractWeapon currentWeapon;
    private short lifeCount;
    private Rectangle playerSprite;

    /**
     * Constructs a Player object.
     *
     * @param someName the name of the player as a String
     */
    public Player(final String someName) {
        super(0, 0, 16, 16);
        this.name = someName;
        this.level = 1;
//        weaponInventory = new ArrayList<>();
        this.lifeCount = THREE;
        this.money = ONE_HUNDRED;
        playerSprite = new Rectangle(0, 0 , 16, 16);
    }

    /**
     * Gets the name instance variable.
     *
     * @return name instance variable as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the playerSprite instance variable.
     * @return playerSprite instance variable as a Rectangle
     */
    public Rectangle getPlayerSprite() {
        return playerSprite;
    }

    /* Calls attack() method for currentWeapon. */
    private void pullTrigger() {
        this.currentWeapon.attack();
    }

    /* Calls reload() method for currentWeapon. */
    private void reloadWeapon() {
        this.currentWeapon.reload();
    }

    /**
     * Moves the player along the map.
     *
     * <p>
     * Uses the WASD keys to move the player. W to move forward. A to move left.
     * D to move right. S to move backward.
     * </p>
     */
    @Override
    public void move() {

    }
}
