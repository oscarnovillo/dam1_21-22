package dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.enterprise.context.RequestScoped;
import lombok.Data;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_METHOD)
class DaoClientesTest {

    //setup
    private DaoClientes daoClientes;

    public DaoClientesTest() {
        System.out.println("DaoClientesTest");
    }
    @Test
    @DisplayName("Test de getCliente")
    void getClientes() {


        daoClientes = new DaoClientes();
        assertThat(daoClientes.getClientes());
    }

    @Test
    @DisplayName("Test de getCliente")
    void getCliente() {
        fail("Not yet implemented");
    }





}
