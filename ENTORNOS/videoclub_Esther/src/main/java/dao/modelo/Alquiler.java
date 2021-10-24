package dao.modelo;

import java.time.LocalDateTime;

public class Alquiler {
    private LocalDateTime fechaAlquiler;
    private Socio socio;
    private Producto productoAlquilado;

    public Alquiler(LocalDateTime fechaAlquiler, Socio socio, Producto productoAlquilado) {
        this.fechaAlquiler = fechaAlquiler;
        this.socio = socio;
        this.productoAlquilado = productoAlquilado;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Producto getProductoAlquilado() {
        return productoAlquilado;
    }

    public void setProductoAlquilado(Producto productoAlquilado) {
        this.productoAlquilado = productoAlquilado;
    }
}
