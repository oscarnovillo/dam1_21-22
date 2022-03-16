package ui;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MainCDI {


    public static void main(String[] args) {


        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Test imageFileProcessor = container.select(Test.class).get();

        System.out.println(imageFileProcessor.test.getI());

        container.shutdown();
    }
}
