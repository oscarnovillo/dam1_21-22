package ui;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import config.Configuracion;
import dao.DaoClientes;
import dao.DataBase;
import domain.modelo.Cliente;
import servicios.ServiciosClientes;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClientes {


    public static void main(String[] args) {

        ServiciosClientes sc = new ServiciosClientes(
                new DaoClientes(
                        new DataBase(
                                new GsonBuilder()
                                        .registerTypeAdapter(LocalDateTime.class,
                                                (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                                                        LocalDateTime.parse(json.getAsJsonPrimitive().getAsString()))
                                        .registerTypeAdapter(LocalDateTime.class,
                                                (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) ->
                                                        new JsonPrimitive(localDateTime.toString()))
                                        .registerTypeAdapter(LocalDate.class,
                                                (JsonDeserializer<LocalDate>) (json, type, jsonDeserializationContext) ->
                                                        LocalDate.parse(json.getAsJsonPrimitive().getAsString()))
                                        .registerTypeAdapter(LocalDate.class,
                                                (JsonSerializer<LocalDate>) (localDateTime, type, jsonSerializationContext) ->
                                                        new JsonPrimitive(localDateTime.toString()))
                                        .create(),
                                Configuracion.getInstance())));
//
//        sc.addCliente(new Cliente("alex","89"));
//        sc.addCliente(new Cliente("jorge","99"));

        System.out.println(sc.getClientes());

        Cliente.builder().nombre("jj").build();
        sc.updateCliente(new Cliente("sergio", "99"));

        System.out.println(sc.getClientes());


    }
}
