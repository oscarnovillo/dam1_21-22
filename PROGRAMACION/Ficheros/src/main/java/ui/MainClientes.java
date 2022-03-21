package ui;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import dao.DaoClientes;
import dao.DataBase;
import domain.modelo.Cliente;
import domain.modelo.ClienteNormal;
import domain.modelo.ClienteVip;
import gsonutils.RuntimeTypeAdapterFactory;
import servicios.ServiciosClientes;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainClientes {


    public static void main(String[] args) {

        RuntimeTypeAdapterFactory<Cliente> adapter =
                RuntimeTypeAdapterFactory
                        .of(Cliente.class,"type")
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
        LinkedHashMap<String,Cliente> clientes = new LinkedHashMap<>();
        clientes.put("1",new ClienteNormal("alex", "1"));
        clientes.put("2",new ClienteNormal("alex", "2"));
        clientes.put("3",new ClienteVip("alex", "3",90.0));
        clientes.put("4",new ClienteVip("alex", "4",90.0));
        clientes.put("5",new ClienteNormal("alex", "5"));
//        sc.addCliente(new ClienteNormal("alex", "89"));
//        sc.addCliente(new ClienteVip("vip", "199", 90.0));

        Gson gson2 = new Gson();


        String s = gson2.toJson(clientes);


        System.out.println(s);

        Type userListType = new TypeToken<LinkedHashMap<String,Cliente>>() {
        }.getType();


        LinkedHashMap<String,Cliente> clientes2 = gson.fromJson(s,userListType);

        System.out.println(clientes2);



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
