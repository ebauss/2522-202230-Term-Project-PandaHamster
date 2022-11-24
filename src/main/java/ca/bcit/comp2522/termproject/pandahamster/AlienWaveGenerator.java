package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;

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
}
