module ca.bcit.comp2522.termproject.pandahamster {
    requires javafx.controls;
    requires javafx.fxml;
    requires TiledReader;
    requires jbox2d.library;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;

    opens ca.bcit.comp2522.termproject.pandahamster to javafx.fxml;
    exports ca.bcit.comp2522.termproject.pandahamster;
}