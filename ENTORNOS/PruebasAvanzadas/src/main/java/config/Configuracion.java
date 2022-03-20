package config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;

@Getter
@Log4j2
public class Configuracion {

    private Configuracion(){}

    private static Configuracion configuracion;

    public static synchronized Configuracion getInstance(){
        if (configuracion == null)
        {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();

            try {
                configuracion = mapper.readValue(
                        Configuracion.class.getClassLoader().getResourceAsStream("config.yaml"), Configuracion.class);

                Properties p = new Properties();
                p.load(Configuracion.class.getClassLoader().getResourceAsStream("config.properties"));
                configuracion.url = p.getProperty("url");

            } catch (IOException e) {
               log.error(e.getMessage(),e);
            }
        }
        return configuracion;
    }



    private String pathDatos;
    private int numeroSuspensos;
    private String url;



}
