package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

/**
 * UI element to display current weapon. current clip and ammo capacity.
 * @author Evon Bause & Alex Liu
 * @version 0.0
 */
public final class CurrentWeaponInfo implements DynamicUi {
    private final StringProperty currentWeaponName = new SimpleStringProperty();
    private final Label currentWeaponInfo = new Label();

    /**
     * Creates a new current weapon info label.
     */
    private CurrentWeaponInfo() {
        currentWeaponInfo.textProperty().bind(currentWeaponName);
    }
    /**
     * Changes info of the current weapon on the label when weapon is swapped.
     */
    @Override
    public void update() {
        currentWeaponName.setValue(Player.getInstance().getCurrentWeapon().getName());
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
    public Label getCurrentWeaponInfoLabel() {
        return currentWeaponInfo;
    }
}
