package modelo;

import modelo.common.ConstantsPOJO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientWithDiscount extends Client {
    private double discount;

    public ClientWithDiscount(String name, String dni, double discount) {
        super(name, dni);
        this.discount = discount;
        type = "ClientWithDiscount";
    }

    public ClientWithDiscount(String name, String dni, double discount,
                              List<Ingredient> allergens,
                              List<List<SelectedProduct>> previousPurchases) {
        super(name, dni, allergens, previousPurchases);
        this.discount = discount;
        type = "ClientWithDiscount";
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientWithDiscount that = (ClientWithDiscount) o;
        return Objects.equals(this.getDni(), that.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipo = " + this.type +
                ConstantsPOJO.DESCUENTO + discount + ConstantsPOJO.PERCENTAGE +
                ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public Client duplicate() {
        return new ClientWithDiscount(this.getName(), this.getDni(), this.getDiscount(),
                this.getAllergens().stream()
                        .map(Ingredient::duplicate)
                        .collect(Collectors.toUnmodifiableList()),
                this.getPreviousPurchases().stream()
                        .map(list -> list.stream().map(SelectedProduct::duplicate).collect(Collectors.toUnmodifiableList()))
                        .collect(Collectors.toUnmodifiableList()));
    }
}
