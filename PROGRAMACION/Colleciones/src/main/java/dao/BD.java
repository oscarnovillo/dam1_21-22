package dao;

import modelo.Cliente;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BD {

    static LinkedHashMap<String, Cliente> clientes = new LinkedHashMap<>();
    static ArrayList<Producto> productos = new ArrayList<>();

    static {
        productos.add(new Producto(12,"",12));
        productos.add(new ProductoCaducable(12,"",12, LocalDateTime.now().plusMinutes(15)));
    }

}
