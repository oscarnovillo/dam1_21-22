package servicios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServiciosCalculadoraTest {

    @Test
    void pruebaSumar()
    {
        //Given
        int numero = 2;
        int numero2 = 3;

        //When
        ServiciosCalculadora sc = new ServiciosCalculadora();
        Integer respuesta = sc.suma(numero,numero2);

        //Then
        assertEquals(5,respuesta);
        assertTrue(respuesta == 5);
        assertFalse(respuesta != 5);
    }


    @Test
    void pruebaSumarNegativos()
    {
        //Given
        int numero = 0;
        int numero2 = 0;

        //When
        ServiciosCalculadora sc = new ServiciosCalculadora();
        Integer respuesta = sc.suma(numero,numero2);

        //Then
        assertNull(respuesta);
    }


}
