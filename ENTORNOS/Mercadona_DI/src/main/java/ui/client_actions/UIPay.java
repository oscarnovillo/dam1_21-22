package ui.client_actions;

import common.ConstantsErrors;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.error.ErrorPaying;
import servicios.ServicesPaying;
import servicios.ServicesShopping;
import servicios.ServicesWallet;
import ui.common.*;

import java.util.Scanner;


public class UIPay {
    private final ServicesPaying servicesPaying;
    private final ServicesShopping servicesShopping;
    private final ServicesWallet servicesWallet;
    private final InputControl inputControl;

    @Inject
    public UIPay(ServicesPaying servicesPaying
            , ServicesShopping servicesShopping
            , ServicesWallet servicesWallet
            , InputControl inputControl) {
        this.servicesPaying = servicesPaying;
        this.servicesShopping = servicesShopping;
        this.servicesWallet = servicesWallet;
        this.inputControl = inputControl;
    }

    public void pay(Client client, String code) {
        int option;
        boolean exit = false;
        ErrorPaying error;
        do {
            error = servicesPaying.pay(client, code);

            if (error == null) {
                System.out.println(ConstantsShopping.COMPRA_REALIZADA);
            } else if (error == ErrorPaying.WALLET_NOT_FOUND) {
                System.out.println(error.getDescription());
            } else if (error == ErrorPaying.INSUFFICIENT_MONEY) {
                System.out.println(error.getDescription());
                option = inputControl.getInt(ConstantsShopping.MENU_INSUFFICIENT_MENU);

                switch (option) {
                    case 1:
                        code = changeWallet(client);
                        break;
                    case 2:
                        addMoney(client, code);
                        break;
                    case 3:
                        deleteProductFromCart(client);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                }
            }
        } while (error == ErrorPaying.INSUFFICIENT_MONEY && !exit);
    }

    private void addMoney(Client client, String code) {
        double money = inputControl.getDouble(ConstantsWallet.INTRODUCE_LA_CANTIDAD_QUE_QUIERES_INGRESAR);
        while (money <= 0) {
            System.out.println(ConstantsErrors.LA_CANTIDAD_TIENE_QUE_SER_MAYOR_QUE_0);
            money = inputControl.getDouble(ConstantsWallet.VUELVE_A_INTRODUCIR_LA_CANTIDAD);
        }
        servicesWallet.addMoney(client, code, money);
    }

    private String changeWallet(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(servicesWallet.printWalletList(client));
        System.out.println(ConstantsWallet.SELECCIONA_EL_MONEDERO);
        return sc.nextLine();
    }

    private void deleteProductFromCart(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(servicesShopping.printShoppingCart(client));
        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine();
        int quantity = inputControl.getInt(ConstantsShopping.INTRODUCE_LA_CANTIDAD);

        ErrorPaying error = servicesShopping.deleteProductFromCart(client, name, quantity);

        if (error == null) {
            System.out.println(ConstantsProducts.EL_PRODUCTO_SE_HA_ELIMINADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }
}
