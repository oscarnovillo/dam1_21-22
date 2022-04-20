package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import domain.modelo.Persona;

import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class DataBase {


    public  List<Persona> clientes;

    private Gson gson;

    private Configuracion configuracion;

//    public DataBase() {
//
//        RuntimeTypeAdapterFactory<Cliente> adapter =
//                RuntimeTypeAdapterFactory
//                        .of(Cliente.class)
//                        .registerSubtype(ClienteNormal.class)
//                        .registerSubtype(ClienteVip.class);
//
//
//        this.gson = new GsonBuilder()
//                .registerTypeAdapter(LocalDateTime.class,
//                        (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
//                                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
//                .registerTypeAdapter(LocalDateTime.class,
//                        (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
//                                new JsonPrimitive(localDateTime.toString()))
//                .registerTypeAdapter(LocalDate.class,
//                        (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
//                                LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
//                .registerTypeAdapter(LocalDate.class,
//                        (JsonSerializer<LocalDate>) (localDateTime, type, jsonSerializationContext) ->
//                                new JsonPrimitive(localDateTime.toString()))
//                .registerTypeAdapterFactory(adapter)
//                .create();
//
//
//        this.configuracion = Configuracion.getInstance();
//    }

    public DataBase(Gson gson, Configuracion configuracion) {
        this.gson = gson;
        this.configuracion = configuracion;
    }

    public List<Persona> loadClientes() {
        Type userListType = new TypeToken<ArrayList<Persona>>() {
        }.getType();

        List<Persona> clientes = null;
        try {
            clientes = gson.fromJson(
                    new FileReader(configuracion.getPathDatos()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return clientes;
    }

    public boolean saveClientes(List<Persona> clientes) {

        try (FileWriter w = new FileWriter(configuracion.getPathDatos())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

}
