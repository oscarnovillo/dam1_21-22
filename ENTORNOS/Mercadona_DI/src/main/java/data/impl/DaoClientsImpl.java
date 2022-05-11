package data.impl;

import data.DaoClients;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DaoClientsImpl extends DaoBase implements DaoClients {
    private final DataBase dataBase;

    @Inject
    public DaoClientsImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public boolean isEmptyClientList() {

        return dataBase.loadClientes().isEmpty();
    }

    @Override
    public List<Client> showClientList() {
        return new ArrayList<>(dataBase.loadClientes().values());

    }

    @Override
    public Client getClient(String dni) {
        return getElement(dataBase.loadClientes().get(dni));
    }

    @Override
    public boolean containsClient(Client client) {
        return dataBase.loadClientes().containsKey(client.getDni());
    }

    @Override
    public boolean containsClient(String dni) {
        return dataBase.loadClientes().containsKey(dni);
    }

    @Override
    public void addClient(Client client) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.put(client.getDni(), client);
        dataBase.saveClientes(clientList);
    }

    @Override
    public void removeClient(String dni) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.remove(dni);
        dataBase.saveClientes(clientList);
    }

    @Override
    public void changeDNI(String dni, String newDni) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(dni).setDni(newDni);
        Client savedClient = clientList.get(dni);
        clientList.remove(dni);
        clientList.put(newDni, savedClient);
        dataBase.saveClientes(clientList);
    }

    @Override
    public void changeName(String dni, String newName) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(dni).setName(newName);
        dataBase.saveClientes(clientList);
    }

    @Override
    public boolean containsAllergen(Client client, Ingredient allergen) {
        Map<String, Client> clientList = dataBase.loadClientes();
        return clientList.get(client.getDni()).getAllergens().contains(allergen);
    }

    @Override
    public void addAllergen(Client client, Ingredient allergen) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getAllergens().add(allergen);
        dataBase.saveClientes(clientList);
    }


}
