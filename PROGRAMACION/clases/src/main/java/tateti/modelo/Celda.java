package tateti.modelo;

import java.util.Objects;

public class Celda {

    private int x;
    private int y;
    private String valor;


    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getValor() {
        if (valor == null)
            return " ";
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Celda celda = (Celda) o;
        return x == celda.x && y == celda.y
                && Objects.equals(valor, celda.valor);

    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, valor);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
