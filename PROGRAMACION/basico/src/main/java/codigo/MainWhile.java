package codigo;

import java.util.Scanner;

public class MainWhile {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;

        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        i = sc.nextInt();
        while (i != 0) {
            System.out.println("intentalo otra vez");
            i = sc.nextInt();
        }



        System.out.println("ADIOS");

    }
}
