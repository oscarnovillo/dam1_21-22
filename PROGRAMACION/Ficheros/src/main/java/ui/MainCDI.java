package ui;

import com.google.gson.Gson;
import config.Configuracion;
import dao.impl.DaoClientesImpl;
import dao.impl.DataBase;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import servicios.ServiciosClientes;
import servicios.impl.ServiciosClientesImpl;

public class MainCDI {


    public static void main(String[] args) {

        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();


//        Test t = new Test(new Test2());

//        Test imageFileProcessor = container.select(Test.class).get();
//        imageFileProcessor.test.setI(20);
//
//        Test imageFileProcessor1 = container.select(Test.class).get();
//
//        System.out.println(imageFileProcessor.test.getI());
//        System.out.println(imageFileProcessor1.test.getI());


        MainServicios mainServicios = new MainServicios(
                new ServiciosClientesImpl(
                        new DaoClientesImpl(
                                new DataBase(
                                        new Gson(),new Configuracion()))));

        MainServicios ui = container.select(MainServicios.class).get();


        ui.run();

        container.close();



    }
}
