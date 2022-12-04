package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.GameSaveAndLoad;
import ca.bcit.comp2522.termproject.pandahamster.Screens.ScreenManager;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Menu implements DynamicUi {

    private final GridPane menuGrid = new GridPane();
    private Menu() {
        Button save = new Button("Save");
        save.setOnAction((value) -> {
            try {
                GameSaveAndLoad.save();
            } catch (FileNotFoundException e) {
                System.out.println("Could not locate the file.");
            }
        });
        Button menu = new Button("Menu");
        menu.setOnAction((value) -> ScreenManager.changeScreen(ScreenManager.START_SCREEN));
        menuGrid.getStyleClass().add("grid");
        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);
        row.setValignment(VPos.CENTER);
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        column.setHalignment(HPos.CENTER);
        menuGrid.getRowConstraints().addAll(row, row);
        menuGrid.getColumnConstraints().add(column);
        menuGrid.add(save, 0, 0);
        menuGrid.add(menu, 0, 1);
    }
    @Override
    public void update() {

    }
    public static Menu createMenu() {
        Menu menu = new Menu();
        DynamicUiUpdater.add(menu);
        return menu;
    }
    public GridPane getMenuGrid() {
        return menuGrid;
    }
}
