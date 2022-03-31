module javafx11 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports ui;
    exports ui.controllers;


    opens ui.controllers to javafx.fxml;

}
