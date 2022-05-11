package data;

import io.vavr.control.Either;
import modelo.Client;
import modelo.Ingredient;

import java.util.List;

public interface DaoClients {
    boolean isEmptyClientList();

    List<Client> showClientList();

    Client getClient(String dni);

    boolean containsClient(Client client);

    boolean containsClient(String dni);

    void addClient(Client client);

    void removeClient(String dni);

    void changeDNI(String dni, String newDni);

    void changeName(String dni, String newName);

    boolean containsAllergen(Client client, Ingredient allergen);

    void addAllergen(Client client, Ingredient allergen);
}
