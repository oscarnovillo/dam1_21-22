package servicios.impl;

import data.DaoWallet;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Wallet;
import modelo.error.ErrorPaying;
import servicios.ServicesWallet;

import java.util.List;

public class ServicesWalletImpl implements ServicesWallet {
    private final DaoWallet daoWallet;

    @Inject
    public ServicesWalletImpl(DaoWallet daoWallet) {
        this.daoWallet = daoWallet;
    }

    @Override public List<Wallet> printWalletList(Client client) {
        return daoWallet.showWallets(client);
    }

    @Override public ErrorPaying addWallet(Client client, Wallet wallet) {
        ErrorPaying error = null;
        if (wallet.getMoney() <= 0) {
            error = ErrorPaying.WRONG_QUANTITY;
        } else if (!daoWallet.walletFound(client, wallet)) {
            daoWallet.addWallet(client, wallet);
        } else {
            error = ErrorPaying.WALLET_DUPLICATED;
        }

        return error;
    }

    @Override public ErrorPaying addMoney(Client client, String code, double money) {
        ErrorPaying error = null;
        if (money <= 0) {
            error = ErrorPaying.WRONG_QUANTITY;
        } else if (daoWallet.walletFound(client, code)) {
            daoWallet.addMoney(client, code, money);
        } else {
            error = ErrorPaying.WALLET_NOT_FOUND;
        }

        return error;
    }

    @Override public ErrorPaying decreaseMoney(Client client, String code, double money) {
        ErrorPaying error = null;
        if (daoWallet.walletFound(client, code)) {
            daoWallet.decreaseMoney(client, code, money);
        } else {
            error = ErrorPaying.WALLET_NOT_FOUND;
        }

        return error;
    }

}
