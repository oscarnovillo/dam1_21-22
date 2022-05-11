package servicios.impl;

import data.DaoIngredient;
import data.DaoProducts;
import jakarta.inject.Inject;
import modelo.Client;
import modelo.Ingredient;
import modelo.Product;
import servicios.ServicesIngredients;

import java.util.List;

public class ServicesIngredientsImpl implements ServicesIngredients {

    private final DaoIngredient daoIngredient;
    private final DaoProducts daoProducts;

    @Inject
    public ServicesIngredientsImpl(DaoIngredient daoIngredient, DaoProducts daoProducts) {
        this.daoIngredient = daoIngredient;
        this.daoProducts = daoProducts;
    }

    @Override public List<Ingredient> showIngredientsPerProduct(Product product) {
        List<Ingredient> list = null;

        if (daoProducts.getProduct(product.getName()) != null) {
            list = daoIngredient.showIngredientsPerProduct(product);
        }

        return list;
    }

    @Override public List<Ingredient> showAllergensPerClient(Client client) {
        return daoIngredient.showAllergensPerClient(client);
    }
}
