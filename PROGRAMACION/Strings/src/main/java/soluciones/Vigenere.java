package soluciones;

public class Vigenere {


    public static void main(String[] args) {
        String cadena = "NO TE levantes";
        String claveString = "jaje";
        int clave = 3;
        int tamañoAlfabeto = 26;
        int conversionCero = 0;

        claveString = claveString.toLowerCase();

        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {


            if (Character.isLetter(cadena.charAt(i))) {
                clave =  claveString.charAt(i%claveString.length())-'a';

                if (Character.isLowerCase(cadena.charAt(i))) {
                    conversionCero = 'a';
                } else if (Character.isUpperCase(cadena.charAt(i))) {
                    conversionCero = 'A';
                }
                int posicion =  (cadena.charAt(i)-conversionCero);
                cifrado.append((char) ((posicion + clave+tamañoAlfabeto)%tamañoAlfabeto)+conversionCero);

            } else
                cifrado.append(cadena.charAt(i));
        }
        System.out.println(cifrado);


    }
}
