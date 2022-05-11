package data.impl;

import data.DaoPreviousPurchases;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.SelectedProduct;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoPreviousPurchasesImpl implements DaoPreviousPurchases {
    private final DataBase dataBase;

    @Inject
    public DaoPreviousPurchasesImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override public List<List<SelectedProduct>> showPreviousPurchases(Client client) {
        return dataBase.loadClientes().get(client.getDni()).getPreviousPurchases();
    }

    @Override public double sumPreviousPurchases(Client client) {
        return dataBase.loadClientes().get(client.getDni()).getPreviousPurchases().stream()
                .flatMap(Collection::stream)
                .mapToDouble(SelectedProduct::getPrice).sum();
    }

    @Override public List<Client> sortClientsPerExpenses() {
        return dataBase.loadClientes().values().stream()
                .sorted((c1, c2)
                        -> Double.compare(
                        c2.getPreviousPurchases().stream()
                                .flatMap(Collection::stream)
                                .mapToDouble(SelectedProduct::getPrice).sum()
                        , c1.getPreviousPurchases().stream()
                                .flatMap(Collection::stream)
                                .mapToDouble(SelectedProduct::getPrice).sum()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override public Map<String, Integer> sortProductPerQuantitySold() {
        return dataBase.loadClientes().values().stream()
                .flatMap(client -> client.getPreviousPurchases().stream())
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(boughtProduct ->
                        boughtProduct.getProduct().getName(), Collectors.summingInt(SelectedProduct::getQuantity)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
