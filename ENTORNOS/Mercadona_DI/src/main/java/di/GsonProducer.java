package di;

import com.google.gson.*;
import common.ConstantsDataBase;
import config.Configuracion;
import gsonutils.RuntimeTypeAdapterFactory;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import modelo.*;

import javax.security.auth.login.Configuration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonProducer {
    @Produces
    public Gson gson() {
        RuntimeTypeAdapterFactory<Client> clientAdapter =
                RuntimeTypeAdapterFactory
                        .of(Client.class, ConstantsDataBase.DATABASE_TYPE, true)
                        .registerSubtype(ClientNormal.class)
                        .registerSubtype(ClientWithDiscount.class);

        RuntimeTypeAdapterFactory<Product> productAdapter =
                RuntimeTypeAdapterFactory
                        .of(Product.class, ConstantsDataBase.DATABASE_TYPE, true)
                        .registerSubtype(ProductNormal.class)
                        .registerSubtype(ProductWithExpirationDate.class);

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
                .registerTypeAdapterFactory(clientAdapter)
                .registerTypeAdapterFactory(productAdapter)
                .create();
    }

}
