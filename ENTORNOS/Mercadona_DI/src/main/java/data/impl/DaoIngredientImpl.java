package data.impl;

import data.DaoIngredient;
import data.DaoProducts;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Ingredient;
import modelo.Product;

import java.util.List;
import java.util.Map;

public class DaoIngredientImpl implements DaoIngredient {
    private final DataBase dataBase;
    private final DaoProducts daoProducts;

    @Inject
    public DaoIngredientImpl(DataBase dataBase, DaoProducts daoProducts) {
        this.dataBase = dataBase;
        this.daoProducts = daoProducts;
    }

    @Override public List<Ingredient> showIngredientsPerProduct(Product product) {
        Product finalProduct = daoProducts.getProduct(product.getName());
        return finalProduct.getIngredients();
    }

    @Override public List<Ingredient> showAllergensPerClient(Client client) {
        Map<String, Client> clientList = dataBase.loadClientes();
        return clientList.get(client.getDni()).getAllergens();
    }

    @Override public boolean containsIngrediente(Product product, Ingredient ingredient) {
        Product finalProduct = daoProducts.getProduct(product.getName());
        return finalProduct.getIngredients().contains(ingredient);
    }

    @Override public void addIngredient(Product product, Ingredient ingredient) {
        List<Product> productList = dataBase.loadProducts();
        Product finalProduct = productList.stream()
                .filter(product1 -> product1.getName().equalsIgnoreCase(product.getName()))
                .findFirst().orElse(null);

        if (finalProduct != null) {
            finalProduct.getIngredients().add(ingredient);
            dataBase.saveProducts(productList);
        }
    }
}
