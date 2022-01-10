package ui;

import lombok.SneakyThrows;
import modelo.Persona;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hola Mundo");

        System.out.println("linea dos");

        Persona p = Persona.builder().nombre("pepe").dni("kpkp").build();
        p.setNombre("jj");
        Persona p1 = new Persona();

        Main m = new Main();
        m.testProperties();



    }

    @SneakyThrows
    public void testProperties() {
        Properties pro = new Properties();
        pro.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        // pro.stringPropertyNames().stream().forEach(System.out::println);
        pro.entrySet().stream().map(objectObjectEntry -> objectObjectEntry.getKey() + " "
                + objectObjectEntry.getValue()).forEach(System.out::println);
    }


}
