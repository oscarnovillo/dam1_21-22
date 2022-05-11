package modelo;

import modelo.common.ConstantsPOJO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductWithExpirationDate extends Product {
    private final LocalDateTime expirationDate;

    public ProductWithExpirationDate(String name, double price, int stock, LocalDateTime expirationDate, List<Ingredient> ingredients) {
        super(name, price, stock, ingredients);
        this.expirationDate = expirationDate;
        type = "ProductWithExpirationDate";
    }

    public ProductWithExpirationDate(String name, double price, int stock, LocalDateTime expirationDate) {
        super(name, price, stock);
        this.expirationDate = expirationDate;
        type = "ProductWithExpirationDate";
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductWithExpirationDate that = (ProductWithExpirationDate) o;
        return Objects.equals(this.getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expirationDate);
    }

    @Override
    public String toString() {
        return super.toString() + ConstantsPOJO.CADUCIDAD
                + expirationDate.format(DateTimeFormatter.ofPattern(ConstantsPOJO.DATE_TIME_FORMAT))
                + ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public Product duplicate() {
        return new ProductWithExpirationDate(this.getName(), this.getPrice(), this.getStock()
                , this.getExpirationDate()
                , this.getIngredients().stream()
                .map(Ingredient::duplicate)
                .collect(Collectors.toUnmodifiableList()));
    }
}
