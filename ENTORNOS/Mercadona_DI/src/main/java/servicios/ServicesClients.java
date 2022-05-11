package servicios;

import io.vavr.control.Either;
import modelo.Client;
import modelo.Ingredient;
import modelo.error.ErrorClientAccounts;
import modelo.error.ErrorIngredient;

import java.util.List;

public interface ServicesClients {
    boolean isEmptyClientList();

    List<Client> printClientList();

    Client getClient(String dni);

    ErrorClientAccounts containsClient(String dni);

    boolean isClientWithDiscount(Client client);

    ErrorClientAccounts addClient(Client client);

    ErrorClientAccounts removeClient(String dni);

    ErrorClientAccounts changeDni(String dni, String newDni);

    ErrorClientAccounts changeName(String dni, String newName);

    ErrorIngredient addAllergen(Client client, Ingredient allergen);
}
