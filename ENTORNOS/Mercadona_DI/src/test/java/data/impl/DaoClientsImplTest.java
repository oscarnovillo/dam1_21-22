package data.impl;

import modelo.Client;
import modelo.ClientNormal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DaoClientsImplTest {


    //class under test
    @InjectMocks
    DaoClientsImpl daoClients;


    //mock
    @Mock
    DataBase dataBase;

    @Captor
    ArgumentCaptor<Map<String, Client>> captor;


    @Test
    void isEmptyClientList() {
    }

    @Test
    void showClientList() {
    }

    @Test
    void getClient() {
    }

    @Test
    void containsClient() {
    }

    @Test
    void testContainsClient() {
    }


    @Test
    void addClient() {
        //given
        Client cliente = new ClientNormal("name", "dni");
        when(dataBase.loadClientes()).thenReturn(
                new HashMap<>());
        Map<String, Client> map = new HashMap<>();
        doAnswer(invocation -> {
            map.putAll(invocation.getArgument(0));
            return null;
        }).when(dataBase).saveClientes(anyMap());

        //when
        daoClients.addClient(cliente);


        //then
        assertAll(() -> assertThat(map).containsEntry("dni", cliente),
                () -> {
                    verify(dataBase).saveClientes(captor.capture());
                    Map<String, Client> clientes = captor.getValue();
                    assertThat(clientes).containsEntry("dni", cliente);
                }
        );




    }

    @Test
    void addClientExiste() {
        //given
        Client cliente = new ClientNormal("name", "dni");
        when(dataBase.loadClientes()).thenReturn(
                new HashMap<>(Map.of("dni", cliente,"dni2", cliente)));
        Map<String, Client> map = new HashMap<>();
        doAnswer(invocation -> {
            map.putAll(invocation.getArgument(0));
            return null;
        }).when(dataBase).saveClientes(anyMap());

        //when
        daoClients.addClient(cliente);


        //then
        assertAll(() -> assertThat(map).containsEntry("dni", cliente),
                () -> {
                    verify(dataBase).saveClientes(captor.capture());
                    Map<String, Client> clientes = captor.getValue();
                    assertThat(clientes).containsEntry("dni", cliente);
                }
        );




    }


    @Test
    void removeClient() {
    }

    @Test
    void changeDNI() {
    }

    @Test
    void changeName() {
        //given

        String dni = "dni";
        String newName = "newName";
        Client cliente = new ClientNormal("name", "dni");
        when(dataBase.loadClientes()).thenReturn(
                new HashMap<>(Map.of("dni", cliente)));
        Map<String, Client> mapGuardado = new HashMap<>();
        AtomicReference<String> resultadoName = new AtomicReference<>();
        doAnswer(invocation -> {
            mapGuardado.putAll(invocation.getArgument(0));
            resultadoName.set(mapGuardado.get(dni).getName());
            return null;
        }).when(dataBase).saveClientes(anyMap());

        //when
        daoClients.changeName(dni,  newName);

        //then

        assertAll(() -> assertThat(cliente.getName()).isEqualTo(newName),
                () -> assertThat(mapGuardado).containsEntry("dni", cliente),
                () -> assertThat(resultadoName.get()).isEqualTo(newName));


    }

    @Test
    void containsAllergen() {
    }

    @Test
    void addAllergen() {
    }
}
