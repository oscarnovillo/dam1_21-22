package data;

import modelo.Product;

import java.util.List;

public interface DaoProducts {
    List<Product> showProductList();

    boolean isEmptyList();

    Product getProduct(String name);

    void addProduct(Product product);

    void deleteProduct(String name);

    void setName(String name, String newName);

    void setPrice(String name, double price);

    void increaseStock(String name, int increase);

    void decreaseStock(String name, int decrease);
}
