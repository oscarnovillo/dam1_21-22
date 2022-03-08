package ui;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anything;


public class MainHamcrestTest {

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

        String salida = o.toString();

        System.setOut(stdout);
        System.out.println(salida);

        assertThat(salida, anything("3"));
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

        assertThat(salida,anything("ERROR"));
    }

}
