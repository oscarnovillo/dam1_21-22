package data.impl;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import common.ConstantsDataBase;
import config.Configuracion;
import gsonutils.RuntimeTypeAdapterFactory;
import io.vavr.control.Either;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.log4j.Log4j2;
import modelo.*;
import modelo.error.ErrorClientAccounts;
import modelo.error.ErrorONo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
public class DataBase {

    private final Gson gson;
    private final Configuracion configuracion;

    @Inject
    public DataBase(Gson gson, Configuracion configuracion) {
        this.gson = gson;
        this.configuracion = configuracion;
    }

    public Map<String, Client> loadClientes() {

        Type userListType = new TypeToken<Map<String, Client>>() {
        }.getType();

        Map<String, Client> clientes;
        try {
            clientes = gson.fromJson(
                    new FileReader(configuracion.getPathDatosClients()),
                    userListType);
            return clientes;
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public void saveClientes(Map<String, Client> clientes) {
        try (FileWriter w = new FileWriter(configuracion.getPathDatosClients())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public List<Product> loadProducts() {
        Type userListType = new TypeToken<ArrayList<Product>>() {
        }.getType();

        List<Product> productList;
        try {
            productList = gson.fromJson(
                    new FileReader(configuracion.getPathDatosProducts()),
                    userListType);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(), e);
            productList = new ArrayList<>();
        }
        return productList;
    }

    public void saveProducts(List<Product> productList) {
        try (FileWriter w = new FileWriter(configuracion.getPathDatosProducts())) {
            gson.toJson(productList, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}

