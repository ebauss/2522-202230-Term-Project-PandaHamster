package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.aliens.*;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Contains logic for alien waves.
 *
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class AlienWaveGenerator {
    private static AlienWaveGenerator singleInstance = null;
    private static int currentWave = 0;
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
     * Gets the alienCollection.
     *
     * @return the alienCollection ArrayList
     */
    public ArrayList<AbstractEnemy> getAlienCollection() {
        return alienCollection;
    }

    /**
     * Generates the wave of aliens.
     */
    public void generateWaveOfAliens() {
        // hard coded counts for spawn amounts for each alien type.
        int[] fodderWaveArray = {10, 20, 30, 40, 50};
        int[] gunnerWaveArray = {5, 10, 15, 20, 25};
        int[] speedyWaveArray = {10, 11, 12, 13, 14};
        int[] tankWaveArray = {5, 6, 7, 8, 9};

        // Sets the bounds for generated x and y values.
        long leftLimit = 0L;
        long rightLimit = (long) mapHeight;

        for (int fodderCount = 0; fodderCount < fodderWaveArray[currentWave]; fodderCount++) {
            long randomXCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            long randomYCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

            AbstractEnemy newAlien = new FodderAlien(randomXCoordinate, randomYCoordinate);
            alienCollection.add(newAlien);
            WorldManager.getInstance().createDynamicRectangle(newAlien, 1f);
        }

        for (int gunnerCount = 0; gunnerCount < gunnerWaveArray[currentWave]; gunnerCount++) {
            long randomXCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            long randomYCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

            AbstractEnemy newAlien = new GunnerAlien(randomXCoordinate, randomYCoordinate);
            alienCollection.add(newAlien);
            WorldManager.getInstance().createDynamicRectangle(newAlien, 1f);
        }

        for (int speedyCount = 0; speedyCount < speedyWaveArray[currentWave]; speedyCount++) {
            long randomXCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            long randomYCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

            AbstractEnemy newAlien = new SpeedyAlien(randomXCoordinate, randomYCoordinate);
            alienCollection.add(newAlien);
            WorldManager.getInstance().createDynamicRectangle(newAlien, 1f);
        }

        for (int tankCount = 0; tankCount < tankWaveArray[currentWave]; tankCount++) {
            long randomXCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
            long randomYCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

            AbstractEnemy newAlien = new TankAlien(randomXCoordinate, randomYCoordinate);
            alienCollection.add(newAlien);
            WorldManager.getInstance().createDynamicRectangle(newAlien, 1f);
        }
    }

    /**
     * Determines whether the wave is complete; all enemies are dead.
     *
     * @return true if wave is complete, otherwise false
     */
    public boolean isWaveComplete() {
        // TODO Implement this
        currentWave++;
        return false;
    }

    /**
     * Moves the aliens towards the base.
     */
    public void moveAliensTowardBase() {
        // TODO add condition  so that this isn't infinite. Use isWaveComplete or something.
        for (AbstractEnemy alien: alienCollection) {
            alien.move(mapHeight, mapWidth);
        }
    }
}
