package modelo;

import modelo.common.ConstantsPOJO;

import java.util.Objects;

public class Wallet implements Clonable<Wallet> {
    private final String code;
    private double money;

    public Wallet(String code, double money) {
        this.code = code;
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double quantity) {
        money += quantity;
    }

    public void decreaseMoney(double quantity) {
        money -= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(code, wallet.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return ConstantsPOJO.MONEDERO +
                ConstantsPOJO.CODIGO + code + ConstantsPOJO.QUOTE +
                ConstantsPOJO.DINERO + money + ConstantsPOJO.EURO +
                ConstantsPOJO.CLOSING_BRACKET;
    }

    @Override
    public Wallet duplicate() {
        return new Wallet(this.code, this.money);
    }
}
