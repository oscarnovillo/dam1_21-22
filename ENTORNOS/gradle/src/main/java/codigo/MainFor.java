package codigo;

import java.util.Scanner;

public class MainFor {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        for (int i = sc.nextInt(); i != 0; i = sc.nextInt()) {
            System.out.println("intentalo otra vez");
        }

    }


}
