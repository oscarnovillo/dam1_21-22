package ui;

import jakarta.inject.Inject;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;

import java.util.Scanner;

public class UILoginMenu {
    private final InputControl inputControl;
    private final UILoggedMenu uiLoggedMenu;
    private final Scanner sc;

    @Inject
    public UILoginMenu(InputControl inputControl, UILoggedMenu uiLoggedMenu,Scanner sc) {
        this.inputControl = inputControl;
        this.uiLoggedMenu = uiLoggedMenu;
        this.sc= sc;
    }

    public void loginMenu() {
        int login;


        do {
            System.out.println(ConstantsGeneral.LOGIN_MENU);
            login = sc.nextInt();
            sc.nextLine();

            switch (login) {
                case 1:
                    uiLoggedMenu.adminMenu();
                    break;
                case 2:
                    uiLoggedMenu.clientLoginMenu();
                    break;
                default:
                    if (login != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (login != 0);
    }
}
