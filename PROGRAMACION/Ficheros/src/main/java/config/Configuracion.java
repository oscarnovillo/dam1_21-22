package config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
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

    public Configuracion(){

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();

            try {

                JsonNode node = mapper.readTree(Configuracion.class.getClassLoader().getResourceAsStream("config.yaml"));

                this.pathDatos = node.get("pathDatos").asText();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }



    private String pathDatos;
    private int numeroSuspensos;




}
