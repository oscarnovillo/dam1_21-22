package ui;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import servicios.ServiciosClientes;

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


        ServiciosClientes serviciosClientes = container.select(ServiciosClientes.class).get();

        System.out.println(serviciosClientes.getClientes());

        container.close();



    }
}
