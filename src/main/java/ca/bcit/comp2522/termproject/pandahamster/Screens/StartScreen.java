package ca.bcit.comp2522.termproject.pandahamster.Screens;

import ca.bcit.comp2522.termproject.pandahamster.AlienWaveGenerator;
import ca.bcit.comp2522.termproject.pandahamster.GameMap;
import ca.bcit.comp2522.termproject.pandahamster.GameSaveAndLoad;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;

/**
 * Represents the start screen of the game.
 * @author Evon Bausa & Alex Liu
 * @version 0.0
 */
public final class StartScreen extends Scene {
    private static final Group ROOT = new Group();
    private static StartScreen startScreen;
    /**
     * Constructs a new start screen.
     * @param root the root node of this scene
     */
    private StartScreen(final Parent root) {
        super(root);
    }

    /**
     * Creates a new instance of a start screen. Subsequent calls will return the same start screen.
     * @return the start screen
     */
    public static StartScreen getInstance() {
        if (startScreen == null) {
            startScreen = new StartScreen(ROOT);
            initialize();

        }
        return startScreen;
    }
    /*
    Initializes the start screen with ui elements. Only called once when getInstance is first called
     */
    private static void initialize() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPrefWidth(480);
        layout.setPrefHeight(400);
        layout.setHgap(10);
        layout.setVgap(10);
        ROOT.getChildren().add(layout);
        Button playButton = new Button("Start");
        playButton.setOnAction((value) -> {
            try {
                GameSaveAndLoad.load();
            } catch (IOException e) {
                System.out.println("Illegal IO operation");
            }
            AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).removeAllAliensFromCollection();
            AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).generateWaveOfAliens();
            ScreenManager.changeScreen(ScreenManager.GAME_SCREEN);
        });
        Button quitButton = new Button("Quit");
        quitButton.setOnAction((value) -> {
            Platform.exit();
        });
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        layout.getRowConstraints().addAll(row, row);
        layout.getColumnConstraints().add(column);
        layout.add(playButton, 0, 0);
        layout.add(quitButton, 0, 1);
    }
}
