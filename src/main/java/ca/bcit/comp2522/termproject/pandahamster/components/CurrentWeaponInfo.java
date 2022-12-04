package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.Player;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * UI element to display current weapon. current clip and ammo capacity.
 * @author Evon Bause & Alex Liu
 * @version 0.0
 */
public final class CurrentWeaponInfo implements DynamicUi {
    private final StringProperty currentWeaponName = new SimpleStringProperty();
    private final DoubleProperty currentClipSize = new SimpleDoubleProperty();
    private final DoubleProperty clipSize = new SimpleDoubleProperty();
    private final DoubleProperty currentAmmoCapacity = new SimpleDoubleProperty();
    private final GridPane currentWeaponInfo = new GridPane();
    private final Label weaponName = new Label();
    private final Label clip = new Label();
    private final Label ammo = new Label();

    /**
     * Creates a new current weapon info label.
     */
    private CurrentWeaponInfo() {
        weaponName.getStyleClass().add("game-label");
        ammo.getStyleClass().add("game-label");
        weaponName.textProperty().bind(currentWeaponName);
        clip.textProperty().bind(Bindings.createStringBinding(() -> String.format(
                "%d/%d", (int) currentClipSize.get(), (int) clipSize.get()
        ), currentClipSize, clipSize));

        ammo.textProperty().bind(Bindings.createStringBinding(() -> String.format(
                "%d", (int) currentAmmoCapacity.get()
        ), currentAmmoCapacity));
        currentWeaponInfo.getStyleClass().add("grid");
        ColumnConstraints column = new ColumnConstraints();
        column.setHalignment(HPos.CENTER);
        column.setPercentWidth(50);
        column.setHgrow(Priority.ALWAYS);
        RowConstraints row = new RowConstraints();
        row.setValignment(VPos.CENTER);
        currentWeaponInfo.getColumnConstraints().addAll(column, column);
        currentWeaponInfo.getRowConstraints().addAll(row, row);
        currentWeaponInfo.add(weaponName, 0, 0, 2, 1);
        currentWeaponInfo.add(clip, 0, 1, 1, 1);
        currentWeaponInfo.add(ammo, 1, 1, 1, 1);
    }
    /**
     * Changes info of the current weapon on the label when weapon is swapped.
     */
    @Override
    public void update() {
        currentWeaponName.setValue(Player.getInstance().getCurrentWeapon().getName());
        currentClipSize.setValue(Player.getInstance().getCurrentWeapon().getCurrentClipCount());
        clipSize.setValue(Player.getInstance().getCurrentWeapon().getClipSize());
        currentAmmoCapacity.set(Player.getInstance().getCurrentWeapon().getAmmoCapacity());
    }

    /**
     * Creates and returns a current weapon info.
     * @return a current weapon info
     */
    public static CurrentWeaponInfo createCurrentWeaponInfo() {
        CurrentWeaponInfo weaponInfo = new CurrentWeaponInfo();
        DynamicUiUpdater.add(weaponInfo);
        return weaponInfo;
    }
    /**
     * Returns the weapon info label that exists inside.
     * @return the weapon info label
     */
    public GridPane getCurrentWeaponInfoGrid() {
        return currentWeaponInfo;
    }
}
