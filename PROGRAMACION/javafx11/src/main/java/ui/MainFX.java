package ui;

import dao.DaoPersonas;
import domain.ServiciosPersonas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ui.pantallas.principal.PrincipalController;
import ui.pantallas.principal.PrincipalViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //Locale.setDefault(new Locale("es-es"));
        ResourceBundle r = ResourceBundle.getBundle("/i18n/textosI18N");
        Font.loadFont(getClass().getResourceAsStream("/fonts/GrapeNuts-Regular.ttf"), 14);
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("/fxml/principal.fxml"),r);
        //loaderMenu.setControllerFactory(aClass -> new PrincipalController(new PrincipalViewModel(new ServiciosPersonas(new DaoPersonas()))));
        AnchorPane root = loaderMenu.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle(r.getString("app.title"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);

    }
}
