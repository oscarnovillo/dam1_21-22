package servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Configuracion;
import dao.DaoClientes;
import domain.modelo.Cliente;
import jakarta.inject.Inject;
import ui.MainYamlJackson;

import java.io.IOException;
import java.util.List;

public class ServiciosClientes {

    private DaoClientes dao;

    @Inject
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
