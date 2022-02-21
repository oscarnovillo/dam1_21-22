package codigo;

import java.util.Scanner;

public class MainDoWhile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;

        do {
            System.out.println("introduce un numero, con 0 sales");
            i = sc.nextInt();
        } while (i != 0);

    }
}
