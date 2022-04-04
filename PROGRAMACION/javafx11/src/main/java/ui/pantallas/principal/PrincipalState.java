package ui.pantallas.principal;


import domain.modelo.Persona;
import lombok.Data;

import java.util.List;

@Data
public class PrincipalState {

    private final List<Persona> personas;

    private final String error;

}
