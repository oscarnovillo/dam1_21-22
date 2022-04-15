package ui.pantallas.login;

import domain.modelo.Usuario;
import domain.usecases.LoginUseCase;
import jakarta.inject.Inject;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

public class LoginViewModel {


    private LoginUseCase loginUseCase;

    @Inject
    public LoginViewModel(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
        _state = new SimpleObjectProperty<>(new LoginState(false,null));
    }

    private final ObjectProperty<LoginState> _state;
    public ReadOnlyObjectProperty<LoginState> getState() {
        return _state;
    }


    public void doLogin(Usuario usuario) {
        if (loginUseCase.doLogin(usuario))
        {
            _state.setValue(new LoginState(true,null));
        }
        else
        {
            _state.setValue(new LoginState(false,"usuario o pass no valido"));
        }
    }
}
