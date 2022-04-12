package ui;

import com.google.gson.Gson;
import config.Configuracion;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainCDI {


    public static void main(String[] args) {

        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();


        MainClientes ui = container.select(MainClientes.class).get();


        ui.main();

        container.close();
    }

}
