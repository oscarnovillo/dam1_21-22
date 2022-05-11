package data.impl;

import data.DaoShopping;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Product;
import modelo.SelectedProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DaoShoppingImpl implements DaoShopping {
    private final DataBase dataBase;

    @Inject
    public DaoShoppingImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    private List<SelectedProduct> shoppingCart(Client client) {
        return dataBase.loadClientes().get(client.getDni()).getShoppingCart();
    }

    @Override public List<SelectedProduct> showShoppingCart(Client client) {
        return shoppingCart(client).stream()
                .map(selectedProduct -> new SelectedProduct(selectedProduct.getProduct()
                        , selectedProduct.getQuantity(), selectedProduct.getPrice()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override public SelectedProduct getProductFromCart(Client client, Product product) {
        return shoppingCart(client).stream()
                .filter(product1 -> product1.getProduct().equals(product))
                .findFirst()
                .orElse(null);
    }

    @Override public boolean productFoundInCart(Client client, SelectedProduct selectedProduct) {
        return shoppingCart(client).contains(selectedProduct);
    }

    @Override public void addProduct(Client client, SelectedProduct product) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getShoppingCart().add(product);
        dataBase.saveClientes(clientList);
    }

    @Override public void addProductQuantity(Client client, SelectedProduct product) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getShoppingCart().stream()
                .filter(product1 -> product1.equals(product))
                .findFirst()
                .ifPresent(product1 -> product1.addQuantity(product.getQuantity()));
        dataBase.saveClientes(clientList);
    }

    @Override public void decreaseProductQuantity(Client client, SelectedProduct product, int quantity) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getShoppingCart().stream()
                .filter(product1 -> product1.equals(product))
                .findFirst()
                .ifPresent(product1 -> product1.reduceQuantity(quantity));
        dataBase.saveClientes(clientList);
    }

    @Override public void setTotalPricePerProduct(Client client, SelectedProduct productFromCart, Product product) {
        Map<String, Client> clientList = dataBase.loadClientes();
        SelectedProduct finalProductFromCart = productFromCart;

        productFromCart = clientList.get(client.getDni()).getShoppingCart().stream()
                .filter(product1 -> product1.equals(finalProductFromCart))
                .findFirst().orElse(null);

        if (productFromCart != null) {
            double totalPrice = (product.getPrice() * productFromCart.getQuantity());
            productFromCart.setPrice(totalPrice);
            dataBase.saveClientes(clientList);
        }
    }

    @Override public void setTotalPricePerProductWithDiscount(Client client, SelectedProduct productFromCart, Product product, double discount) {
        Map<String, Client> clientList = dataBase.loadClientes();
        SelectedProduct finalProductFromCart = productFromCart;

        productFromCart = clientList.get(client.getDni()).getShoppingCart().stream()
                .filter(product1 -> product1.equals(finalProductFromCart))
                .findFirst().orElse(null);

        if (productFromCart != null) {
            double totalPriceWithoutDiscount = (product.getPrice() * productFromCart.getQuantity());
            discount *= totalPriceWithoutDiscount;

            double totalPrice = totalPriceWithoutDiscount - discount;

            productFromCart.setPrice(totalPrice);
            dataBase.saveClientes(clientList);
        }
    }

    @Override public double getTotalPrice(Client client) {
        return shoppingCart(client).stream()
                .mapToDouble(SelectedProduct::getPrice)
                .sum();
    }

    @Override public void saveShoppingCart(Client client) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni())
                .getPreviousPurchases()
                .add(shoppingCart(client));
        dataBase.saveClientes(clientList);
    }

    @Override public void resetShoppingCart(Client client) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).setShoppingCart(new ArrayList<>());
        dataBase.saveClientes(clientList);
    }

    @Override public void deleteProductFromCart(Client client, SelectedProduct selectedProduct) {
        Map<String, Client> clientList = dataBase.loadClientes();
        clientList.get(client.getDni()).getShoppingCart()
                .remove(selectedProduct);
        dataBase.saveClientes(clientList);
    }
}
