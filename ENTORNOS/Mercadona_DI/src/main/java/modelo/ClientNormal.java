package modelo;

import modelo.common.ConstantsPOJO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ClientNormal extends Client {

    public ClientNormal(String name, String dni) {
        super(name, dni);
        type = "ClientNormal";
    }

    public ClientNormal(String name, String dni, List<Ingredient> allergens, List<List<SelectedProduct>> previousPurchases) {
        super(name, dni, allergens, previousPurchases);
        type = "ClientNormal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClientNormal that = (ClientNormal) o;
        return Objects.equals(this.getDni(), that.getDni());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipo = " + type +
                ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public Client duplicate() {
        return new ClientNormal(this.getName(), this.getDni(),
                this.getAllergens().stream()
                        .map(Ingredient::duplicate)
                        .collect(Collectors.toUnmodifiableList()),
                this.getPreviousPurchases().stream()
                        .map(list -> list.stream().map(SelectedProduct::duplicate).collect(Collectors.toUnmodifiableList()))
                        .collect(Collectors.toUnmodifiableList()));
    }
}
