package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import di.DataProducers;
import domain.modelo.Cliente;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ui.MainClientes;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Log4j2
class DataBaseTest {


    //clase a probar
    private DataBase database;


    private static SeContainer container;

    @BeforeAll
    static void beforeAll() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        container = initializer.initialize();


    }

    @BeforeEach
    void setUp() {
        try {
            Files.delete(Paths.get("test/data/cliente.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        database = container.select(DataBase.class).get();
    }

    @AfterAll
    static void afterAll() {
        container.close();
    }

    @Test
    void loadClientesFicheroNoExiste() {
        //given
        List<Cliente> resultado;



        //when
        resultado = database.loadClientes();

        //then
        assertThat(resultado).isEmpty();


    }


    @Test
    void loadClientes() {
        //given
        List<Cliente> resultado;
        try {
            Files.copy(Paths.get("test/data/clienteLoadTest.json"), Paths.get("test/data/cliente.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //when
        resultado = database.loadClientes();

        //then
        assertThat(resultado).hasSize(1);


    }

    @Test
    @Disabled
    void saveClientesMalFichero()  {
        //given
        List<Cliente> clientes = List.of(new Cliente("Juan", "123"));
//        try {
//            Files.delete(Paths.get("test/data/cliente.json"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //when
        boolean retorno = database.saveClientes(clientes);

        //then
        assertAll(() ->assertThat(new File("test/data/cliente.json")).doesNotExist(),
                () -> assertThat(retorno).isFalse());


    }
    @Test
    void saveClientes() {
        //given
        List<Cliente> clientes = List.of(new Cliente("Juan", "123"));
        List<Cliente> resultado = new ArrayList<>();

        //when
        boolean retorno = database.saveClientes(clientes);

        //then
        DataProducers dp = new DataProducers();


        Gson gson = dp.getGson();
        Type userListType = new TypeToken<ArrayList<Cliente>>() {
        }.getType();


        try(FileReader r = new FileReader("test/data/cliente.json")) {
            resultado = gson.fromJson(
                    r,
                    userListType);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        assertThat(new File("test/data/cliente.json"))
                .hasContent("[{\"dni\":\"123\",\"nombre\":\"Juan\"}]");
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).getNombre()).isEqualTo("Juan");
        assertThat(resultado.get(0)).isEqualTo(new Cliente("Juansdsdf", "123"));



    }
}
