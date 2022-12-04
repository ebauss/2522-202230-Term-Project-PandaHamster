package ca.bcit.comp2522.termproject.pandahamster.Screens;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Represents the game screen.
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public final class GameScreen extends Scene {
    private static final Group ROOT = new Group();
    private static GameScreen gameScreen;
    private GameScreen(final Parent root) {
        super(root);
    }

    /**
     * Creates and instance of a game screen. Subsequent calls will return the same game screen.
     * @return the game screen
     */
    public static GameScreen getInstance() {
        if (gameScreen == null) {
            gameScreen = new GameScreen(ROOT);
            initialize();
        }
        return gameScreen;
    }
    /*
    Initializes the game screen with ui elements. Called on when on the first getInstance.
     */
    private static void initialize() {

    }
}

