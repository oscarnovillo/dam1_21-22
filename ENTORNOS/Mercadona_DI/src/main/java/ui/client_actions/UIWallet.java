package ui.client_actions;

import jakarta.inject.Inject;
import modelo.Client;
import modelo.Wallet;
import modelo.error.ErrorPaying;
import servicios.ServicesWallet;
import ui.common.ConstantsGeneral;
import ui.common.ConstantsWallet;
import ui.common.InputControl;

import java.util.Scanner;

public class UIWallet {
    private final ServicesWallet servicesWallet;
    private final InputControl inputControl;

    @Inject
    public UIWallet(ServicesWallet servicesWallet, InputControl inputControl) {
        this.servicesWallet = servicesWallet;
        this.inputControl = inputControl;
    }

    public void walletMenu(Client client) {
        int option;

        do {
            option = inputControl.getInt(ConstantsWallet.MENU_WALLET);

            switch (option) {
                case 1:
                    addWallet(client);
                    break;
                case 2:
                    addMoney(client);
                    break;
                case 3:
                    walletList(client);
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    private void walletList(Client client) {
        System.out.println(servicesWallet.printWalletList(client));
    }

    private void addMoney(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsWallet.SELECCIONA_EL_MONEDERO);
        String code = sc.nextLine();
        double money = inputControl.getDouble(ConstantsWallet.INTRODUCE_LA_CANTIDAD_QUE_QUIERES_INGRESAR);

        ErrorPaying error = servicesWallet.addMoney(client, code, money);
        if (error == null) {
            System.out.println(ConstantsWallet.EL_DINERO_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private void addWallet(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsWallet.INTRODUCE_EL_CODIGO_DEL_MONEDERO);
        String code = sc.nextLine();
        double money = inputControl.getDouble(ConstantsWallet.INTRODUCE_LA_CANTIDAD_QUE_QUIERES_INGRESAR);

        ErrorPaying error = servicesWallet.addWallet(client, new Wallet(code, money));

        if (error == null) {
            System.out.println(ConstantsWallet.EL_MONEDERO_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(servicesWallet.printWalletList(client));
    }
}
