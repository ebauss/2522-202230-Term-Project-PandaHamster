package ca.bcit.comp2522.termproject.pandahamster;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

/**
 * Entry point into the game.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class PandaHamster extends Application {
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
        TiledReader reader = new FileSystemTiledReader();
        TiledMap map = reader.getMap(PandaHamster.class.getResource("/gameMap.tmx").getPath());
        StackPane stackPane = MapRenderer.render(map);
        Group root = new Group(stackPane);
        Player player = new Player("...");
        WorldManager.createDynamicRectangle(player);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the game.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch();
    }
}
