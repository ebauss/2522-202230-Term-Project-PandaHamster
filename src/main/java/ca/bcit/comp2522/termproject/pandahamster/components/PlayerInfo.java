package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.Player;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class PlayerInfo implements DynamicUi {
    private final DoubleProperty playerCurrentHealth = new SimpleDoubleProperty();
    private final DoubleProperty playerMaxHealth = new SimpleDoubleProperty();
    private final GridPane playerHealthInfo = new GridPane();
    private final Label playerHealth = new Label();
    private PlayerInfo() {
        Label playerHealthTitle = new Label("HP");
        playerHealthTitle.getStyleClass().add("game-label");
        playerHealth.getStyleClass().add("game-label");
        playerHealth.textProperty().bind(Bindings.createStringBinding(() -> String.format(
                "%d/%d", (int) playerCurrentHealth.get(), (int) playerMaxHealth.get()),
                playerCurrentHealth, playerMaxHealth));
        playerHealthInfo.getStyleClass().add("grid");
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        column.setHalignment(HPos.CENTER);
        playerHealthInfo.getRowConstraints().addAll(row, row);
        playerHealthInfo.setGridLinesVisible(true);
        playerHealthInfo.getColumnConstraints().add(column);
        playerHealthInfo.add(playerHealthTitle, 0, 0);
        playerHealthInfo.add(playerHealth, 0, 1);
    }
    @Override
    public void update() {
        playerCurrentHealth.setValue(Player.getInstance().getCurrentHealth());
        playerMaxHealth.setValue(Player.getInstance().getMaxHealth());
    }

    public static PlayerInfo createPlayerInfo() {
        PlayerInfo playerInfo = new PlayerInfo();
        DynamicUiUpdater.add(playerInfo);
        return playerInfo;
    }

    public GridPane getPlayerInfo() {
        return playerHealthInfo;
    }
}
