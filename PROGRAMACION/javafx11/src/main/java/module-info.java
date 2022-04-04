module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;
    exports ui;

    opens domain.modelo to javafx.base;
    exports ui.pantallas.principal;
    exports common to javafx.fxml;
    opens ui.pantallas.principal to javafx.fxml;

}
