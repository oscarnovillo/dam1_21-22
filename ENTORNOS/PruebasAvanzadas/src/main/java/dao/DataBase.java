package dao;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import config.Configuracion;
import domain.modelo.Cliente;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class DataBase {


    private Gson gson;

    private Configuracion configuracion;


    @Inject
    public DataBase(Gson gson, Configuracion configuracion) {
        this.gson = gson;
        this.configuracion = configuracion;
    }


    public List<Cliente> loadClientes() {
        Type userListType = new TypeToken<ArrayList<Cliente>>() {
        }.getType();

        List<Cliente> clientes = null;
        try(FileReader r = new FileReader(configuracion.getPathDatos())) {
            clientes = gson.fromJson(
                    r,
                    userListType);
        } catch (IOException e) {

            log.error(e.getMessage(),e);
        }
        if (clientes == null) {
            clientes = new ArrayList<>();
        }
        return clientes;
    }

    public boolean saveClientes(List<Cliente> clientes) {

        try (FileWriter w = new FileWriter(configuracion.getPathDatos())) {
            gson.toJson(clientes, w);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

}
