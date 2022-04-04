package servicios;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Configuracion;
import ui.MainYamlJackson;

import java.io.IOException;

public class ServiciosFicheros {

    public static Configuracion config;

    static Configuracion getConfig()
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();


        //onfiguracion configuracion = null;
        try {
            ServiciosFicheros.config = mapper.readValue(
                    MainYamlJackson.class.getClassLoader().getResourceAsStream("config.yaml"), Configuracion.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ServiciosFicheros.config;
    }
}
