package soluciones;

import java.util.Scanner;

public class Ejericio13 {


    public void ejecutar(Scanner sc) {
        int precioHora = 5;

        int horasSemana = 0;
        for (int i = 0; i < 6; i++) {
            horasSemana += sc.nextInt();

        }

        int sueldoSemanal = horasSemana * precioHora;
        System.out.println("horas " + sueldoSemanal);

    }


}
