package dao;

import config.Configuracion;
import domain.modelo.Cliente;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ui.MainClientes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DataBaseTest {


    private DataBase database;


    private static SeContainer container;

    @BeforeAll
    static void beforeAll() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        container = initializer.initialize();


    }

    @BeforeEach
    void setUp() {
        database = container.select(DataBase.class).get();
    }

    @AfterAll
    static void afterAll() {
        container.close();
    }

    @Test
    void loadClientes() {
        //given

        //when

        //then

        database.loadClientes();
    }

    @Test
    void saveClientesMalFichero()  {
        //given
        List<Cliente> clientes = List.of(new Cliente("Juan", "123"));
        try {
            Files.delete(Paths.get("test/data/cliente.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        //when
        boolean retorno = database.saveClientes(clientes);

        //then
        assertThat(new File("test/data/cliente.json")).hasContent("[{\"dni\":\"123\",\"nombre\":\"Juan\"}]");


    }
}
