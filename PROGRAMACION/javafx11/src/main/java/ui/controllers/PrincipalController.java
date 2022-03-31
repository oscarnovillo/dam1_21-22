package ui.controllers;

import domain.modelo.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.viewmodel.PrincipalViewModel;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {


    private final String nombreDefecto = "Alejandro";

    private PrincipalViewModel viewModel;

    @FXML
    private TableColumn<Persona, String> columnNombre;
    @FXML
    private TableColumn<Persona, Integer> columnEdad;

    @FXML
    private TableView<Persona> table;

    @FXML
    private TextField txtNombre;

    @FXML
    private void saludar() {

        viewModel.addPersona(new Persona(nombreDefecto, 10));


        String nombre = !txtNombre.getText().isBlank()
                ? txtNombre.getText() : nombreDefecto;
        String text = "hola " + nombre;

        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText(text);
        a.showAndWait();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        viewModel = new PrincipalViewModel();
        columnEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        table.setItems(viewModel.getPersonas());

    }

    public void verSeleccionTabla(ActionEvent actionEvent) {

        Persona p = table.getSelectionModel().getSelectedItem();
        if (p != null) {
            viewModel.updatePersona(new Persona(p.getNombre(), p.getEdad() + 1));
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(p.getNombre());
            a.showAndWait();
        }
    }
}
