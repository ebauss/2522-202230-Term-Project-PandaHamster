package ca.bcit.comp2522.termproject.pandahamster;

import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

import java.text.NumberFormat;

/**
 * Entry point into the game.
 * @author Evon Bausa & Alex Liu
 * @version 2022
 */
public class PandaHamster extends Application {
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
        TiledReader reader = new FileSystemTiledReader();
        TiledMap map = reader.getMap(PandaHamster.class.getResource("/gameMap.tmx").getPath());
        StackPane stackPane = MapRenderer.render(map);
        root = new Group(stackPane);
        Player player = Player.getInstance();
        root.getChildren().add(player.getPlayerSprite());
        root.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            MousePositionTracker.setMouseLocation(event.getX(), event.getY());
        });
        stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            player.pullTrigger();
        });
        WorldManager.getInstance().createDynamicRectangle(player, 1f);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                WorldManager.getInstance().updateWorld();
                player.faceMouseDirection();
                BulletManager.cleanup();
            }
        };

        // Instantiate single instance of AlienWaveGenerator
        AlienWaveGenerator alienWaveGenerator = AlienWaveGenerator
                .getInstance(map.getHeight() * map.getTileHeight(),
                        map.getWidth() * map.getTileWidth());
        System.out.println(map.getHeight() * map.getTileHeight());
        alienWaveGenerator.generateWaveOfAliens();
        for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
            root.getChildren().add(alienSprite.getAlienSprite());
        }
        alienWaveGenerator.moveAliensTowardBase();

        animationTimer.start();
        AnimationTimer bulletShooting = new AnimationTimer() {
            private long lastUpdate;
            @Override
            public void handle(final long now) {
                if (lastUpdate >= 1e+9) {
                    player.pullTrigger();
                    lastUpdate = 0;
                }
                System.out.println(now);
                lastUpdate += now - lastUpdate;
            }
        };
//        stackPane.addEventFilter(MouseEvent.ANY, event -> {
//            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
//                bulletShooting.start();
//            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
//                bulletShooting.stop();
//            }
//        });
    }

    /**
     * Returns the group that contains all the elements.
     * @return the group
     */
    public static Group getGroup() {
        return root;
    }

    /**
     * Launches the game.
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch();
    }
}
