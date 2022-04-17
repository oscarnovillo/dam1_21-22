package dao;

import domain.modelo.Cliente;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoClientesImpl implements DaoClientes {


    private DataBase db;


    @Inject
    public DaoClientesImpl(DataBase db) {
        this.db = db;
    }


    @Override
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

    @Override
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

    @Override
    public List<Cliente> getClientes() {
        return db.loadClientes();
    }

    @Override
    public boolean eliminarCliente(String dni) {
        boolean ok = false;
        List<Cliente> clientes = db.loadClientes();

        Optional<Cliente> optionalCliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();
        optionalCliente.ifPresent(clientes::remove);
        ok = optionalCliente.isPresent();

        optionalCliente.ifPresent(c -> db.saveClientes(clientes));

        return ok;

    }

    @Override
    public Cliente buscarCliente(String dni) {
        Cliente encontrado = null;
        List<Cliente> clientes = db.loadClientes();

        Optional<Cliente> optionalCliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();
        if (optionalCliente.isPresent())
            encontrado = optionalCliente.get();


        return encontrado;
    }
}
