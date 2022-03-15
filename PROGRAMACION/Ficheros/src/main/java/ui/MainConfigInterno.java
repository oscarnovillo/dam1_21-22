package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainConfigInterno {

    public static void main(String[] args) {

        //cargando properties

        try  {
            MainConfigInterno m = new MainConfigInterno();
            Properties p = new Properties();
            p.load(m.getClass().getClassLoader().getResourceAsStream("config.properties"));

            System.out.println(p.getProperty("path_datos"));
        } catch (FileNotFoundException e) {
            System.out.println("error de fichero no existe");
        } catch (IOException e) {
            System.out.println("no puedo leer fichero");
        } catch (Exception e) {
            System.out.println("otro error no reconocido");
        }


    }
}
