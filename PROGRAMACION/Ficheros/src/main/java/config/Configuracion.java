package config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.annotations.SerializedName;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import ui.MainConfigInterno;
import ui.MainYamlJackson;

import java.io.IOException;
import java.util.Properties;

@Getter
@Log4j2
@Singleton
public class Configuracion {

    private Configuracion(){

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();

            try {
                Configuracion configuracion = mapper.readValue(
                        Configuracion.class.getClassLoader().getResourceAsStream("config.yaml"),
                        Configuracion.class);

                this.pathDatos = configuracion.getPathDatos();

            } catch (IOException e) {
               log.error(e.getMessage(),e);
            }
        }



    private String pathDatos;
    private int numeroSuspensos;
    private String url;



}
