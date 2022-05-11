package servicios;

import modelo.Ingredient;
import modelo.Product;
import modelo.error.ErrorIngredient;
import modelo.error.ErrorProduct;

import java.util.List;

public interface ServicesProducts {
    List<Product> printProductList();

    List<Product> showProductsWithOneIngredient();

    boolean isEmptyProductList();

    ErrorProduct addProduct(Product product);

    ErrorProduct deleteProduct(String name);

    ErrorProduct setName(String name, String newName);

    ErrorProduct setPrice(String name, double price);

    ErrorProduct increaseStock(String name, int increase);

    ErrorProduct decreaseStock(String name, int decrease);

    ErrorIngredient addIngredient(Product product, Ingredient ingredient);
}
