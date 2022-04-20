package dao;

import domain.modelo.Cliente;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ui.MainClientes;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

@TestInstance(Lifecycle.PER_METHOD)
@ExtendWith(SystemStubsExtension.class)
@ExtendWith(MockitoExtension.class)
class DaoClientesTest {

    //testar
    @InjectMocks
    private DaoClientesImpl daoClientes;

    //mockear
    @Mock
    private DataBase database;


    @BeforeEach
    private void setUp() {


    }

    @AfterEach
    private void tearDown() {

    }

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }


    @Nested
    @DisplayName("Pruebas de get clientes  ")
    class GetClientesTest {


        @Test
        @DisplayName("devolver lista de clientes")
        void getClientes() {

            //Given
            List<Cliente> base = List.of(new Cliente("pedro","123"));
            when(database.loadClientes()).thenReturn(base);

            //When
            List<Cliente> respuesta = daoClientes.getClientes();

            //Then
            assertAll(() -> assertThat(respuesta).containsAll(base),
                    () -> assertThat(respuesta.size()).isEqualTo(1));

        }

        @Test
        @DisplayName("buscar cliente encontrado")
        void buscarClienteExiste() {
            //Given
            Cliente baseCliente = new Cliente("pedro","123");
            List<Cliente> base = List.of(baseCliente);
            when(database.loadClientes()).thenReturn(base);

            //When
            Cliente respuesta = daoClientes.buscarCliente("123");


            //Then
            assertAll(
                    () -> assertThat(respuesta.getDni()).isEqualTo(baseCliente.getDni()),
                    () -> assertThat(respuesta.getNombre()).isEqualTo(baseCliente.getNombre())
            );



        }


        @Test
//        @Disabled
        @DisplayName("buscar cliente no encontrado")
        void buscarClienteNoExiste() {
            //Given
            Cliente baseCliente = new Cliente("pedro","123");
            List<Cliente> base = List.of(baseCliente);
            when(database.loadClientes()).thenReturn(base);

            //When
            Cliente respuesta = daoClientes.buscarCliente("12");


            //Then
            assertThat(respuesta).isNull();
        }


    }




}
