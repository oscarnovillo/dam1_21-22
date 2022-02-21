package dao;

import modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoPersonas {

    private List<Persona> personas;

    public DaoPersonas() {
        this.personas = new ArrayList<>();
    }

    /**
     * add persona
     * 
     * @param p
     * @return
     */
    public boolean addPersona(Persona p) {
        return personas.add(p);
    }

    public List<Persona> getPersonas() {
        return personas.stream().collect(Collectors.toUnmodifiableList());
    }

}
