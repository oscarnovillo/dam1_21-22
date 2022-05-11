package data;

import modelo.Client;
import modelo.Product;
import modelo.SelectedProduct;

import java.util.List;

public interface DaoShopping {
    List<SelectedProduct> showShoppingCart(Client client);

    SelectedProduct getProductFromCart(Client client, Product product);

    boolean productFoundInCart(Client client, SelectedProduct selectedProduct);

    void addProduct(Client client, SelectedProduct product);

    void addProductQuantity(Client client, SelectedProduct product);

    void decreaseProductQuantity(Client client, SelectedProduct product, int quantity);

    void setTotalPricePerProduct(Client client, SelectedProduct productFromCart, Product product);

    void setTotalPricePerProductWithDiscount(Client client, SelectedProduct productFromCart, Product product, double discount);

    double getTotalPrice(Client client);

    void saveShoppingCart(Client client);

    void resetShoppingCart(Client client);

    void deleteProductFromCart(Client client, SelectedProduct selectedProduct);
}
