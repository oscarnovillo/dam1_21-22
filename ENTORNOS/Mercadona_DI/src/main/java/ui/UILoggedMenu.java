package ui;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.ClientNormal;
import modelo.error.ErrorClientAccounts;
import servicios.ServicesClients;
import ui.client_account.UISettingsForAdmin;
import ui.client_account.UISettingsForClient;
import ui.client_actions.UIShopping;
import ui.client_actions.UIWallet;
import ui.common.ConstantsClientAccounts;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;

import java.util.Scanner;


public class UILoggedMenu {
    private final UIProduct uiProduct;
    private final UIShopping uiShopping;
    private final UIWallet uiWallet;
    private final UISettingsForClient uiSettingsForClient;
    private final UISettingsForAdmin uiSettingsForAdmin;
    private final ServicesClients servicesClients;
    private final InputControl inputControl;
    private final Scanner sc;

    @Inject
    public UILoggedMenu(UIProduct uiProduct
            , UIShopping uiShopping
            , UIWallet uiWallet
            , UISettingsForClient uiSettingsForClient
            , UISettingsForAdmin uiSettingsForAdmin
            , ServicesClients servicesClients
            , InputControl inputControl
                , Scanner sc) {
        this.uiProduct = uiProduct;
        this.uiShopping = uiShopping;
        this.uiWallet = uiWallet;
        this.uiSettingsForClient = uiSettingsForClient;
        this.uiSettingsForAdmin = uiSettingsForAdmin;
        this.servicesClients = servicesClients;
        this.inputControl = inputControl;
        this.sc = sc;
    }

    public void adminMenu() {
        int option;
        do {
            option = inputControl.getInt(ConstantsGeneral.ADMIN_MENU);

            switch (option) {
                case 1:
                    uiProduct.adminProductMenu();
                    break;
                case 2:
                    uiSettingsForAdmin.adminClientMenu();
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    public void clientLoginMenu() {
        int option;
        do {
            option = inputControl.getInt(ConstantsGeneral.MENU_LOGIN_CLIENT);
            switch (option) {
                case 1:
                    registerClient();
                    break;
                case 2:
                    Client client = clientLogin();
                    if (client != null) {
                        clientLoggedMenu(client);
                    }
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    public void clientLoggedMenu(Client client) {
        int option;
        boolean accountDeleted = false;

        do {
            option = inputControl.getInt(ConstantsGeneral.MENU_LOGGED_CLIENT);

            switch (option) {
                case 1:
                    accountDeleted = uiSettingsForClient.clientAccountSettings(client);
                    break;
                case 2:
                    uiWallet.walletMenu(client);
                    break;
                case 3:
                    uiShopping.shoppingMenu(client);
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0 && !accountDeleted);
    }

    public void registerClient() {


        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        String dni = sc.nextLine();
        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NOMBRE);
        String name = sc.nextLine().toUpperCase();

        ErrorClientAccounts error = servicesClients.addClient(new ClientNormal(name, dni));

        if (error == null) {
            System.out.println(ConstantsClientAccounts.EL_CLIENTE_SE_HA_REGISTRADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private Client clientLogin() {

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        String dni = sc.nextLine();

        Client client = null;
        ErrorClientAccounts error = servicesClients.containsClient(dni);
        if (error == null) {
            client = servicesClients.getClient(dni);
            System.out.println(ConstantsGeneral.HOLA + client.getName());
        } else {
            System.out.println(error.getDescription());
        }
        return client;
    }
}
