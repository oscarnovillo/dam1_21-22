package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class MainAssertJTest {

    @Test
    @DisplayName("suma correcta")
    void mainSuma()
    {
        PrintStream stdout = System.out;
        String entrada = "1\n2\n";

        System.setIn(new ByteArrayInputStream(entrada.getBytes()));

        var o  = new ByteArrayOutputStream(1000);
        System.setOut(new PrintStream(o));

        Main.main(null);

        String salida = new String(o.toByteArray());

        System.setOut(stdout);
        System.out.println(salida);

        assertThat(salida).contains("3");
    }


    @Test
    @DisplayName("Suma con un negativo")
    void mainSumaNegativos()
    {
        PrintStream stdout = System.out;
        String entrada = "-1\n2\n";

        System.setIn(new ByteArrayInputStream(entrada.getBytes()));

        var o  = new ByteArrayOutputStream(1000);
        System.setOut(new PrintStream(o));

        Main.main(null);

        String salida = new String(o.toByteArray());

        System.setOut(stdout);
        System.out.println(salida);

        assertThat(salida).contains("ERROR");
    }
}
