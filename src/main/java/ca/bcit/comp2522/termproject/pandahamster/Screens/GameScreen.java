package ca.bcit.comp2522.termproject.pandahamster.Screens;

import ca.bcit.comp2522.termproject.pandahamster.*;
import ca.bcit.comp2522.termproject.pandahamster.aliens.AbstractEnemy;
import ca.bcit.comp2522.termproject.pandahamster.components.CurrentWaveCounter;
import ca.bcit.comp2522.termproject.pandahamster.components.CurrentWeaponInfo;
import ca.bcit.comp2522.termproject.pandahamster.components.DynamicUiUpdater;
import ca.bcit.comp2522.termproject.pandahamster.components.PlayerInfo;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

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
        GridPane layout = new GridPane();
        ROOT.getChildren().add(layout);
        gameScreen.getStylesheets().add(PandaHamster.class.getResource("/stylesheets/style.css").toExternalForm());
        TiledReader reader = new FileSystemTiledReader();
        TiledMap map = reader.getMap(PandaHamster.class.getResource("/gameMap.tmx").getPath());
        GameMap.setMapWidth(map.getWidth() * map.getTileWidth());
        GameMap.setMapHeight(map.getWidth() * map.getTileWidth());
        StackPane stackPane = MapRenderer.render(map);
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getStyleClass().add("game-bar");
        hBox.getChildren().add(CurrentWeaponInfo.createCurrentWeaponInfo().getCurrentWeaponInfoGrid());
        hBox.getChildren().add(PlayerInfo.createPlayerInfo().getPlayerInfo());
        hBox.getChildren().add(CurrentWaveCounter.createCurrentWaveCounter().getCurrentWaveInfoGrid());
        for (Node child: hBox.getChildren()) {
            HBox.setHgrow(child, Priority.ALWAYS);
        }
        layout.add(stackPane, 0, 0);
        layout.add(hBox, 0, 1);
        Player player = Player.getInstance();
        // Instantiate single instance of AlienWaveGenerator
        AlienWaveGenerator alienWaveGenerator = AlienWaveGenerator
                .getInstance(map.getHeight() * map.getTileHeight(),
                        map.getWidth() * map.getTileWidth());

        ROOT.getChildren().add(player.getPlayerSprite());
        ROOT.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            MousePositionTracker.setMouseLocation(event.getX(), event.getY());
        });
        stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            player.pullTrigger();
        });
        WorldManager.getInstance().createDynamicRectangle(player, 1f);

        // Generate aliens
        alienWaveGenerator.generateWaveOfAliens();
        for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
            ROOT.getChildren().add(alienSprite.getAlienSprite());
        }
        alienWaveGenerator.moveAliensTowardBase();

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                WorldManager.getInstance().updateWorld();
                player.faceMouseDirection();
                BulletManager.cleanup();
                DynamicUiUpdater.updateUi();
                // TODO Remove alien from map if it is dead.
                for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
                    if (alienSprite.getHealthPoints() <= 0) {
                        ROOT.getChildren().remove(alienSprite.getAlienSprite());
                        WorldManager.getInstance().removeBody(alienSprite.getBody());
                        alienWaveGenerator.setAlienDead(true);
                    }
                }

                if (alienWaveGenerator.isAlienDead()) {
                    alienWaveGenerator.removeDeadAliensFromCollection();
                    alienWaveGenerator.setAlienDead(false);
                }

                if (alienWaveGenerator.isAllNonBossAliensDead() && !alienWaveGenerator.isBossSpawned()) {
                    alienWaveGenerator.spawnBoss();
                    for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
                        ROOT.getChildren().add(alienSprite.getAlienSprite());
                    }
                    System.out.println("Boss is spawned!!!!");
                }

                if (alienWaveGenerator.isWaveComplete()) {
                    System.out.println("Wave is complete. Here is the next wave for you!");
                    alienWaveGenerator.generateWaveOfAliens();
                    for (AbstractEnemy alienSprite: alienWaveGenerator.getAlienCollection()) {
                        ROOT.getChildren().add(alienSprite.getAlienSprite());
                    }
                    alienWaveGenerator.moveAliensTowardBase();
                }
            }
        };

        animationTimer.start();
    }
    public static Group getRootNode() {
        return ROOT;
    }
}

