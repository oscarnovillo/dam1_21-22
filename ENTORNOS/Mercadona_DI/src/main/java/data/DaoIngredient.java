package data;

import modelo.Client;
import modelo.Ingredient;
import modelo.Product;

import java.util.List;

public interface DaoIngredient {
    List<Ingredient> showIngredientsPerProduct(Product product);

    List<Ingredient> showAllergensPerClient(Client client);

    boolean containsIngrediente(Product product, Ingredient ingredient);

    void addIngredient(Product product, Ingredient ingredient);
}
