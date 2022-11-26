package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;
import ca.bcit.comp2522.termproject.pandahamster.aliens.FodderAlien;

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

    /**
     * Constructs an object of type AlienWaveGenerator.
     */
    public AlienWaveGenerator() {
        this.alienCollection = new ArrayList<>();
    }

    /**
     * Instantiates a single instance of AlienWaveGenerator.
     *
     * @return the instance of AlienWaveGenerator
     */
    public static AlienWaveGenerator getInstance() {
        if (singleInstance == null) {
            singleInstance = new AlienWaveGenerator();
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
}
