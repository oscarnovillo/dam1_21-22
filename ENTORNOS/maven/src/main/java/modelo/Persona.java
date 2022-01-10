package modelo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
