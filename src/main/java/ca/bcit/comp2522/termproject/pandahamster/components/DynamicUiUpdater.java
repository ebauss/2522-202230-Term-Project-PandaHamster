package ca.bcit.comp2522.termproject.pandahamster.components;

import java.util.ArrayList;
import java.util.List;

public class DynamicUiUpdater {
    private static final List<DynamicUi> uis = new ArrayList<>();

    /**
     * Iterates and updates ui.
     */
    public static void updateUi() {
        for (DynamicUi ui: uis) {
            ui.update();
        }
    }
    public static void add(final DynamicUi ui) {
        if (ui != null) {
            uis.add(ui);
        }
    }
    public static void remove(final DynamicUi ui) {
        if (ui != null) {
            uis.remove(ui);
        }
    }
}
