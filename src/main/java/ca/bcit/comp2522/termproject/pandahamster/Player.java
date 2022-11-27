package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.concreteWeapons.Pistol;
import ca.bcit.comp2522.termproject.pandahamster.concreteWeapons.Shotgun;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;

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
    private static Player player;
    private String name;
    private long level;
    private long currentExp;
    private long money;
    // TODO make AbstractWeapon so that the line below can be uncommented
    private List<AbstractWeapon> weaponInventory;
    private AbstractWeapon currentWeapon;
    private short lifeCount;
    private Rectangle playerSprite;
    private final float speed = 40f;
    private final float angularVelocity = 10;

    /**
     * Constructs a Player object.
     *
     * @param someName the name of the player as a String
     */
    private Player(final String someName) {
        super(0, 0, 16, 16);
        this.name = someName;
        this.level = 1;
        this.lifeCount = THREE;
        this.money = ONE_HUNDRED;
        weaponInventory = new ArrayList<>();
        AbstractWeapon pistol = new Shotgun();
        weaponInventory.add(pistol);
        currentWeapon = pistol;
        playerSprite = new Rectangle(0, 0 , 16, 16);
        // allows the rectangle to 'listen' to key events
        playerSprite.setFocusTraversable(true);
        playerSprite.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case W -> moveUp();
                case A -> moveLeft();
                case S -> moveDown();
                case D -> moveRight();
                case LEFT -> rotateCounterClockwise();
                case RIGHT -> rotateClockwise();
                default -> { }
            }
        });
        playerSprite.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            switch (event.getCode()) {
                // when a movement key is released, stop the player from moving
                case W, A, S, D -> getBody().setLinearVelocity(new Vec2(0, 0));
                case LEFT, RIGHT -> getBody().setAngularVelocity(0);
                default -> { }
            }
        });
    }

    /**
     * Returns an instance of the player. Subsequent calls will return the same player.
     * @return the player instance
     */
    public static Player getInstance() {
        if (player == null) {
            player = new Player("");
        }
        return player;
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

    /**
     * Calls the attack() method for currentWeapon.
     */
    public void pullTrigger() {
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
     * Rotates the player clockwise on the screen.
     */
    public void rotateClockwise() {
        getBody().setAngularVelocity(-angularVelocity);
        playerSprite.setRotate(getBody().getAngle());
    }

    /**
     * Rotates the player counter-clockwise on the screen.
     */
    public void rotateCounterClockwise() {
        getBody().setAngularVelocity(angularVelocity);
        playerSprite.setRotate(getBody().getAngle());
    }

    /**
     * Aligns the player to face the direction of the mouse.
     */
    public void faceMouseDirection() {
        // convert the player position to jBox2D position (center is x and y)
        Vec2 playerPos = new Vec2(xPosition + getWidth()
                / 2f, yPosition + getHeight() / 2f);
        // get the position of the mouse
        Vec2 mousePos = new Vec2(
                (float) MousePositionTracker.getMouseLocation().getX(),
                (float) MousePositionTracker.getMouseLocation().getY());
        // calculate target position
        Vec2 targetPos = mousePos.sub(playerPos);
        // gets the angle in radians
        float desiredAngle = (float) Math.atan2(-targetPos.x, targetPos.y);
        // update the body angle to the calculated angle
        getBody().setTransform(getBody().getPosition(), desiredAngle);
        // update the player's angle (convert the angle to degrees)
        final float radToDeg = 57.2958f;
        playerSprite.setRotate(desiredAngle * radToDeg);
    }

    /**
     * Adds a new weapon to the weaponInventory.
     *
     * @param newWeapon the new weapon to be added into the inventory
     */
    public void addWeaponIntoInventory(final AbstractWeapon newWeapon) {
        weaponInventory.add(newWeapon);
    }

    /**
     * Refills the ammo for all weapons in the inventory.
     */
    public void replenishAmmoSupply() {
        for (AbstractWeapon weapon: weaponInventory) {
            // TODO Implement this. Loop through each weapon and call the replenishAmmo() function.
            //  Do the same thing for towers in a different for loop.
        }
    }
}
