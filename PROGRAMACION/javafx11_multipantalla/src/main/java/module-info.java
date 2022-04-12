module javafx11.multipantalla {


    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;
    requires org.apache.logging.log4j;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.fasterxml.jackson.databind;
//    requires jakarta.jakartaee.web.api;
    requires jakarta.inject;
    requires jakarta.cdi;

    exports ui.main to javafx.graphics;
    exports ui.pantallas.principal;
    exports ui.pantallas.pantalla1;
    exports common.config;
    exports common;
    opens ui.pantallas.principal to javafx.fxml;
    opens ui.pantallas.pantalla1 to javafx.fxml;
    opens ui.main;
    opens config;
    opens css;
//    exports ui;
//    opens domain.modelo to javafx.base;
//    exports ui.pantallas.principal;
//
//    opens ui.pantallas.principal to javafx.fxml;

}
