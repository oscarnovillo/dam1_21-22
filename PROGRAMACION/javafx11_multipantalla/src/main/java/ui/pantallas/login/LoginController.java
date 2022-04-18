package ui.pantallas.login;

import domain.modelo.Usuario;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import jakarta.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import ui.pantallas.common.BasePantallaController;

public class LoginController extends BasePantallaController {

    private LoginViewModel loginViewModel;

    @FXML
    private MFXButton btLogin;
    @FXML
    private MFXPasswordField txtPassword;
    @FXML
    private MFXTextField txtUserName;


    @Inject
    public LoginController(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    public void initialize() {

        loginViewModel.getState().addListener((observableValue, oldState, newState) -> {
            if (newState.getError()!=null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText(newState.getError());
                alert.showAndWait();

            }
            if (newState.isLoginOK())
            {
                //cambiar de pantalla
                this.getPrincipalController().loginHecho(new Usuario(txtUserName.getText(), txtPassword.getText()));
            }

        });
    }

    @FXML
    private void doLogin() {
        Usuario usuario = new Usuario(txtUserName.getText(), txtPassword.getText());

        loginViewModel.doLogin(usuario);


    }




}
