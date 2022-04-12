package ui;

import dao.DaoClientes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import servicios.ServiciosClientes;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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

        withTextFromSystemIn("6").execute(() -> {

            m.main();
            assertThat(systemOut.getLines()).containsExactly("1. Listar clientes",
                    "2. Buscar cliente",
                    "3. Añadir cliente",
                    "4. Modificar cliente",
                    "5. Eliminar cliente",
                    "6. Salir",
                    "Elige una opción: ",
                    "Saliendo...");
        });

    }



    private static class ServiciosClientesFake extends ServiciosClientes {

        public ServiciosClientesFake() {
            super(null);
        }
    }
}
