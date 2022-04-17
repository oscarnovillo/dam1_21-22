package ui;

import domain.modelo.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import servicios.ServiciosClientes;
import servicios.ServiciosClientesImpl;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.org.webcompere.systemstubs.SystemStubs.withTextFromSystemIn;


@ExtendWith(SystemStubsExtension.class)
class MainClientesTest {


    // a Probar
    private MainClientes m ;

    //dependencia
    private ServiciosClientes serviciosClientes;


    @BeforeEach
    void setUp() {

        m = new MainClientes(new ServiciosClientesFake());

    }

    @SystemStub
    private SystemOut systemOut;

    @SystemStub
    private SystemIn systemIn;


    @Test
    @DisplayName("Test menu salir")
    void main() throws Exception {
        //Given
        withTextFromSystemIn("3","dni","Juan","6").execute(() -> {

            //When
            m.main();

            //Then
            assertThat(systemOut.getLines()).contains("No se ha podido añadir el cliente",
                    "Saliendo...");
        });

    }



    private static class ServiciosClientesFake implements ServiciosClientes {

        @Override
        public boolean addCliente(Cliente c) {
            return false;
        }

        @Override
        public boolean updateCliente(Cliente c) {
            return false;
        }

        @Override
        public List<Cliente> getClientes() {
            return null;
        }

        @Override
        public boolean eliminarCliente(String dni) {
            return false;
        }

        @Override
        public Cliente buscarCliente(String dni) {
            return null;
        }
    }
}
