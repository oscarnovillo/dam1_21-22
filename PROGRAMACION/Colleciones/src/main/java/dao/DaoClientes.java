package dao;

import modelo.Cliente;
import modelo.Clonable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DaoClientes extends DaoBase {




    public DaoClientes() {
        BD.clientes = new LinkedHashMap<>();
    }




    public List<Cliente> getClientes()
    {
        return dameListaInmutableClonada(BD.clientes.values());
    }



}
