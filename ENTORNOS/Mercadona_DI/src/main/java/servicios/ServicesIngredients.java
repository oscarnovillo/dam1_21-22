package servicios;

import modelo.Client;
import modelo.Ingredient;
import modelo.Product;

import java.util.List;

public interface ServicesIngredients {
    List<Ingredient> showIngredientsPerProduct(Product product);

    List<Ingredient> showAllergensPerClient(Client client);
}
