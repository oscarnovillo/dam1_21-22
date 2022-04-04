package servicios;

import dao.DaoClientes;

public class ServiciosTest {



    private DaoClientes dao;


    public ServiciosTest(DaoClientes dao) {
        this.dao = dao;
    }

    public void jjj()
    {
        dao.getClientes();
    }
}
