package servicios.impl;

import data.DaoShopping;
import data.DaoWallet;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.error.ErrorPaying;
import servicios.ServicesPaying;
import servicios.ServicesWallet;

public class ServicesPayingImpl implements ServicesPaying {

    private final DaoWallet daoWallet;
    private final DaoShopping daoShopping;
    private final ServicesWallet servicesWallet;

    @Inject
    public ServicesPayingImpl(DaoWallet daoWallet, DaoShopping daoShopping, ServicesWallet servicesWallet) {
        this.daoWallet = daoWallet;
        this.daoShopping = daoShopping;
        this.servicesWallet = servicesWallet;
    }

    @Override public boolean isSufficientMoney(Client client, String code) {
        return daoWallet.getWallet(client, code).getMoney() > daoShopping.getTotalPrice(client);
    }

    @Override public ErrorPaying pay(Client client, String code) {
        double money = daoShopping.getTotalPrice(client);

        ErrorPaying error;

        if (!daoWallet.walletFound(client, code)) {
            error = ErrorPaying.WALLET_NOT_FOUND;
        } else if (!isSufficientMoney(client, code)) {
            error = ErrorPaying.INSUFFICIENT_MONEY;
        } else {
            error = servicesWallet.decreaseMoney(client, code, money);
            daoShopping.saveShoppingCart(client);
            daoShopping.resetShoppingCart(client);
        }

        return error;
    }

}
