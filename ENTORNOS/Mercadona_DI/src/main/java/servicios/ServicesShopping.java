package servicios;

import modelo.Client;
import modelo.Product;
import modelo.SelectedProduct;
import modelo.error.ErrorPaying;

import java.util.List;

public interface ServicesShopping {
    List<Product> printAvailableProducts(Client client);

    List<SelectedProduct> printShoppingCart(Client client);

    double getTotalPrice(Client client);

    ErrorPaying addProductToCart(Client client, SelectedProduct selectedProduct);

    ErrorPaying deleteProductFromCart(Client client, String name, int quantity);
}
