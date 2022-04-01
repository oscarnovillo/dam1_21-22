module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;

    exports ui;
    exports ui.controllers;


    opens domain.modelo to javafx.base;
    opens ui.controllers to javafx.fxml;

}
