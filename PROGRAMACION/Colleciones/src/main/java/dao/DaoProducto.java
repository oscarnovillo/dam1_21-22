package dao;

import modelo.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProducto {

    private ArrayList<Producto> productos;


    public DaoProducto() {
        this.productos = new ArrayList<>();
    }



    public List<Producto> verProductos()
    {
        return productos.stream()
                .map(producto -> new Producto(producto.getPrecio(),producto.getNombre(), producto.getStock()))
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean addProducto(Producto p)
    {
        return productos.add(p);
    }


    public boolean updateProducto(Producto p)
    {
        boolean updated= false;
        int posicion =productos.indexOf(p);
        if (posicion >= 0) {
            productos.set(posicion, p);
            updated = true;
        }
        return updated;
    }


    public boolean updateProducto(String nombre,int cambioStock)
    {
        boolean updated= false;
        int posicion =productos.indexOf(new Producto(nombre));
        if (posicion >= 0) {
            Producto p = productos.get(posicion);
            p.aumentarStock(cambioStock);
            updated = true;
        }
        return updated;
    }



    public boolean borrarProducto(String nombre)
    {
        boolean updated= false;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre().equals(nombre))
            {
                productos.remove(i);
            }

        }

        return productos.remove(new Producto(nombre));
    }


    public boolean updateProducto(String nombre,double precio)
    {
        boolean updated= false;
        int posicion =productos.indexOf(new Producto(nombre));
        if (posicion >= 0) {
            Producto p = productos.get(posicion);
            p.setPrecio(precio);
            updated = true;
        }
        return updated;
    }




}
