package ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SystemStubsExtension.class)
public class PruebasIntegracion {


    @SystemStub
    private SystemOut systemOut;



    @Test
    public void test() throws Exception {
        // Given
        SystemIn sin = new SystemIn("3", "34", "Juan", "6");

        if (Files.exists(Paths.get("test/data/cliente.json")))
            Files.delete(Paths.get("test/data/cliente.json"));

        // When
        sin.execute(() -> {
                    MainCDI.main(null);
                });


        // Then
        assertThat(systemOut.getLines()).containsExactly("1. Listar clientes",
                "2. Buscar cliente",
                "3. Añadir cliente",
                "4. Modificar cliente",
                "5. Eliminar cliente",
                "6. Salir",
                "Elige una opción: ",
                "Saliendo...");
    }
}
