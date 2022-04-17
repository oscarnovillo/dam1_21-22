package servicios;

import dao.DaoClientes;
import domain.modelo.Cliente;
import jakarta.inject.Inject;

import java.util.List;

public class ServiciosClientesImpl implements ServiciosClientes {

    private DaoClientes dao;

    @Inject
    public ServiciosClientesImpl(DaoClientes dao) {
        this.dao = dao;
    }

    @Override
    public boolean addCliente(Cliente c)
    {
        return dao.addCliente(c);
    }


    @Override
    public boolean updateCliente(Cliente c)
    {
        return dao.updateCliente(c);
    }


    @Override
    public List<Cliente> getClientes() {
        return dao.getClientes();
    }

    @Override
    public boolean eliminarCliente(String dni) {
        return dao.eliminarCliente(dni);
    }


    @Override
    public Cliente buscarCliente(String dni) {
        return dao.buscarCliente(dni);
    }
}
