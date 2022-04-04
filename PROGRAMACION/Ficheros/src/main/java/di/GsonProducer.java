package di;

import com.google.gson.*;
import config.Configuracion;
import domain.modelo.Cliente;
import domain.modelo.ClienteNormal;
import domain.modelo.ClienteVip;
import gsonutils.RuntimeTypeAdapterFactory;
import jakarta.enterprise.inject.Produces;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonProducer {



    @Produces
    public Gson getGson() {
        RuntimeTypeAdapterFactory< Cliente > adapter =
                RuntimeTypeAdapterFactory
                        .of(Cliente.class)
                        .registerSubtype(ClienteNormal.class)
                        .registerSubtype(ClienteVip.class);


        return new GsonBuilder()
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

    }

}
