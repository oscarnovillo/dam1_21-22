package servicios;

import domain.modelo.Cliente;

import java.util.List;

public interface ServiciosClientes {
    boolean addCliente(Cliente c);

    boolean updateCliente(Cliente c);

    List<Cliente> getClientes();

    boolean eliminarCliente(String dni);

    Cliente buscarCliente(String dni);
}
