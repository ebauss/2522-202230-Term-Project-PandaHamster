module ca.bcit.comp2522.termproject.pandahamster {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.pandahamster to javafx.fxml;
    exports ca.bcit.comp2522.termproject.pandahamster;
}