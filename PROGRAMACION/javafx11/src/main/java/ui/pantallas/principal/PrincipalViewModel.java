package ui.pantallas.principal;

import domain.ServiciosPersonas;
import domain.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class PrincipalViewModel {

    private ServiciosPersonas serviciosPersonas;

    public PrincipalViewModel() {
        _personas = FXCollections.observableArrayList();
    }

    public PrincipalViewModel(ServiciosPersonas serviciosPersonas) {
        this();
        this.serviciosPersonas = serviciosPersonas;
    }

    private final ObservableList<Persona> _personas;


    private PrincipalState _state;
    public PrincipalState getState() {
        return _state;
    }


    public ObservableList<Persona> getPersonas()
    {
        return FXCollections.unmodifiableObservableList(_personas);
    }


    public void addPersona(Persona persona){
        serviciosPersonas.addPersona(persona);
        _personas.clear();
        _personas.addAll(serviciosPersonas.getPersonas());

    }

    public void updatePersona(Persona persona) {
        _personas.remove(persona);
        _personas.add(persona);

    }

}
