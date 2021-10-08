package quevedo.strings;

import com.github.javafaker.Faker;

import java.util.Locale;

public class PalabrasAleatorias {


    public static void main(String[] args) {

        Faker f = new Faker(new Locale("es-ES"));

        for (int i = 0; i < 50; i++) {

        System.out.println(f.pokemon().name());
        }


    }
}
