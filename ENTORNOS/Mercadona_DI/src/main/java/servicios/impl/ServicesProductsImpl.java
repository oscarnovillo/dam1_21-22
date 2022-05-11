package servicios.impl;

import data.DaoIngredient;
import data.DaoProducts;
import jakarta.inject.Inject;
import modelo.*;
import modelo.error.ErrorIngredient;
import modelo.error.ErrorProduct;
import servicios.ServicesProducts;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesProductsImpl implements ServicesProducts {
    private final DaoProducts daoProducts;
    private final DaoIngredient daoIngredient;

    @Inject
    public ServicesProductsImpl(DaoProducts daoProducts, DaoIngredient daoIngredient) {
        this.daoProducts = daoProducts;
        this.daoIngredient = daoIngredient;
    }

    @Override public List<Product> printProductList() {
        return daoProducts.showProductList();
    }

    @Override public List<Product> showProductsWithOneIngredient() {
        return daoProducts.showProductList()
                .stream().sorted()
                .filter(product -> product.getIngredients().size() == 1)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override public boolean isEmptyProductList() {
        return daoProducts.isEmptyList();
    }

    @Override public ErrorProduct addProduct(Product product) {
        ErrorProduct error = null;

        if (product.getPrice() <= 0) {
            error = ErrorProduct.WRONG_PRICE;
        } else if (product.getStock() < 0) {
            error = ErrorProduct.WRONG_STOCK;
        } else if (daoProducts.getProduct(product.getName()) != null) {
            error = ErrorProduct.DUPLICATED;
        } else {
            daoProducts.addProduct(product);
        }

        return error;
    }

    @Override public ErrorProduct deleteProduct(String name) {
        ErrorProduct error = null;

        if (daoProducts.getProduct(name) != null) {
            daoProducts.deleteProduct(name);
        } else {
            error = ErrorProduct.NOT_FOUND;
        }

        return error;
    }

    @Override public ErrorProduct setName(String name, String newName) {
        ErrorProduct error = null;

        if (daoProducts.getProduct(name) == null) {
            error = ErrorProduct.NOT_FOUND;
        } else if (daoProducts.getProduct(newName) != null) {
            error = ErrorProduct.DUPLICATED_NAME;
        } else {
            daoProducts.setName(name, newName);
        }

        return error;
    }

    @Override public ErrorProduct setPrice(String name, double price) {
        ErrorProduct error = null;

        if (price <= 0) {
            error = ErrorProduct.WRONG_PRICE;
        } else if (daoProducts.getProduct(name) == null) {
            error = ErrorProduct.NOT_FOUND;
        } else {
            daoProducts.setPrice(name, price);
        }

        return error;
    }

    @Override public ErrorProduct increaseStock(String name, int increase) {
        ErrorProduct error = null;

        if (daoProducts.getProduct(name) == null) {
            error = ErrorProduct.NOT_FOUND;
        } else {
            daoProducts.increaseStock(name, increase);
        }

        return error;
    }

    @Override public ErrorProduct decreaseStock(String name, int decrease) {
        Product product = daoProducts.getProduct(name);
        ErrorProduct error = null;

        if (daoProducts.getProduct(name) == null) {
            error = ErrorProduct.NOT_FOUND;
        } else if ((product.getStock() - decrease) < 0) {
            error = ErrorProduct.WRONG_STOCK;
        } else {
            daoProducts.decreaseStock(name, decrease);
        }

        return error;
    }

    @Override public ErrorIngredient addIngredient(Product product, Ingredient ingredient) {
        ErrorIngredient error = null;
        if (daoProducts.getProduct(product.getName()) == null) {
            error = ErrorIngredient.NOT_FOUND;
        } else if (daoIngredient.containsIngrediente(product, ingredient)) {
            error = ErrorIngredient.DUPLICATED;
        } else {
            daoIngredient.addIngredient(product, ingredient);
        }

        return error;
    }
}
