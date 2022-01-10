package codigo;

public class MainSwitch {


    public static void main(String[] args) {

        int kaka = 5;
        String nombre = "PEPE";


        switch (kaka) {
            case 1:
            case 2:
            case 34: {
                System.out.println("cuatro");
            }
                break;
            case 3:
                System.out.println("cinco");
                break;
            case 5:
                System.out.println("seis");
                break;
            default:
                System.out.println("no encontrado");

        }


        int i = 9;

        if (i <= 5 && i >= 0) {
            System.out.println();
        } else if (i >= 7) {
            System.out.println();
        }


    }
}
