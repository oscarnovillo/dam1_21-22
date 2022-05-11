package servicios.impl;

import data.DaoClients;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.ClientWithDiscount;
import modelo.Ingredient;
import modelo.error.ErrorClientAccounts;
import modelo.error.ErrorIngredient;
import servicios.ServicesClients;

import java.util.List;

public class ServicesClientsImpl implements ServicesClients {

    private final DaoClients daoClients;

    @Inject
    public ServicesClientsImpl(DaoClients daoClients) {
        this.daoClients = daoClients;
    }

    @Override public boolean isEmptyClientList() {
        return daoClients.isEmptyClientList();
    }

    @Override public List<Client> printClientList() {
        return daoClients.showClientList();
    }

    @Override public Client getClient(String dni) {
        return daoClients.getClient(dni);
    }

    @Override public ErrorClientAccounts containsClient(String dni) {
        ErrorClientAccounts error = null;
        if (!daoClients.containsClient(dni)) {
            error = ErrorClientAccounts.NOT_FOUND;
        }

        return error;
    }

    @Override public boolean isClientWithDiscount(Client client) {
        return client.getClass() == ClientWithDiscount.class;
    }

    @Override public ErrorClientAccounts addClient(Client client) {
        int minDiscount = 0;
        int maxDiscount = 100;

        ErrorClientAccounts error = null;

        if (daoClients.containsClient(client)) {
            error = ErrorClientAccounts.DUPLICATED;
        } else if (isClientWithDiscount(client)) {
            if (((ClientWithDiscount) client).getDiscount() <= minDiscount) {
                error = ErrorClientAccounts.LOW_DISCOUNT;
            } else if (((ClientWithDiscount) client).getDiscount() >= maxDiscount) {
                error = ErrorClientAccounts.HIGH_DISCOUNT;
            } else {
                daoClients.addClient(client);
            }
        } else {
            daoClients.addClient(client);
        }

        return error;
    }

    @Override public ErrorClientAccounts removeClient(String dni) {
        ErrorClientAccounts error = null;

        if (daoClients.containsClient(dni)) {
            daoClients.removeClient(dni);
        } else {
            error = ErrorClientAccounts.NOT_FOUND;
        }

        return error;
    }

    @Override public ErrorClientAccounts changeDni(String dni, String newDni) {
        ErrorClientAccounts error = null;

        if (!daoClients.containsClient(dni)) {
            error = ErrorClientAccounts.NOT_FOUND;
        } else if (daoClients.containsClient(newDni)) {
            error = ErrorClientAccounts.DUPLICATED;
        } else {
            daoClients.changeDNI(dni, newDni);
        }

        return error;
    }

    @Override public ErrorClientAccounts changeName(String dni, String newName) {
        ErrorClientAccounts error = null;

        if (!daoClients.containsClient(dni)) {
            error = ErrorClientAccounts.NOT_FOUND;
        } else {
            daoClients.changeName(dni, newName);
        }

        return error;
    }

    @Override public ErrorIngredient addAllergen(Client client, Ingredient allergen) {
        ErrorIngredient error = null;

        if (daoClients.containsAllergen(client, allergen)) {
            error = ErrorIngredient.DUPLICATED;
        } else {
            daoClients.addAllergen(client, allergen);
        }

        return error;
    }
}
