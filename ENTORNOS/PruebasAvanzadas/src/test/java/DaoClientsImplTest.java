
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DaoClientsImplTest {


//    //class under test
//    @InjectMocks
//    DaoClientsImpl daoClients;
//
//
//    //mock
//    @Mock
//    DataBase dataBase;
//
//    @Captor
//    ArgumentCaptor<Map<String, Client>> captor;
//
//
//    @Test
//    void isEmptyClientList() {
//    }
//
//    @Test
//    void showClientList() {
//    }
//
//    @Test
//    void getClient() {
//    }
//
//    @Test
//    void containsClient() {
//    }
//
//    @Test
//    void testContainsClient() {
//    }
//
//
//    @Test
//    void addClient() {
//        //given
//        Client cliente = new ClientNormal("name", "dni");
//        when(dataBase.loadClientes()).thenReturn(new HashMap<>());
//        Map<String, Client> map = new HashMap<>();
//        doAnswer(invocation -> {
//            map.putAll(invocation.getArgument(0));
//            return null;
//        }).when(dataBase).saveClientes(anyMap());
//
//        //when
//        daoClients.addClient(cliente);
//
//
//        assertAll(() -> assertThat(map).containsEntry("dni", cliente),
//                () -> {
//                    verify(dataBase).saveClientes(captor.capture());
//                    Map<String, Client> clientes = captor.getValue();
//                    assertThat(clientes).containsEntry("dni", cliente);
//                }
//        );
//
//
//
//
//    }
//
//
//    @Test
//    void removeClient() {
//    }
//
//    @Test
//    void changeDNI() {
//    }
//
//    @Test
//    void changeName() {
//    }
//
//    @Test
//    void containsAllergen() {
//    }
//
//    @Test
//    void addAllergen() {
//    }
}
