package cartas.ui;

import cartas.servicios.ServiciosCartas;

public class Cartas {


    public static void main(String[] args) {
        ServiciosCartas serviciosCartas = new ServiciosCartas();

        int []cartas = serviciosCartas.generarBaraja(40,10);
        int []baraja2 = serviciosCartas.generarBaraja(40,10);

        int []cartasFrancesas = serviciosCartas.generarBaraja(52,13);





    }

}
