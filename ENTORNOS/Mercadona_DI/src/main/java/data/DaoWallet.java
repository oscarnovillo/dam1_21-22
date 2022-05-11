package data;

import modelo.Client;
import modelo.Wallet;

import java.util.List;

public interface DaoWallet {
    boolean walletFound(Client client, Wallet wallet);

    boolean walletFound(Client client, String code);

    Wallet getWallet(Client client, String code);

    List<Wallet> showWallets(Client client);

    void addWallet(Client client, Wallet wallet);

    void addMoney(Client client, String code, double money);

    void decreaseMoney(Client client, String code, double money);
}
