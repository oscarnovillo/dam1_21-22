module javafx {

    requires javafx.fxml;
    requires javafx.base;
    requires javafx.controls;
    requires MaterialFX;
    requires fr.brouillard.oss.cssfx;
    requires lombok;


    exports ui;
    exports demo to javafx.graphics;
    opens demo.controllers to javafx.fxml;
}

//--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
//--module-path "C:\tools\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
