package ca.bcit.comp2522.termproject.pandahamster.aliens;

/**
 * Represents an object of type GunnerAlien.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class GunnerAlien extends AbstractEnemy {
    private static final float GUNNER_ALIEN_SPEED = 10f;
    private static final long GUNNER_ALIEN_HEALTH = 100;
    private static final long GUNNER_ALIEN_WIDTH = 20;
    private static final long GUNNER_ALIEN_HEIGHT = 20;
    private static final long GUNNER_ALIEN_KILL_MONEY = 70;
    private static final long GUNNER_ALIEN_KILL_EXPERIENCE = 70;
    private static final String GUNNER_ALIEN_SPRITE_IMAGE_FILE_NAME = "gunnerAlien.png";

    /**
     * Constructs an object of type GunnerAlien.
     *
     * @param someXPosition           xPosition of class as a long
     * @param someYPosition           yPosition of class as a long
     */
    public GunnerAlien(final long someXPosition, final long someYPosition) {
        super(someXPosition, someYPosition, GUNNER_ALIEN_WIDTH, GUNNER_ALIEN_HEIGHT,
                GUNNER_ALIEN_KILL_MONEY, GUNNER_ALIEN_KILL_EXPERIENCE, GUNNER_ALIEN_SPEED, GUNNER_ALIEN_HEALTH,
                GUNNER_ALIEN_SPRITE_IMAGE_FILE_NAME);
    }

    /**
     * Deals damage to the enemy.
     */
    @Override
    public void attack() {

    }
}
