package ca.bcit.comp2522.termproject.pandahamster.Screens;

import ca.bcit.comp2522.termproject.pandahamster.PandaHamster;

/**
 * Manages screen switching.
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public final class ScreenManager {
    /**
     * Int code for start screen.
     */
    public static final int START_SCREEN = 0;
    /**
     * Int code for game screen.
     */
    public static final int GAME_SCREEN = 1;
    private ScreenManager() { }
    public static void changeScreen(final int screen) {
        switch (screen) {
            case START_SCREEN -> {

            }
        }
    }
}
