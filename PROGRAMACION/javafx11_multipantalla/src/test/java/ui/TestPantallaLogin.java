package ui;

import common.config.Configuracion;
import dao.impl.DaoLoginImpl;
import domain.usecases.LoginUseCase;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import ui.pantallas.login.LoginController;
import ui.pantallas.login.LoginViewModel;
import ui.pantallas.principal.PrincipalController;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@ExtendWith(ApplicationExtension.class)
@ExtendWith(MockitoExtension.class)
public class TestPantallaLogin {


    @Mock
    PrincipalController principalController;

    @Start
    private void start(Stage stage) throws IOException {

        principalController = mock(PrincipalController.class);
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(param -> new LoginController(new LoginViewModel(new LoginUseCase(new DaoLoginImpl(new Configuracion())))));
        InputStream s = getClass().getResourceAsStream("/fxml/login.fxml");
        Parent fxmlParent = fxmlLoader.load(s);
        LoginController controller = fxmlLoader.getController();
        controller.setPrincipalController(principalController);
        ;

        stage.setScene(new Scene(fxmlParent));
        stage.getScene().getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        stage.show();

    }


    @Test
    void should_contain_button_with_text(FxRobot robot) {
        //given
        robot.clickOn("#txtUserName");
        robot.write("admin");

        //when
        robot.clickOn("#btLogin");

        //then
        verify(principalController).loginHecho(any());
    }


}
