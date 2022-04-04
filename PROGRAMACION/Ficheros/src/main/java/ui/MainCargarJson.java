package ui;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import domain.modelo.Cliente;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainCargarJson {

    public static void main(String[] args) throws IOException {
//        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
//                (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())).registerTypeAdapter(LocalDateTime.class,
//                (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) -> new JsonPrimitive(localDateTime.toString())
//        ).create();


        Gson gson = new Gson();
//        FileWriter w = new FileWriter("data/temp.json");
//        gson.toJson(List.of(new Cliente("jj","nombre"),new Cliente("2","nombre")),
//                w);
//
//        w.close();

//         w = new FileWriter("data/unCliente.json");
//        gson.toJson(new Cliente("jj","nombre"),
//                w);
//
//        w.close();


        Cliente c = gson.fromJson(
                new FileReader("data/unCliente.json"),
                Cliente.class);

        System.out.println(c);

        Type userListType = new TypeToken<ArrayList<Cliente>>(){}.getType();

       List<Cliente> cliente  = gson.fromJson(
               new FileReader("data/cliente.json"),
               userListType);

        System.out.println(cliente);

    }
}
