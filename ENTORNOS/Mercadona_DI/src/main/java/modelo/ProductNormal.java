package modelo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductNormal extends Product{

    public ProductNormal(String name, double price, int stock) {
        super(name, price, stock);
        type = "ProductNormal";
    }

    public ProductNormal(String name) {
        super(name);
        type = "ProductNormal";
    }

    public ProductNormal(String name, double price, int stock, List<Ingredient> ingredients) {
        super(name, price, stock, ingredients);
        type = "ProductNormal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductNormal that = (ProductNormal) o;
        return Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public Product duplicate() {
        return new ProductNormal(this.getName(), this.getPrice(), this.getStock()
                , this.getIngredients().stream()
                .map(Ingredient::duplicate)
                .collect(Collectors.toUnmodifiableList()));
    }
}
