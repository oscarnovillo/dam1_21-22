package modelo;

import modelo.common.ConstantsPOJO;
import ui.common.ConstantsGeneral;

import java.util.Objects;

public class SelectedProduct implements Clonable<SelectedProduct> {
    private Product product;
    private int quantity;
    private double price;

    public SelectedProduct(Product product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public SelectedProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public SelectedProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int extraQuantity) {
        quantity += extraQuantity;
    }

    public void reduceQuantity(int deletedQuantity) {
        quantity -= deletedQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelectedProduct that = (SelectedProduct) o;
        return product.getName().equalsIgnoreCase(that.product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    @Override
    public String toString() {
        return ConstantsPOJO.PRODUCTO + product.getName() +
                ConstantsPOJO.UNIDADES_SELECCIONADAS + quantity +
                ConstantsPOJO.PRECIO_TOTAL + price +
                ConstantsGeneral.LINE_BREAK;
    }

    @Override
    public SelectedProduct duplicate() {
        return new SelectedProduct(this.product, this.quantity, this.price);
    }
}
