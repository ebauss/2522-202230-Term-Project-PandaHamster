package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.Base;
import javafx.beans.binding.Bindings;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class BaseInfo implements DynamicUi {
    private final GridPane baseInfoGrid = new GridPane();
    private final ProgressBar baseHealthBar = new ProgressBar(1);
    private final LongProperty baseCurrentHealth = new SimpleLongProperty();
    private final LongProperty baseMaxHealth = new SimpleLongProperty();
    private BaseInfo() {
        final Label baseLabel = new Label("Base Health");
        baseHealthBar.progressProperty().bind(Bindings.createDoubleBinding(() ->
                (double) baseCurrentHealth.get() / baseMaxHealth.get(), baseCurrentHealth, baseMaxHealth));
        baseInfoGrid.getStyleClass().add("grid");
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);
        row.setVgrow(Priority.ALWAYS);
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        column.setHgrow(Priority.ALWAYS);
        baseInfoGrid.getRowConstraints().addAll(row, row);
        baseInfoGrid.getColumnConstraints().addAll(column);
        baseInfoGrid.add(baseLabel, 0, 0);
        baseInfoGrid.add(baseHealthBar, 0, 1);
    }
    @Override
    public void update() {
        baseCurrentHealth.setValue(Base.getInstance().getHealth());
        baseMaxHealth.setValue(Base.getMaxHealth());
    }
    public static BaseInfo createBaseInfo() {
        BaseInfo baseInfo = new BaseInfo();
        DynamicUiUpdater.add(baseInfo);
        return baseInfo;
    }

    public GridPane getBaseInfoGrid() {
        return baseInfoGrid;
    }
}
