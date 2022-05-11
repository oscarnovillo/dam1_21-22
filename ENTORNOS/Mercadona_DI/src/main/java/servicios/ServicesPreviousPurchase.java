package servicios;

import modelo.Client;
import modelo.SelectedProduct;

import java.util.List;
import java.util.Map;

public interface ServicesPreviousPurchase {
    List<List<SelectedProduct>> showPreviousPurchases(Client client);

    double getTotalExpense(Client client);

    Map<String, Integer> sortProductPerQuantitySold();

    List<Client> sortClientsPerExpenses();
}
