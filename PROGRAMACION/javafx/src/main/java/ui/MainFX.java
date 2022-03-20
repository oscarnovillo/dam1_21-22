package ui;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.enums.ButtonType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainFX extends Application {


//    public static void main(String[] args) {
//        launch(args);
//    }
//

    @Override
    public void start(Stage primaryStage) throws Exception {




        primaryStage.setTitle("Hello World!");
        MFXButton btn = new MFXButton();
        btn.setButtonType(ButtonType.RAISED);
        btn.setText("Say 'Hello World'");
        btn.setOnAction(actionEvent ->  {
                System.out.println("Hello World!");
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("HOLA MUNDO");
                a.showAndWait();

        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

    }
}
