package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;
import ca.bcit.comp2522.termproject.pandahamster.aliens.FodderAlien;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/**
 * Contains logic for alien waves.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class AlienWaveGenerator {
    private static AlienWaveGenerator singleInstance = null;
    private ArrayList<AbstractEnemy> alienCollection;
    private final float mapHeight;
    private final float mapWidth;

    /**
     * Constructs an object of type AlienWaveGenerator.
     *
     * @param someMapHeight the height dimension of the map
     * @param someMapWidth the width dimension of the map
     */
    public AlienWaveGenerator(final float someMapHeight, final float someMapWidth) {
        this.mapHeight = someMapHeight;
        this.mapWidth = someMapWidth;
        this.alienCollection = new ArrayList<>();
    }

    /**
     * Instantiates a single instance of AlienWaveGenerator.
     *
     * @param someMapHeight the height dimension of the map
     * @param someMapWidth the width dimension of the map
     * @return the instance of AlienWaveGenerator
     */
    public static AlienWaveGenerator getInstance(final float someMapHeight, final float someMapWidth) {
        if (singleInstance == null) {
            singleInstance = new AlienWaveGenerator(someMapHeight, someMapWidth);
        }
        return singleInstance;
    }

    /**
     * Generates the wave of aliens.
     */
    public void generateWaveOfAliens() {
        //TODO Implement this.
        alienCollection.add(new FodderAlien(100, 100, 16, 16,
                100, 100, 50f, 100));
    }

    /**
     * Determines whether the wave is complete; all enemies are dead.
     *
     * @return true if wave is complete, otherwise false
     */
    public boolean isWaveComplete() {
        // TODO Implement this
        return false;
    }

    /**
     * Moves the aliens towards the base.
     */
    public void moveAliensTowardBase() {
        while (true) {
            // TODO add condition  so that this isn't infinite. Use isWaveComplete or something.
            for (AbstractEnemy alien: alienCollection) {
                alien.move(mapHeight, mapWidth);
            }
        }
    }

    public Rectangle getAlienSprites() {
        return alienCollection.get(0).getAlienSprite();
    }
}
