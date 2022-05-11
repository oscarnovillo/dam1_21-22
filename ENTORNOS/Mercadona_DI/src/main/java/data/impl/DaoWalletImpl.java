package data.impl;

import data.DaoWallet;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Wallet;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DaoWalletImpl implements DaoWallet {
    private final DataBase dataBase;

    @Inject
    public DaoWalletImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    private Set<Wallet> walletSet(Client client) {
        return dataBase.loadClientes().get(client.getDni()).getWallets();
    }

    @Override public boolean walletFound(Client client, Wallet wallet) {
        return walletSet(client).contains(wallet);
    }

    @Override public boolean walletFound(Client client, String code) {
        return walletSet(client).contains(getWallet(client, code));
    }

    private Optional<Wallet> getWallet(Map<String, Client> clientList, Client client, String code) {
        return clientList.get(client.getDni()).getWallets().stream()
                .filter(wallet1 -> wallet1.getCode().equals(code))
                .findFirst();
    }

    @Override public Wallet getWallet(Client client, String code) {
        Map<String, Client> clientList = dataBase.loadClientes();
        return getWallet(clientList, client, code).orElse(null);
    }

    @Override public List<Wallet> showWallets(Client client) {
        return walletSet(client).stream()
                .map(wallet -> new Wallet(wallet.getCode(), wallet.getMoney()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override public void addWallet(Client client, Wallet wallet) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getWallets().add(wallet);
        dataBase.saveClientes(clientList);
    }

    @Override public void addMoney(Client client, String code, double money) {
        Map<String, Client> clientList = dataBase.loadClientes();
        getWallet(clientList, client, code)
                .ifPresent(wallet -> wallet.addMoney(money));
        dataBase.saveClientes(clientList);
    }

    @Override public void decreaseMoney(Client client, String code, double money) {
        Map<String, Client> clientList = dataBase.loadClientes();
        getWallet(clientList, client, code)
                .ifPresent(wallet -> wallet.decreaseMoney(money));
        dataBase.saveClientes(clientList);
    }

}
