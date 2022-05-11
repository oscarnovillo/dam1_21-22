package data.impl;

import data.DaoProducts;
import jakarta.inject.Inject;
import modelo.Product;

import java.util.List;
import java.util.Optional;

public class DaoProductsImpl extends DaoBase implements DaoProducts {
    private final DataBase dataBase;

    @Inject
    public DaoProductsImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override public List<Product> showProductList() {
        return getUnmodifiableClonedList(dataBase.loadProducts());
    }

    @Override public boolean isEmptyList() {
        return dataBase.loadProducts().isEmpty();
    }

    private Optional<Product> getProduct(List<Product> productList, String name) {
        return productList.stream()
                .filter(product1 -> product1.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override public Product getProduct(String name) {
        return this.getProduct(dataBase.loadProducts(), name).orElse(null);
    }

    @Override public void addProduct(Product product) {
        List<Product> productList = dataBase.loadProducts();
        productList.add(product);

        dataBase.saveProducts(productList);
    }

    @Override public void deleteProduct(String name) {
        List<Product> productList = dataBase.loadProducts();
        Product product = getProduct(name);
        productList.remove(product);

        dataBase.saveProducts(productList);
    }

    @Override public void setName(String name, String newName) {
        List<Product> productList = dataBase.loadProducts();

        if (productList != null) {
            getProduct(productList, name)
                    .ifPresent(product -> {
                        product.setName(newName);
                        dataBase.saveProducts(productList);
                    });
        }
    }

    @Override public void setPrice(String name, double price) {
        List<Product> productList = dataBase.loadProducts();

        if (productList != null) {
            getProduct(productList, name)
                    .ifPresent(product -> {
                        product.setPrice(price);
                        dataBase.saveProducts(productList);
                    });
        }
    }

    @Override public void increaseStock(String name, int increase) {
        List<Product> productList = dataBase.loadProducts();

        if (productList != null) {
            getProduct(productList, name)
                    .ifPresent(product -> {
                        product.increaseStock(increase);
                        dataBase.saveProducts(productList);
                    });
        }
    }

    @Override public void decreaseStock(String name, int decrease) {
        List<Product> productList = dataBase.loadProducts();

        if (productList != null) {
            getProduct(productList, name)
                    .ifPresent(product -> {
                        product.decreaseStock(decrease);
                        dataBase.saveProducts(productList);
                    });
        }
    }

}
