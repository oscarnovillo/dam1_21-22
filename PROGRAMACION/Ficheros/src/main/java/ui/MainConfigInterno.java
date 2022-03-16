package ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MainConfigInterno {


    private static Logger log = LogManager.getLogger();

    public static void main(String[] args) {

        //cargando properties

        try  {
            MainConfigInterno m = new MainConfigInterno();
            Properties p = new Properties();
            p.load(m.getClass().getClassLoader().getResourceAsStream("config.properties"));

            log.info("datos ok");
        } catch (FileNotFoundException e) {
            System.out.println("error de fichero no existe");
        } catch (IOException e) {
            System.out.println("no puedo leer fichero");
        } catch (Exception e) {
            System.out.println("otro error no reconocido");
        }


    }
}
