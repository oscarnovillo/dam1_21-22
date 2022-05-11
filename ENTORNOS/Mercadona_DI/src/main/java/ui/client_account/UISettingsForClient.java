package ui.client_account;

import jakarta.inject.Inject;
import modelo.Client;
import modelo.Ingredient;
import modelo.error.ErrorClientAccounts;
import modelo.error.ErrorIngredient;
import servicios.ServicesClients;
import servicios.ServicesIngredients;
import servicios.ServicesPreviousPurchase;
import ui.common.ConstantsClientAccounts;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;

import java.util.Scanner;

public class UISettingsForClient {
    private final ServicesClients clients;
    private final ServicesPreviousPurchase sPurchases;
    private final ServicesIngredients servicesIngredients;
    private final ServicesPreviousPurchase servicesPreviousPurchase;
    private final InputControl inputControl;

    @Inject
    public UISettingsForClient(ServicesClients clients
            , ServicesPreviousPurchase sPurchases
            , ServicesIngredients servicesIngredients
            , ServicesPreviousPurchase servicesPreviousPurchase
            , InputControl inputControl) {
        this.clients = clients;
        this.sPurchases = sPurchases;
        this.servicesIngredients = servicesIngredients;
        this.servicesPreviousPurchase = servicesPreviousPurchase;
        this.inputControl = inputControl;
    }

    public boolean clientAccountSettings(Client client) {
        boolean accountDeleted = false;
        int option;
        do {
            option = inputControl.getInt(ConstantsClientAccounts.CLIENT_ACCOUNT_SETTINGS_MENU);
            switch (option) {
                case 1:
                    changeName(client);
                    break;
                case 2:
                    changeDni(client);
                    break;
                case 3:
                    accountDeleted = deleteAccount(client);
                    break;
                case 4:
                    seeAccountData(client);
                    break;
                case 5:
                    printPreviousPurchases(client);
                    break;
                case 6:
                    addAllergen(client);
                    break;
                case 7:
                    printAllergenList(client);
                    break;
                case 8:
                    seeTotalExpenses(client);
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0 && !accountDeleted);

        return accountDeleted;
    }

    private void printAllergenList(Client client) {
        System.out.println(servicesIngredients.showAllergensPerClient(client));
    }

    private void seeTotalExpenses(Client client) {
        System.out.println(sPurchases.getTotalExpense(client) + ConstantsClientAccounts.EURO);
    }

    private void addAllergen(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NOMBRE_DEL_NUEVO_ALERGENO);
        String allergenName = sc.nextLine().toUpperCase();
        Ingredient allergen = new Ingredient(allergenName);
        ErrorIngredient error = clients.addAllergen(client, allergen);

        if (error == null) {
            System.out.println(ConstantsClientAccounts.EL_ALERGENO_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private void printPreviousPurchases(Client client) {
        System.out.println(servicesPreviousPurchase.showPreviousPurchases(client));
    }

    private void seeAccountData(Client client) {
        System.out.println(client);
    }

    private void changeName(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NUEVO_NOMBRE);
        String newName = sc.nextLine().toUpperCase();

        ErrorClientAccounts error = clients.changeName(client.getDni(), newName);

        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_ACTUALIZADO_CORRECTAMENTE);
        }
    }

    private void changeDni(Client client) {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NUEVO_DNI);
        String newDni = sc.nextLine();

        ErrorClientAccounts error = clients.changeDni(client.getDni(), newDni);

        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_ACTUALIZADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private boolean deleteAccount(Client client) {
        boolean accountDeleted = false;

        ErrorClientAccounts error = clients.removeClient(client.getDni());

        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_BORRADO_CORRECTAMENTE);
            System.out.println(ConstantsClientAccounts.PARA_VOLVER_A_ENTRAR_CREA_OTRA_CUENTA);
            accountDeleted = true;
        } else {
            System.out.println(error.getDescription());
        }
        return accountDeleted;
    }

}
