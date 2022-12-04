package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.Screens.ScreenManager;
import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;
import ca.bcit.comp2522.termproject.pandahamster.components.CurrentWaveCounter;
import ca.bcit.comp2522.termproject.pandahamster.components.CurrentWeaponInfo;
import ca.bcit.comp2522.termproject.pandahamster.components.DynamicUiUpdater;
import ca.bcit.comp2522.termproject.pandahamster.components.PlayerInfo;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jbox2d.common.Vec2;
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

import java.util.concurrent.TimeUnit;

/**
 * Entry point into the game.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class PandaHamster extends Application {
    private static Stage stage;
    private static Group root;
    /**
     * Starts the game, main logic will exist in here.
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws Exception when something exceptional happens
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        stage = primaryStage;
        ScreenManager.changeScreen(ScreenManager.START_SCREEN);
    }

    /**
     * Sets the scene to the specified screen.
     * @param screen the screen to set to
     */
    public static void changeScreen(final Scene screen) {
        stage.setScene(screen);
        stage.setMinWidth(480);
        stage.setMinHeight(400);
        stage.show();
    }

    /**
     * Launches the game.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch();
    }
}
