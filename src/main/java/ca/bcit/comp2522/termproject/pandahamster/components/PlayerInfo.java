package ca.bcit.comp2522.termproject.pandahamster.components;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.GridPane;

public class PlayerInfo implements DynamicUi {
    private final GridPane playerInfo = new GridPane();
    private final DoubleProperty playerCurrentHealth = new SimpleDoubleProperty();
    private final DoubleProperty playerMaxHealth = new SimpleDoubleProperty();
    @Override
    public void update() {
        
    }
}
