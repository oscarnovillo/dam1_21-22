package ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import config.Configuracion;

import java.io.File;
import java.io.IOException;

public class MainYamlJackson {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        MainYamlJackson j = new MainYamlJackson();

        Configuracion order = mapper.readValue(
                j.getClass().getClassLoader().getResourceAsStream("config.yaml"), Configuracion.class);

        System.out.println(order.getPathDatos());


    }
}
