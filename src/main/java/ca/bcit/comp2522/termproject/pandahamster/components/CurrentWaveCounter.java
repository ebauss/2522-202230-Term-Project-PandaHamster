package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.AlienWaveGenerator;
import ca.bcit.comp2522.termproject.pandahamster.GameMap;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class CurrentWaveCounter implements DynamicUi {
    private final IntegerProperty currentWave = new SimpleIntegerProperty();
    private final GridPane currentWaveInfo = new GridPane();
    private final Label currentWaveLabel = new Label();
    private CurrentWaveCounter() {
        final Label currentWaveTitle = new Label("Wave");
        currentWaveTitle.getStyleClass().add("game-label");
        currentWaveLabel.getStyleClass().add("game-label");
        currentWaveLabel.textProperty().bind(Bindings.createStringBinding(() -> String.format(
                "%d", currentWave.get()
        ), currentWave));
        currentWaveInfo.getStyleClass().add("grid");
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        column.setHgrow(Priority.ALWAYS);
        currentWaveInfo.getRowConstraints().addAll(row, row);
        currentWaveInfo.getColumnConstraints().add(column);
        currentWaveInfo.add(currentWaveTitle, 0, 0);
        currentWaveInfo.add(currentWaveLabel, 0, 1);
    }
    @Override
    public void update() {
        currentWave.setValue(AlienWaveGenerator.getInstance(GameMap.getMapHeight(), GameMap.getMapWidth()).getCurrentWave());
    }
    public static CurrentWaveCounter createCurrentWaveCounter() {
        CurrentWaveCounter currentWaveCounter = new CurrentWaveCounter();
        DynamicUiUpdater.add(currentWaveCounter);
        return currentWaveCounter;
    }
    public GridPane getCurrentWaveInfoGrid() {
        return currentWaveInfo;
    }
}
