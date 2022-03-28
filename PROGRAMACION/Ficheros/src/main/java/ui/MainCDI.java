package ui;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainCDI {


    public static void main(String[] args) {


        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();


        Test imageFileProcessor = container.select(Test.class).get();

        System.out.println(imageFileProcessor.test.getI());

        container.close();

            

    }
}
