package ui.viewmodel;

import domain.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

@Getter
public class PrincipalViewModel {


    private final ObservableList<Persona> _personas;


    public ObservableList<Persona> getPersonas()
    {
        return FXCollections.unmodifiableObservableList(_personas);
    }


    public PrincipalViewModel() {
        _personas = FXCollections.observableArrayList();
    }

    public void addPersona(Persona persona){
        _personas.add(persona);
    }

    public void updatePersona(Persona persona) {
        _personas.remove(persona);
        _personas.add(persona);

    }

}
