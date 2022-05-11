package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Mercadona {

    public static void main(String[] args) {

        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        final SeContainer container = initializer.initialize();

        UILoginMenu uiLoggedMenu = container.select(UILoginMenu.class).get();

        uiLoggedMenu.loginMenu();

    }

}
