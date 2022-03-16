package ui;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import domain.modelo.Cliente;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainCargarJson {

    public static void main(String[] args) throws FileNotFoundException {
//        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
//                (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())).registerTypeAdapter(LocalDateTime.class,
//                (JsonSerializer<LocalDateTime>) (localDateTime, type, jsonSerializationContext) -> new JsonPrimitive(localDateTime.toString())
//        ).create();


        Gson gson = new Gson();
        System.out.println(gson.toJson(List.of(new Cliente("jj","nombre"))));
        Type userListType = new TypeToken<ArrayList<Cliente>>(){}.getType();

       List cliente  = gson.fromJson(new FileReader("data/cliente.json"),userListType);

        System.out.println(cliente);

    }
}
