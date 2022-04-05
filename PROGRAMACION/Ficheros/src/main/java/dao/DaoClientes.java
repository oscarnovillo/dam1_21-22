package dao;

import domain.modelo.Cliente;

import java.util.List;

public interface DaoClientes {
    boolean updateCliente(Cliente c);

    boolean addCliente(Cliente c);

    List<Cliente> getClientes();
}
