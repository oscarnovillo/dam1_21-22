package soluciones;

public class Cesar {

    public static void main(String[] args) {
        String cadena = "NO TE levantes";
        int clave = 3;

        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isLetter(cadena.charAt(i)))
            {
                cifrado.append((char)(cadena.charAt(i) + clave));
            }
            else
                cifrado.append(cadena.charAt(i) );
        }
        System.out.println(cifrado);
    }
}
