package dao;

import domain.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DaoClientes {


    private DataBase db;


    public DaoClientes(DataBase db) {
        this.db = db;
    }

    public DaoClientes() {
        this.db = new DataBase();
    }

    public boolean updateCliente(Cliente c) {
        boolean ok = false;

        List<Cliente> clientes = db.loadClientes();

        if (clientes != null) {
            ok = clientes.remove(c);
            if (ok) {
                clientes.add(c);
                ok = db.saveClientes(clientes);
            }
        }

        return ok;
    }


    public boolean addCliente(Cliente c) {
        boolean ok = false;
        List<Cliente> clientes = db.loadClientes();
        if (clientes == null) {
            clientes = new ArrayList<>();
        }

        clientes.add(c);
        ok = db.saveClientes(clientes);

        return ok;
    }


    public List<Cliente> getClientes() {
        return db.loadClientes();
    }

}
