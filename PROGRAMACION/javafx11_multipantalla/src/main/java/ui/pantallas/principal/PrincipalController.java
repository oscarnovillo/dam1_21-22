package ui.pantallas.principal;


import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Optional;

public class PrincipalController {

    private final FXMLLoader fxmlloaderPantalla;
    private Stage primaryStage;
    @FXML
    private BorderPane root;
    @FXML
    private TextField txtNormal;
    @FXML
    private MFXTextField txtField;
    @FXML
    private MFXButton button;
    private AnchorPane panePantalla;


    @Inject
    public PrincipalController(FXMLLoader fxmlloaderPantalla) {


//        System.out.println(configuracion.getPathDatos());
        this.fxmlloaderPantalla = fxmlloaderPantalla;
    }


    public void cargarPantalla1() {
        try {
            if (panePantalla == null) {
                panePantalla = fxmlloaderPantalla.load(getClass().getResourceAsStream("/fxml/pantalla1.fxml"));

//            pantallaController = fxmlloaderPantalla.getController();
//
//            pantallaController.boton.setText("conseguido2");
//            pantallaController.setP(this);
//            pantallaController.cargarPepes(pepes);
            }

//            FadeTransition fade = new FadeTransition();
//            fade.setNode(root.getCenter());
//            fade.setDuration(Duration.millis(2000));
//            fade.setCycleCount(1);
//            fade.setInterpolator(Interpolator.LINEAR);
//            fade.setFromValue(1);
//            fade.setToValue(0);
//            fade.play();
//            fade.setOnFinished(event -> {
//                root.setCenter(panePantalla);
//            });

            StackPane stackPane = (StackPane)root.getCenter();

            stackPane.getChildren().add(0,panePantalla);

            ScaleTransition scaleTransition = new ScaleTransition();
            scaleTransition.setNode(stackPane.getChildren().get(1));
            scaleTransition.setDuration(Duration.millis(500));
            scaleTransition.setFromX(stackPane.getChildren().get(1).getScaleX());
            scaleTransition.setFromY(stackPane.getChildren().get(1).getScaleY());
            scaleTransition.setToX(0);
            scaleTransition.setToY(0);
            scaleTransition.setInterpolator(Interpolator.EASE_OUT);
            scaleTransition.play();
            scaleTransition.setOnFinished(event -> {
                stackPane.getChildren().remove(1);
                     } );

//            TranslateTransition translate = new TranslateTransition();
//            translate.setNode(stackPane.getChildren().get(1));
//            translate.setDuration(Duration.millis(1000));
//            translate.setCycleCount(1);
//            translate.setInterpolator(Interpolator.LINEAR);
//            translate.setFromX(0);
//            translate.setToX(root.getWidth());
//            translate.play();
//            translate.setOnFinished(event -> {
//                stackPane.getChildren().remove(1);
//            });

//
//            RotateTransition rotate = new RotateTransition();
//            rotate.setNode(root.getCenter());
//            rotate.setDuration(Duration.millis(2000));
//            rotate.setCycleCount(1);
//            rotate.setInterpolator(Interpolator.LINEAR);
//            rotate.setFromAngle(0);
//            rotate.setToAngle(360);
//            rotate.play();
//            rotate.setOnFinished(event -> {
//                root.setCenter(panePantalla);
//            });

            //root.setCenter(panePantalla);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void initialize() {

    }

    private void closeWindowEvent(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.getButtonTypes().remove(ButtonType.OK);
        alert.getButtonTypes().add(ButtonType.CANCEL);
        alert.getButtonTypes().add(ButtonType.YES);
        alert.setTitle("Quit application");
        alert.setContentText("Close without saving?");
        alert.initOwner(primaryStage.getOwner());
        Optional<ButtonType> res = alert.showAndWait();


        res.ifPresent(buttonType -> {
            if (buttonType == ButtonType.CANCEL) {
                event.consume();
            }
        });
    }

    public void help(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ayuda");
        alert.setHeaderText("Ayuda");
        alert.setContentText("Este es un mensaje de ayuda");
        alert.showAndWait();
    }

    public void exit(ActionEvent actionEvent) {
//        primaryStage.close();
//        Platform.exit();
        primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void setStage(Stage stage) {
        primaryStage = stage;
        primaryStage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
    }

    public void cambiarcss(ActionEvent actionEvent) {
        primaryStage.getScene().getRoot().getStylesheets().clear();
        primaryStage.getScene().getRoot().getStylesheets().add(getClass().getResource("/css/darkmode.css").toExternalForm());

    }
}
