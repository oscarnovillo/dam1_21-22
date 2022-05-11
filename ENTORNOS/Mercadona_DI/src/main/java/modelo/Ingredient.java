package modelo;

import modelo.common.ConstantsPOJO;

import java.util.Objects;

public class Ingredient implements Clonable<Ingredient>{

    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return name.equalsIgnoreCase(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return ConstantsPOJO.INGREDIENTE +
                ConstantsPOJO.NOMBRE + name + ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public Ingredient duplicate() {
        return new Ingredient(this.name);
    }
}
