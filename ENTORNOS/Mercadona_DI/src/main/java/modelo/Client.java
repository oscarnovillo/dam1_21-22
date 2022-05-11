package modelo;

import modelo.common.ConstantsPOJO;

import java.util.*;

public abstract class Client implements Comparable<Client>,Clonable<Client>{
    public String type;
    private String name;
    private String dni;
    private final Set<Wallet> wallets;
    private List<SelectedProduct> shoppingCart;
    private List<List<SelectedProduct>> previousPurchases;
    private List<Ingredient> allergens;

    public Client() {
        wallets = new HashSet<>();
        shoppingCart = new ArrayList<>();
        previousPurchases = new ArrayList<>();
        allergens = new ArrayList<>();
    }

    public Client(String name, String dni) {
        this(dni);
        this.name = name;
        this.dni = dni;
    }

    public Client(String name, String dni,
                  List<Ingredient> allergens,
                  List<List<SelectedProduct>> previousPurchases) {
        this(dni);
        this.name = name;
        this.dni = dni;
        this.allergens = allergens;
        this.previousPurchases = previousPurchases;
    }

    public Client(String dni) {
        this();
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Wallet> getWallets() {
        return wallets;
    }

    public List<SelectedProduct> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<SelectedProduct> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<List<SelectedProduct>> getPreviousPurchases() {
        return previousPurchases;
    }

    public List<Ingredient> getAllergens() {
        return allergens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return dni.equals(client.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return ConstantsPOJO.CLIENTES +
                ConstantsPOJO.NOMBRE + name + ConstantsPOJO.QUOTE +
                ConstantsPOJO.DNI + dni +
                ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public int compareTo(Client client) {
        return this.getDni().compareTo(client.getDni());
    }

    /*@Override
    public Client duplicate() {
        return new Client(this.name, this.dni,
                this.allergens.stream()
                .map(Ingredient::duplicate)
                .collect(Collectors.toUnmodifiableList()),
                this.previousPurchases.stream()
                        .map(list -> list.stream().map(SelectedProduct::duplicate).collect(Collectors.toUnmodifiableList()))
                        .collect(Collectors.toUnmodifiableList()));
    }*/
}
