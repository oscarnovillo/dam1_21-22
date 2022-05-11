package modelo;

import modelo.common.ConstantsPOJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Product implements Comparable<Product>, Clonable<Product> {
    public String type;
    private String name;
    private double price;
    private int stock;
    private List<Ingredient> ingredients;

    public Product() {
        ingredients = new ArrayList<>();
    }

    public Product(String name, double price, int stock) {
        this();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, double price, int stock, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.ingredients = ingredients;
    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void increaseStock(int increase) {
        this.stock += increase;
    }

    public void decreaseStock(int decrease) {
        this.stock -= decrease;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return ConstantsPOJO.PRODUCTO +
                ConstantsPOJO.NOMBRE + name + ConstantsPOJO.QUOTE +
                ConstantsPOJO.PRECIO + price + ConstantsPOJO.EURO +
                ConstantsPOJO.STOCK + stock + ConstantsPOJO.UNIDADES +
                ", tipo = " + type +
                ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product producto = (Product) o;
        return name.equalsIgnoreCase(producto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Product product) {
        return this.getName().compareTo(product.getName());
    }

    /*@Override
    public Product duplicate() {
        return new Product(this.name, this.price, this.stock
                , this.ingredients.stream()
                .map(Ingredient::duplicate)
                .collect(Collectors.toUnmodifiableList()));
    }*/
}

