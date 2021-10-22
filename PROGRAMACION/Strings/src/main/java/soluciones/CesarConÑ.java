package soluciones;

public class CesarConÑ {

    public static void main(String[] args) {
        String cadena = "abcmnñopxyz"+"ABCMNÑOPXYZ";
        String claveString = "jaje";
        int clave = 3;
        int tamañoAlfabeto = 27;
        int conversionCero = 0;
        int correcionCero = 0;

        claveString = claveString.toLowerCase();

        StringBuilder cifrado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {


            if (Character.isLetter(cadena.charAt(i))) {
                // conseguir clave
                //clave es cte

                //convertir a cero
                correcionCero = 0;
                if (Character.isLowerCase(cadena.charAt(i))) {
                    conversionCero = 'a';
                    if ((cadena.charAt(i)=='ñ'))
                    {
                       correcionCero= -1 * ('ñ'-'o');
                    }
                    else if (cadena.charAt(i)>'n') {
                        correcionCero=1;
                    }

                } else if (Character.isUpperCase(cadena.charAt(i))) {
                    conversionCero = 'A';
                    if ((cadena.charAt(i)=='Ñ'))
                    {
                        correcionCero= -1 * ('Ñ'-'O');
                    }
                    else if (cadena.charAt(i)>'N') {
                        correcionCero=1;
                    }

                }

                // 241-97-(241-111)
                int posicion =  (cadena.charAt(i)-conversionCero+correcionCero);


                //cifrar
                char caracterCifrado = (char) ((posicion + clave+tamañoAlfabeto)%tamañoAlfabeto);

                //descifrar
                char caracterDesCifrado = (char) ((posicion - clave+tamañoAlfabeto)%tamañoAlfabeto);


                //devolver a su ascii
                //convertir a cero
                if (Character.isLowerCase(cadena.charAt(i))) {
                    correcionCero = 0;
                    if ((caracterCifrado+conversionCero=='o'))
                    {
                        correcionCero= -1 * ('ñ'-'o');
                    }
                    else if (caracterCifrado+conversionCero>'n') {
                        correcionCero=1;
                    }

                } else if (Character.isUpperCase(cadena.charAt(i))) {
                    correcionCero = 0;
                    if ((caracterCifrado+conversionCero=='O'))
                    {
                        correcionCero= -1 * ('Ñ'-'O');
                    }
                    else if (caracterCifrado+conversionCero>'N') {
                        correcionCero=1;
                    }

                }


                cifrado.append((char) (caracterCifrado+conversionCero-correcionCero));

            } else
                cifrado.append(cadena.charAt(i));
        }
        System.out.println(cadena);
        System.out.println(cifrado);
    }
}
