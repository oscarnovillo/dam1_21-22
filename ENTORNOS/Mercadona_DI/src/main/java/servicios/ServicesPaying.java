package servicios;

import modelo.Client;
import modelo.error.ErrorPaying;

public interface ServicesPaying {
    boolean isSufficientMoney(Client client, String code);

    ErrorPaying pay(Client client, String code);
}
