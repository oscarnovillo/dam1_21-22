package ui;

import config.Configuracion;
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

            Properties p = new Properties();
            p.load(MainConfigInterno.class.getClassLoader().getResourceAsStream("config/config.properties"));

            System.out.println(p.getProperty("path_datos"));

            log.info("datos ok");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }

        System.out.println("despues del error");


    }
}
