package domain.usecases;

import dao.DaoLogin;
import domain.modelo.Usuario;
import jakarta.inject.Inject;


public class LoginUseCase {


    private DaoLogin daoLogin;

    @Inject
    public LoginUseCase(DaoLogin daoLogin) {
        this.daoLogin = daoLogin;
    }


    public boolean doLogin(Usuario usuario) {

        return daoLogin.doLogin(usuario);

    }
}
