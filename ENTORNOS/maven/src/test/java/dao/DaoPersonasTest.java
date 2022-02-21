package dao;

import lombok.SneakyThrows;
import modelo.Persona;
import org.junit.jupiter.api.*;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DaoPersonasTest {

    static DaoPersonas dao = null;

    @BeforeAll
    static void setUp() {
        dao = new DaoPersonas();
    }

    @Test
    @Order(1)
    void addPersona() {

        dao.addPersona(new Persona("mm", "mm"));

        assertEquals(dao.getPersonas().size(), 1);
    }

    @Test
    @Order(2)
    void getPersonas() {
        assertEquals(dao.getPersonas().get(0).getNombre(), "mm");
    }

    @Test
    @Order(3)
    @SneakyThrows
    public void testProperties() {
        Properties pro = new Properties();
        pro.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        // pro.stringPropertyNames().stream().forEach(System.out::println);
        pro.entrySet().stream()
                .map(objectObjectEntry -> objectObjectEntry.getKey() + " " + objectObjectEntry.getValue())
                .forEach(System.out::println);
    }
}
