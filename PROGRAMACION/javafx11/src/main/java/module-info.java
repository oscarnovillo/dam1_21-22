module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;

    exports ui;
    exports ui.pantallas;


    opens domain.modelo to javafx.base;
    opens ui.pantallas to javafx.fxml;
    exports ui.pantallas.principal;
    opens ui.pantallas.principal to javafx.fxml;

}
