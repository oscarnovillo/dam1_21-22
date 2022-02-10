package modelo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.AccessControlContext;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 *
 * esta clase s de persona
 */
public class Persona {

    private String dni;

    private String nombre;
}
