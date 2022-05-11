package servicios.impl;

import data.DaoClients;
import data.impl.DaoClientsImpl;
import modelo.error.ErrorClientAccounts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Nested;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServicesClientsImplTest {


    //class under test
    @InjectMocks
    ServicesClientsImpl servicesClients;

    //dependencias
    @Mock
    DaoClients daoClients;





    @BeforeEach
    void setUp() {
//        daoClients = mock(DaoClientsImpl.class);
//        servicesClients = new ServicesClientsImpl(daoClients);

    }

    @Test
    void isEmptyClientList() {
        //given
        when(daoClients.isEmptyClientList()).thenReturn(true);

        //when
        boolean respuesta = servicesClients.isEmptyClientList();

        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void printClientList() {



    }

    @Test
    void getClient() {
    }

    @Nested
    @DisplayName("Test de getClient")
    class ContainsClient {
        @Test
        void containsClient() {
            //given
            String dni = "123";
            when(daoClients.containsClient(dni)).thenReturn(true);

            //when
            ErrorClientAccounts error = servicesClients.containsClient(dni);

            //then
            assertThat(error).isNull();

        }

        @Test
        void notContainsClient() {
            //given
            String dni = "123";
            when(daoClients.containsClient(dni)).thenReturn(false);

            //when
            ErrorClientAccounts error = servicesClients.containsClient(dni);

            //then
            assertThat(error).isEqualTo(ErrorClientAccounts.NOT_FOUND);

        }
    }


    @Test
    void isClientWithDiscount() {
    }

    @Test
    void addClient() {
    }

    @Nested
    class removeCliente {

        @Test
        void removeClientNoExiste() {

            //given
            String dni = "123";
            when(daoClients.containsClient(dni)).thenReturn(false);

            //when
            ErrorClientAccounts respuesta = servicesClients.removeClient(dni);

            //then

            assertThat(respuesta).isEqualTo(ErrorClientAccounts.NOT_FOUND);

        }


        @Test
        void removeClientExiste() {

            //given
            String dni = "123";
            when(daoClients.containsClient(dni)).thenReturn(true);

            //when
            ErrorClientAccounts respuesta = servicesClients.removeClient(dni);

            //then

            assertThat(respuesta).isNull();
            verify(daoClients, times(1)).removeClient(dni);


        }

    }

    @Test
    void changeDni() {
    }

    @Test
    void changeName() {
    }

    @Test
    void addAllergen() {
    }
}
