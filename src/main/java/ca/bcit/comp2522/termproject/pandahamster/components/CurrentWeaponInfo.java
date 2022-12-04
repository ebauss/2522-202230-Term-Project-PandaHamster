package ca.bcit.comp2522.termproject.pandahamster.components;

import ca.bcit.comp2522.termproject.pandahamster.Player;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
    private final DoubleProperty currentClipSize = new SimpleDoubleProperty();
    private final DoubleProperty currentAmmoCapacity = new SimpleDoubleProperty();
    private final Label currentWeaponInfo = new Label();

    /**
     * Creates a new current weapon info label.
     */
    private CurrentWeaponInfo() {
        currentWeaponInfo.getStyleClass().add("game-label");
        StringBinding stringBinding = Bindings.createStringBinding(() -> String.format(
                "%s\n%d/%d", currentWeaponName.get(),
                        (int) currentClipSize.get(),
                        (int) currentAmmoCapacity.get()),
                currentWeaponName, currentClipSize, currentAmmoCapacity);
        currentWeaponInfo.textProperty().bind(stringBinding);
    }
    /**
     * Changes info of the current weapon on the label when weapon is swapped.
     */
    @Override
    public void update() {
        currentWeaponName.setValue(Player.getInstance().getCurrentWeapon().getName());
        currentClipSize.setValue(Player.getInstance().getCurrentWeapon().getCurrentClipCount());
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
    public Label getCurrentWeaponInfoLabel() {
        return currentWeaponInfo;
    }
}
