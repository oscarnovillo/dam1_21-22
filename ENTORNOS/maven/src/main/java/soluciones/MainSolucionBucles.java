package soluciones;

import java.util.Random;
import java.util.Scanner;

public class MainSolucionBucles {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // int ahorrado = 0;
        // for (int i = 0; i < 12; i++) {
        // System.out.println("dna ele dinero del mes " + (i + 1));
        // ahorrado += r.nextInt(100) + 1;
        // System.out.println(ahorrado + " en mes " + (i + 1));
        // }
        //
        // System.out.println("ahorarado " + ahorrado);
        //
        //
        // Ejericio13 e = new Ejericio13();
        // e.ejecutar(sc);
        //
        //
        // // ejer 14
        // int kmPrimero = 70;
        // int kmSegundo = 150;
        //
        // while (kmPrimero != kmSegundo) {
        // kmPrimero++;
        // kmSegundo--;
        //
        // }
        // System.out.println(kmPrimero + " encuentran");
        //
        // kmPrimero = 70;
        // kmSegundo = 150;
        // for (; kmPrimero != kmSegundo; kmPrimero++, kmSegundo--) ;
        //
        //
        // System.out.println(kmPrimero);
        //
        //
        // // ejer 15
        //
        // int pago = 10;
        // for (int i = 0; i < 19; i++) {
        // int pagoMensual = pago * 2;
        // pago += pagoMensual;
        // System.out.println(pagoMensual);
        // }
        // System.out.println(pago);
        //
        // //ej 16
        // int numeroTrabajadores = 8;
        //
        // int costeEmpresa=0;
        // for (int i = 0; i < numeroTrabajadores; i++) {
        // int horasSemanalesTrabajador =sc.nextInt();
        // int precioHoraTrabajador = sc.nextInt();
        // int sueldoTrabajador =horasSemanalesTrabajador*precioHoraTrabajador;
        // costeEmpresa += sueldoTrabajador;
        //
        // System.out.println(sueldoTrabajador);
        // }
        // System.out.println("pagan "+costeEmpresa);
        //
        //
        // //ej 17
        // numeroTrabajadores = 8;
        //
        // costeEmpresa=0;
        // for (int i = 0; i < numeroTrabajadores; i++) {
        // int numeroDiasTrabajado = sc.nextInt();
        //
        // int horasSemanalesTrabajador = 0;
        // for (int j = 0; j < numeroDiasTrabajado; j++) {
        // int horasDiarias =sc.nextInt();
        // horasSemanalesTrabajador += horasDiarias;
        // }
        //
        // int precioHoraTrabajador = sc.nextInt();
        // int sueldoTrabajador =horasSemanalesTrabajador*precioHoraTrabajador;
        // costeEmpresa += sueldoTrabajador;
        //
        // System.out.println(sueldoTrabajador);
        // }
        // System.out.println("pagan "+costeEmpresa);
        //

        for (int horas = 0; horas < 24; horas++) {
            for (int minutos = 0; minutos < 60; minutos++) {
                for (int segundos = 0; segundos < 60; segundos++) {

                    Thread.sleep(1000);
                    System.out.printf("%02d:%02d:%02d %n", horas, minutos, segundos);
                }
            }
        }

    }
}
