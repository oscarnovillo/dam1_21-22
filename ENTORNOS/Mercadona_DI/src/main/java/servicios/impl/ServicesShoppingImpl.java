package servicios.impl;

import data.DaoProducts;
import data.DaoShopping;
import jakarta.inject.Inject;
import modelo.*;
import modelo.error.ErrorPaying;
import servicios.ServicesClients;
import servicios.ServicesShopping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class ServicesShoppingImpl implements ServicesShopping {
    private final DaoProducts daoProducts;
    private final DaoShopping daoShopping;
    private final ServicesClients servicesClients;

    @Inject
    public ServicesShoppingImpl(DaoProducts daoProducts, DaoShopping daoShopping, ServicesClients servicesClients) {
        this.daoProducts = daoProducts;
        this.daoShopping = daoShopping;
        this.servicesClients = servicesClients;
    }

    @Override public List<Product> printAvailableProducts(Client client) {
        return daoProducts.showProductList().stream()
                .filter(product -> product.getStock() > 0)
                .filter(product -> ((product.getClass() == ProductWithExpirationDate.class)
                        && !((ProductWithExpirationDate) product).getExpirationDate().isBefore(LocalDateTime.now()))
                        || product.getClass() == ProductNormal.class)
                .filter(product ->
                        product.getIngredients().stream()
                                .map(Ingredient::getName)
                                .noneMatch(allergenName -> client.getAllergens().stream()
                                        .map(Ingredient::getName)
                                        .collect(toSet()).contains(allergenName)))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override public List<SelectedProduct> printShoppingCart(Client client) {
        return daoShopping.showShoppingCart(client);
    }

    @Override public double getTotalPrice(Client client) {
        return daoShopping.getTotalPrice(client);
    }

    @Override public ErrorPaying addProductToCart(Client client, SelectedProduct selectedProduct) {
        String name = selectedProduct.getProduct().getName();
        int quantity = selectedProduct.getQuantity();
        Product product = daoProducts.getProduct(name);

        ErrorPaying error = null;

        if (daoProducts.getProduct(name) == null) {
            error = ErrorPaying.PRODUCT_NOT_FOUND;
        } else if (quantity < 1) {
            error = ErrorPaying.WRONG_QUANTITY;
        } else if (quantity > product.getStock()) {
            error = ErrorPaying.INSUFFICIENT_STOCK;
        } else if (daoShopping.productFoundInCart(client, selectedProduct)) {
            daoShopping.addProductQuantity(client, selectedProduct);
            updateData(client, selectedProduct, product);
        } else {
            daoShopping.addProduct(client, selectedProduct);
            updateData(client, selectedProduct, product);
        }

        return error;
    }

    private void updateData(Client client, SelectedProduct selectedProduct, Product product) {
        int quantity = selectedProduct.getQuantity();

        if (servicesClients.isClientWithDiscount(client)) {
            double discount = ((ClientWithDiscount) client).getDiscount() / 100;
            daoShopping.setTotalPricePerProductWithDiscount(client, selectedProduct, product, discount);
        } else {
            daoShopping.setTotalPricePerProduct(client, selectedProduct, product);
        }
        daoProducts.decreaseStock(product.getName(), quantity);
    }

    @Override public ErrorPaying deleteProductFromCart(Client client, String name, int quantity) {
        Product product = daoProducts.getProduct(name);
        SelectedProduct productFromCart = daoShopping.getProductFromCart(client, product);

        ErrorPaying error = null;
        if (!daoShopping.productFoundInCart(client, productFromCart)) {
            error = ErrorPaying.PRODUCT_NOT_FOUND;
        } else if (quantity > productFromCart.getQuantity()) {
            error = ErrorPaying.WRONG_LEFT_QUANTITY;
        } else if (quantity == productFromCart.getQuantity()) {
            daoShopping.deleteProductFromCart(client, productFromCart);
            daoProducts.increaseStock(name, quantity);
        } else {
            daoShopping.decreaseProductQuantity(client, productFromCart, quantity);
            daoProducts.increaseStock(name, quantity);
            daoShopping.setTotalPricePerProduct(client, productFromCart, product);
        }

        return error;
    }
}
