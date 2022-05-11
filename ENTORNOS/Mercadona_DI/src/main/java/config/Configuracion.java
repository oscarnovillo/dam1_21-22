package config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import common.ConstantsConfig;
import jakarta.ejb.Singleton;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Getter
@Log4j2
@Singleton
public class Configuracion {

    public Configuracion(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();

        try {
            JsonNode node = mapper.readTree(
                    Configuracion.class.getClassLoader().getResourceAsStream(ConstantsConfig.CONFIG_YAML));
            this.pathDatosClients = node.get(ConstantsConfig.CONFIG_PATH_DATOS_CLIENTS).asText();
            this.pathDatosProducts = node.get(ConstantsConfig.CONFIG_PATH_DATOS_PRODUCTS).asText();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private String pathDatosClients;
    private String pathDatosProducts;
}
