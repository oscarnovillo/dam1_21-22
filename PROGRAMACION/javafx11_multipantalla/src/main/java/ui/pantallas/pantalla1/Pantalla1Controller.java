package ui.pantallas.pantalla1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Pantalla1Controller {


    @FXML
    private void click(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacion");
        alert.setHeaderText("Informacion");
        alert.setContentText("Hola mundo");
        alert.showAndWait();
    }
}
