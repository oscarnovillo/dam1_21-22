package ui.client_account;

import common.ConstantsErrors;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.ClientNormal;
import modelo.ClientWithDiscount;
import modelo.error.ErrorClientAccounts;
import servicios.ServicesClients;
import servicios.ServicesPreviousPurchase;
import ui.common.ConstantsClientAccounts;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;

import java.util.Scanner;

public class UISettingsForAdmin {
    private final ServicesClients clients;
    private final ServicesPreviousPurchase sPurchases;
    private final InputControl inputControl;

    @Inject
    public UISettingsForAdmin(ServicesClients clients
            , ServicesPreviousPurchase sPurchases
            , InputControl inputControl) {
        this.clients = clients;
        this.sPurchases = sPurchases;
        this.inputControl = inputControl;
    }

    public void adminClientMenu() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println(ConstantsClientAccounts.ADMIN_CLIENT_MENU);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    printClientList();
                    break;
                case 2:
                    addClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                case 4:
                    changeClientDNI();
                    break;
                case 5:
                    changeClientName();
                    break;
                case 6:
                    sortClientsPerExpenses();
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    private void sortClientsPerExpenses() {
        sPurchases.sortClientsPerExpenses()
                .forEach(client ->
                        System.out.println(client.getName() + ConstantsClientAccounts.DNI + client.getDni()
                                + ConstantsClientAccounts.GASTO_TOTAL + sPurchases.getTotalExpense(client)));
    }

    private void printClientList() {
        System.out.println(ConstantsClientAccounts.VER_LISTA_DE_CLIENTES);
        if (clients.isEmptyClientList()) {
            System.out.println(ConstantsGeneral.LISTA_VACIA);
        } else {
            System.out.println(clients.printClientList());

        }
    }

    private void addClient() {
        Client client = createClient();

        ErrorClientAccounts error = clients.addClient(client);

        if (error == null) {
            System.out.println(ConstantsClientAccounts.EL_CLIENTE_SE_HA_REGISTRADO_CORRECTAMENTE);
        } else {
            System.out.println(ConstantsErrors.DNI_VINCULADO_CON_OTRA_CUENTA);
        }
        System.out.println(clients.printClientList());
    }

    private Client createClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsClientAccounts.ANADIR_CLIENTE);
        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NOMBRE);
        String name = sc.nextLine().toUpperCase();

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        String dni = sc.nextLine();

        String answer;
        Client client = null;
        do {
            System.out.println(ConstantsClientAccounts.TIENE_DESCUENTO);
            answer = sc.nextLine().toUpperCase();
            switch (answer) {
                case ConstantsGeneral.SI:
                    double discount = inputControl.getDouble(ConstantsClientAccounts.INTRODUCE_EL_DESCUENTO);
                    client = new ClientWithDiscount(name, dni, discount);
                    break;
                case ConstantsGeneral.NO:
                    client = new ClientNormal(name, dni);
                    break;
                default:
                    System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                    System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
            }
        } while (!answer.equalsIgnoreCase(ConstantsGeneral.SI) && !answer.equalsIgnoreCase(ConstantsGeneral.NO));

        return client;
    }

    private void deleteClient() {
        Scanner sc = new Scanner(System.in);

        System.out.println(ConstantsClientAccounts.BORRAR_CUENTA_DE_CLIENTE);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        String dni = sc.nextLine();

        ErrorClientAccounts error = clients.removeClient(dni);

        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_BORRADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
        System.out.println(clients.printClientList());
    }

    private void changeClientDNI() {
        Scanner sc = new Scanner(System.in);

        String dni;
        System.out.println(ConstantsClientAccounts.ACTUALIZAR_DNI);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        dni = sc.nextLine();

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NUEVO_DNI);
        String newDni = sc.nextLine();

        ErrorClientAccounts error = clients.changeDni(dni, newDni);
        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_ACTUALIZADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
        System.out.println(clients.printClientList());
    }

    private void changeClientName() {
        Scanner sc = new Scanner(System.in);

        String dni;
        System.out.println(ConstantsClientAccounts.ACTUALIZAR_NOMBRE);

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_DNI);
        dni = sc.nextLine();

        System.out.println(ConstantsClientAccounts.INTRODUCE_EL_NUEVO_NOMBRE);
        String newName = sc.nextLine().toUpperCase();

        ErrorClientAccounts error = clients.changeName(dni, newName);
        if (error == null) {
            System.out.println(ConstantsClientAccounts.SE_HA_ACTUALIZADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
        System.out.println(clients.printClientList());
    }
}
