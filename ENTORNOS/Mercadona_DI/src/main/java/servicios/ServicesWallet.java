package servicios;

import modelo.Client;
import modelo.Wallet;
import modelo.error.ErrorPaying;

import java.util.List;

public interface ServicesWallet {
    List<Wallet> printWalletList(Client client);

    ErrorPaying addWallet(Client client, Wallet wallet);

    ErrorPaying addMoney(Client client, String code, double money);

    ErrorPaying decreaseMoney(Client client, String code, double money);
}
