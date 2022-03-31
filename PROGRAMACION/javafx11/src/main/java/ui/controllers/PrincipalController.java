package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class PrincipalController {


    private final String nombreDefecto = "Alejandro";

    @FXML
    private TextField txtNombre;

    @FXML
    private void saludar() {



        String nombre = !txtNombre.getText().isBlank()
                ?txtNombre.getText():nombreDefecto;
        String text  ="hola " + nombre;

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(text);
        a.showAndWait();


    }


}
