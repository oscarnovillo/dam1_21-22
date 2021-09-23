package codigo;

import java.util.Scanner;

public class MainString {


    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);


        String s = sc.nextLine();


        if (s.toUpperCase().charAt(0) == 'J')
        {
            System.out.println("hola juan");
        }

        if (s.substring(0, 1).equals("J"))
        {
            System.out.println("hola juan");
        }

    }
}
