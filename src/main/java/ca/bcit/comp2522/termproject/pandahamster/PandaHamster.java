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
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

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
//        GridPane layout = new GridPane();
//        root = new Group(layout);
//        Scene scene = new Scene(root);
//        scene.getStylesheets().add(PandaHamster.class.getResource("/stylesheets/style.css").toExternalForm());
//        TiledReader reader = new FileSystemTiledReader();
//        TiledMap map = reader.getMap(PandaHamster.class.getResource("/gameMap.tmx").getPath());
//        GameMap.setMapWidth(map.getWidth() * map.getTileWidth());
//        GameMap.setMapHeight(map.getWidth() * map.getTileWidth());
//        StackPane stackPane = MapRenderer.render(map);
//        HBox hBox = new HBox();
//        hBox.setSpacing(10);
//        hBox.getStyleClass().add("game-bar");
//        hBox.getChildren().add(CurrentWeaponInfo.createCurrentWeaponInfo().getCurrentWeaponInfoGrid());
//        hBox.getChildren().add(PlayerInfo.createPlayerInfo().getPlayerInfo());
//        hBox.getChildren().add(CurrentWaveCounter.createCurrentWaveCounter().getCurrentWaveInfoGrid());
//        for (Node child: hBox.getChildren()) {
//            HBox.setHgrow(child, Priority.ALWAYS);
//        }
//        layout.add(stackPane, 0, 0);
//        layout.add(hBox, 0, 1);
//        Player player = Player.getInstance();
//        // Instantiate single instance of AlienWaveGenerator
//        AlienWaveGenerator alienWaveGenerator = AlienWaveGenerator
//                .getInstance(map.getHeight() * map.getTileHeight(),
//                        map.getWidth() * map.getTileWidth());
//
//        root.getChildren().add(player.getPlayerSprite());
//        root.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
//            MousePositionTracker.setMouseLocation(event.getX(), event.getY());
//        });
//        stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
//            player.pullTrigger();
//        });
//        WorldManager.getInstance().createDynamicRectangle(player, 1f);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        // Generate aliens
//        alienWaveGenerator.generateWaveOfAliens();
//        for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
//            root.getChildren().add(alienSprite.getAlienSprite());
//        }
//        alienWaveGenerator.moveAliensTowardBase();
//
//        AnimationTimer animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(final long now) {
//                WorldManager.getInstance().updateWorld();
//                player.faceMouseDirection();
//                BulletManager.cleanup();
//                DynamicUiUpdater.updateUi();
//                // TODO Remove alien from map if it is dead.
//                for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
//                    if (alienSprite.getHealthPoints() <= 0) {
//                        root.getChildren().remove(alienSprite.getAlienSprite());
//                        WorldManager.getInstance().removeBody(alienSprite.getBody());
//                        alienWaveGenerator.setAlienDead(true);
//                    }
//                }
//
//                if (alienWaveGenerator.isAlienDead()) {
//                    alienWaveGenerator.removeDeadAliensFromCollection();
//                    alienWaveGenerator.setAlienDead(false);
//                }
//
//                if (alienWaveGenerator.isAllNonBossAliensDead() && !alienWaveGenerator.isBossSpawned()) {
//                    alienWaveGenerator.spawnBoss();
//                    for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
//                        root.getChildren().add(alienSprite.getAlienSprite());
//                    }
//                    System.out.println("Boss is spawned!!!!");
//                }
//
//                if (alienWaveGenerator.isWaveComplete()) {
//                    System.out.println("Wave is complete. Here is the next wave for you!");
//                    alienWaveGenerator.generateWaveOfAliens();
//                    for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
//                        root.getChildren().add(alienSprite.getAlienSprite());
//                    }
//                    alienWaveGenerator.moveAliensTowardBase();
//                }
//            }
//        };
//
//        animationTimer.start();
//        AnimationTimer bulletShooting = new AnimationTimer() {
//            private long lastUpdate;
//            @Override
//            public void handle(final long now) {
//                if (lastUpdate >= 1e+9) {
//                    player.pullTrigger();
//                    lastUpdate = 0;
//                }
//                System.out.println(now);
//                lastUpdate += now - lastUpdate;
//            }
//        };
////        stackPane.addEventFilter(MouseEvent.ANY, event -> {
////            if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
////                bulletShooting.start();
////            } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
////                bulletShooting.stop();
////            }
////        });
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
