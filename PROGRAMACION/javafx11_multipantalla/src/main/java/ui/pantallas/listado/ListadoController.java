package ui.pantallas.listado;

import domain.modelo.Cromo;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import jakarta.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ui.pantallas.common.BasePantallaController;
import ui.pantallas.common.Pantallas;

import java.util.Comparator;

public class ListadoController extends BasePantallaController {


    private final ListadoViewModel viewModel ;

    @Inject
    public ListadoController(ListadoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private MFXTableView<Cromo> tabla;

    @FXML
    private void ver(ActionEvent actionEvent) {
//        getPrincipalController().cargarPantalla(Pantallas.DETALLE);
        tabla.getSelectionModel().getSelection().values().stream().findFirst()
                .ifPresent(cromo -> getPrincipalController().onSeleccionCromo(cromo));

    }

    public void initialize() {
// tabla materialFX
        MFXTableColumn<Cromo> collecionColumn = new MFXTableColumn<>("collecion", true, Comparator.comparing(Cromo::getCollecion));
        MFXTableColumn<Cromo> descriptionColumn = new MFXTableColumn<>("descripcion", true, Comparator.comparing(Cromo::getDescripcion));
        MFXTableColumn<Cromo> numberColumn = new MFXTableColumn<>("numero", true, Comparator.comparing(Cromo::getNumero));
        collecionColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getCollecion));
        descriptionColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getDescripcion));
        numberColumn.setRowCellFactory(persona -> new MFXTableRowCell<>(Cromo::getNumero));


        tabla.getTableColumns().addAll(collecionColumn, descriptionColumn, numberColumn);

        viewModel.getState().addListener((observableValue, listadoState, listadoStateNew) -> {
            if (listadoStateNew.getError()!=null){
                getPrincipalController().sacarAlertError(listadoStateNew.getError());
            }
            if (listadoStateNew.getCromos() != null)
            {
                tabla.getItems().clear();
                tabla.getItems().addAll(listadoStateNew.getCromos());
            }


        });
        viewModel.loadCromos();
        // tabla.setItems(viewModel.getState().get().getPersonas());
    }
}
