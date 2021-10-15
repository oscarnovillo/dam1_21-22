package quevedo.strings;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class Cifrados {

    public static void main(String[] args) {

        char car = 'A';
        car = (char)(car -65);

        car = (char)( ( (car - 3+26)%26 )+65);
        System.out.println(car);
        System.out.println(-3%10);

    }
}
