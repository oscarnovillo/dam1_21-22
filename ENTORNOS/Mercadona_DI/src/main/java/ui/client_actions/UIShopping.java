package ui.client_actions;

import jakarta.inject.Inject;
import modelo.Client;
import modelo.ProductNormal;
import modelo.SelectedProduct;
import modelo.common.ConstantsPOJO;
import modelo.error.ErrorPaying;
import servicios.ServicesShopping;
import servicios.ServicesWallet;
import ui.common.*;

import java.util.Scanner;

public class UIShopping {
    private final ServicesShopping servicesShopping;
    private final ServicesWallet servicesWallet;
    private final UIPay uiPay;
    private final InputControl inputControl;

    @Inject
    public UIShopping(ServicesShopping servicesShopping
            , ServicesWallet servicesWallet
            , UIPay uiPay
            , InputControl inputControl) {
        this.servicesShopping = servicesShopping;
        this.servicesWallet = servicesWallet;
        this.uiPay = uiPay;
        this.inputControl = inputControl;
    }

    public void shoppingMenu(Client client) {
        int option;

        do {
            option = inputControl.getInt(ConstantsShopping.SHOPPING_MENU);

            switch (option) {
                case 1:
                    printAvailableProducts(client);
                    break;
                case 2:
                    printShoppingCart(client);
                    break;
                case 3:
                    addProductToCart(client);
                    break;
                case 4:
                    pay(client);
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    private void printAvailableProducts(Client client) {
        System.out.println(servicesShopping.printAvailableProducts(client));
    }

    private void printShoppingCart(Client client) {
        System.out.println(servicesShopping.printShoppingCart(client));
        System.out.println(ConstantsShopping.PRECIO_TOTAL + servicesShopping.getTotalPrice(client) + ConstantsPOJO.EURO);
    }

    private void addProductToCart(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String productName = sc.nextLine().toUpperCase();
        int quantity = inputControl.getInt(ConstantsShopping.INTRODUCE_LA_CANTIDAD);

        ErrorPaying error = servicesShopping.addProductToCart(client
                , new SelectedProduct(
                        new ProductNormal(productName)
                        , quantity));

        if (error == null) {
            System.out.println(ConstantsProducts.EL_PRODUCTO_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private void pay(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsWallet.SELECCIONA_EL_MONEDERO);
        System.out.println(servicesWallet.printWalletList(client));
        String code = sc.nextLine();

        uiPay.pay(client, code);
    }
}
