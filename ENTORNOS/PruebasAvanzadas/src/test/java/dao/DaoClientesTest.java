package dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.enterprise.context.RequestScoped;
import lombok.Data;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import ui.MainClientes;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_METHOD)
@ExtendWith(SystemStubsExtension.class)
class DaoClientesTest {

    //setup
    private DaoClientes daoClientes;

    @SystemStub
    private SystemOut systemOut;

    @SystemStub
    private SystemIn systemIn;

//    public DaoClientesTest() {
//        System.out.println("DaoClientesTest");
//    }
    @Test
    @DisplayName("Test de getCliente")
    void getClientes() {

        MainClientes m = new MainClientes(null);
        m.main();

        assertThat(systemOut.getLines()).containsExactly("to out");


    }

    @Test
    @DisplayName("Test de getCliente")
    void getCliente() {
        fail("Not yet implemented");
    }





}
