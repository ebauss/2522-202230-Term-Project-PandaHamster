package ca.bcit.comp2522.termproject.pandahamster;

import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import org.jbox2d.common.Vec2;
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
    private final float speed = 20f;

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
        // allows the rectangle to 'listen' to key events
        playerSprite.setFocusTraversable(true);
        playerSprite.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W -> moveUp();
                case A -> moveLeft();
                case S -> moveDown();
                case D -> moveRight();
                default -> { }
            }
        });
        playerSprite.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            switch (event.getCode()) {
                // when a movement key is released, stop the player from moving
                case W, A, S, D -> getBody().setLinearVelocity(new Vec2(0, 0));
                default -> { }
            }
        });
    }

    /**
     * Gets the money value.
     *
     * @return the amount of money the player has.
     */
    public long getMoney() {
        return money;
    }

    /**
     * Sets the money value.
     *
     * @param money the amount of money the player has as a long
     */
    public void setMoney(final long money) {
        this.money = money;
    }

    /**
     * Sets the x position of this player. The player rectangle position
     * will also be updated accordingly.
     * @param xPosition of class as a long
     */
    @Override
    public void setXPosition(final float xPosition) {
        super.xPosition = xPosition;
        playerSprite.setX(xPosition);
    }
    /**
     * Sets the y position of this player. The player rectangle position
     * * will also be updated accordingly.
     * @param yPosition of class as a long
     */
    @Override
    public void setYPosition(final float yPosition) {
        super.yPosition = yPosition;
        playerSprite.setY(yPosition);
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
     * Moves the player up on the screen.
     */
    @Override
    public void moveUp() {
        getBody().setLinearVelocity(new Vec2(0, -speed));
    }
    /**
     * Moves the player left on the screen.
     */
    @Override
    public void moveLeft() {
        getBody().setLinearVelocity(new Vec2(-speed, 0));
    }
    /**
     * Moves the player down on the screen.
     */
    @Override
    public void moveDown() {
        getBody().setLinearVelocity(new Vec2(0, speed));
    }
    /**
     * Moves the player right on the screen.
     */
    @Override
    public void moveRight() {
        getBody().setLinearVelocity(new Vec2(speed, 0));
    }

    /**
     * Adds a new weapon to the weaponInventory.
     */
    public void addWeaponIntoInventory(final AbstractWeapon newWeapon) {
        weaponInventory.add(newWeapon);
    }
}
