package config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Properties;

@Getter
@Log4j2
@Singleton
public class Configuracion {

    private String pathDatos;
    private String pathDatos2;

    public Configuracion() {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        try  {
            Properties p = new Properties();
            p.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.pathDatos = p.getProperty("pathDatos");
            this.pathDatos2 = p.getProperty("pathDatos2");


            JsonNode node = mapper.readTree(
                    Configuracion.class.getClassLoader().getResourceAsStream("config.yaml"));
            this.pathDatos = node.get("pathDatos").asText();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
