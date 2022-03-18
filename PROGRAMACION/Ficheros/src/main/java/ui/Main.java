package ui;

import servicios.ServiciosFicheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {
        //cargando properties







        try (FileInputStream f = new FileInputStream("config/configFuera.properties")) {
            Properties p = new Properties();
            p.load(f);

            System.out.println(p.getProperty("fuera"));
        } catch (FileNotFoundException e) {
            System.out.println("error de fichero no existe");
        } catch (IOException e) {
            System.out.println("no puedo leer fichero");
        } catch (Exception e) {
            System.out.println("otro error no reconocido");
        }


    }
}
