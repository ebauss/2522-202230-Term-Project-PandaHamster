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
    private boolean alienDead;
    private boolean bossSpawned;
    private boolean waveCompleted;

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
        this.alienDead = false;
        this.bossSpawned = false;
        this.waveCompleted = false;
    }

    /**
     * Gets the bossSpawned variable.
     *
     * @return the bossSpawned boolean
     */
    public boolean isBossSpawned() {
        return bossSpawned;
    }

    /**
     * Gets the alienDead variable.
     *
     * @return the alienDead variable as a boolean
     */
    public boolean isAlienDead() {
        return alienDead;
    }

    /**
     * Sets the alienDead variable.
     *
     * @param alienDead variable as a boolean
     */
    public void setAlienDead(final boolean alienDead) {
        this.alienDead = alienDead;
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
        int[] speedyWaveArray = {6, 11, 12, 13, 14};
        int[] tankWaveArray = {1, 6, 7, 8, 9};

        // Sets the bounds for generated x and y values.
        long leftLimit = 0L;
        long rightLimit = (long) mapHeight - 50;

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
     * Removes dead aliens from the alien collection.
     */
    public void removeDeadAliensFromCollection() {
        ArrayList<AbstractEnemy> newAlienCollection = new ArrayList<>();
        for (AbstractEnemy alien: alienCollection) {
            if (alien.getHealthPoints() > 0) {
                newAlienCollection.add(alien);
            }
        }
        alienCollection = newAlienCollection;
    }

    /**
     * Spawns the bossAlien.
     */
    public void spawnBoss() {
        // Sets the bounds for generated x and y values.
        long leftLimit = 0L;
        long rightLimit = (long) mapHeight - 50;
        long randomXCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        long randomYCoordinate = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        AbstractEnemy newAlien = new BossAlien(randomXCoordinate, randomYCoordinate);
        alienCollection.add(newAlien);
        WorldManager.getInstance().createDynamicRectangle(newAlien, 1f);
        bossSpawned = true;
    }

    /**
     * Checks whether all non boss aliens are dead.
     *
     * @return a boolean; true if all non boss aliens are dead, otherwise false
     */
    public boolean isAllNonBossAliensDead() {
        if (!bossSpawned) {
            for (AbstractEnemy alien: alienCollection) {
                if (alien.getHealthPoints() > 0) {
                    return false;
                }
            }
            return true;
        }
         return true; // return true if boss is spawned.
    }

    /**
     * Checks whether the boss is dead.
     *
     * @return a boolean; true if boss is dead else false
     */
    public boolean isBossAlienDead() {
        if (bossSpawned) {
            for (AbstractEnemy alien: alienCollection) {
                if (alien.getHealthPoints() > 0) {
                    return false;
                }
            }
            bossSpawned = false;
            waveCompleted = true;
            return true;
        }
        return false; // if boss is not spawned, return false since it doesn't exist yet.
    }

    /**
     * Determines whether the wave is complete; all enemies are dead.
     *
     * @return true if wave is complete, otherwise false
     */
    public boolean isWaveComplete() {
         if (this.isAllNonBossAliensDead() && this.isBossAlienDead() && waveCompleted) {
             if (currentWave <= 5) {
                 currentWave++;
                 waveCompleted = false;
             } else {
                 System.out.println("You beat the game!");
             }

             return true;
         }
        return false;
    }

    /**
     * Moves the aliens towards the base.
     */
    public void moveAliensTowardBase() {
        for (AbstractEnemy alien: alienCollection) {
            alien.move(mapHeight, mapWidth);
        }
    }
}
