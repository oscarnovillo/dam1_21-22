package ui;

import com.google.gson.*;
import config.Configuracion;
import dao.DaoClientes;
import dao.DataBase;
import domain.modelo.Cliente;
import domain.modelo.ClienteNormal;
import domain.modelo.ClienteVip;
import gsonutils.RuntimeTypeAdapterFactory;
import servicios.ServiciosClientes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainClientes {


    public static void main(String[] args) {

        RuntimeTypeAdapterFactory<Cliente> adapter =
                RuntimeTypeAdapterFactory
                        .of(Cliente.class,"type")
                        .registerSubtype(Cliente.class)
                        .registerSubtype(ClienteNormal.class)
                        .registerSubtype(ClienteVip.class);

        Gson gson =  new GsonBuilder()
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
                .registerTypeAdapterFactory(adapter)
                .create();
        ServiciosClientes sc = new ServiciosClientes(
                new DaoClientes(
                        new DataBase(
                               gson,
                                Configuracion.getInstance())));
//
//        DataBase db = new DataBase(gson,Configuracion.getInstance());
//        List<Cliente> clientes = new ArrayList<>();
//        clientes.add(new ClienteNormal("alex", "89"));
//        clientes.add(new ClienteNormal("alex", "89"));
//        clientes.add(new ClienteVip("alex", "89",90.0));
//        clientes.add(new ClienteVip("alex", "89",90.0));
//        clientes.add(new ClienteNormal("alex", "89"));
        sc.addCliente(new ClienteNormal("alex", "89"));
        sc.addCliente(new ClienteVip("vip", "199", 90.0));

//        db.saveClientes(clientes);

//        clientes = sc.getClientes();
//        System.out.println(clientes);
//        clientes.add(new ClienteNormal("alex", "11111"));
//        System.out.println(gson.toJson(clientes));

//
//
//
        System.out.println(sc.getClientes());


    }
}
