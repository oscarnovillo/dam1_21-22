package servicios.impl;

import data.DaoPreviousPurchases;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.SelectedProduct;
import servicios.ServicesPreviousPurchase;

import java.util.List;
import java.util.Map;

public class ServicesPreviousPurchaseImpl implements ServicesPreviousPurchase {
    private final DaoPreviousPurchases daoPurchases;

    @Inject
    public ServicesPreviousPurchaseImpl(DaoPreviousPurchases daoPurchases) {
        this.daoPurchases = daoPurchases;
    }


    @Override public List<List<SelectedProduct>> showPreviousPurchases(Client client) {
        return daoPurchases.showPreviousPurchases(client);
    }

    @Override public double getTotalExpense(Client client) {
        return daoPurchases.sumPreviousPurchases(client);
    }

    @Override public Map<String, Integer> sortProductPerQuantitySold() {
        return daoPurchases.sortProductPerQuantitySold();
    }

    @Override public List<Client> sortClientsPerExpenses() {
        return daoPurchases.sortClientsPerExpenses();
    }

}
