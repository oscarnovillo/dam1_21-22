package servicios;

import dao.DaoClientes;
import domain.modelo.Cliente;

import java.util.List;

public class ServiciosClientes {

    private DaoClientes dao;

    public ServiciosClientes(DaoClientes dao) {
        this.dao = dao;
    }

    public boolean addCliente(Cliente c)
    {
        return dao.addCliente(c);
    }


    public boolean updateCliente(Cliente c)
    {
        return dao.updateCliente(c);
    }


    public List<Cliente> getClientes() {
        return dao.getClientes();
    }
}
