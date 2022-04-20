package servicios;

import dao.DaoClientesImpl;
import domain.modelo.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiciosClientesImplTest {



    // a testear
    @InjectMocks
    ServiciosClientesImpl serviciosClientes;

    @Mock
    DaoClientesImpl daoClientes;



    @Test
    void addCliente() {
        //given
        Cliente c = new Cliente("nombre","dni");
        when(daoClientes.addCliente(c)).thenReturn(true);


        //when
        boolean respuesta = serviciosClientes.addCliente(c);

        //then
        assertThat(respuesta).isTrue();
    }



    @Test
    void updateCliente() {
    }

    @Test
    void getClientes() {
    }

    @Test
    void eliminarCliente() {
    }

    @Test
    void buscarCliente() {
    }
}
