package data;

import modelo.Client;
import modelo.SelectedProduct;

import java.util.List;
import java.util.Map;

public interface DaoPreviousPurchases {
    List<List<SelectedProduct>> showPreviousPurchases(Client client);

    double sumPreviousPurchases(Client client);

    List<Client> sortClientsPerExpenses();

    Map<String, Integer> sortProductPerQuantitySold();
}
