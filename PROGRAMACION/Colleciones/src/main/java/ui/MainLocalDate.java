package ui;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MainLocalDate {


    public static void main(String[] args) {

        LocalDate ahora = LocalDate.now();

        LocalDateTime ahoraTime = LocalDateTime.now();

        LocalDateTime unoEnero = LocalDateTime.of(2022,1,1,0,0,0,1);


        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        unoEnero = LocalDateTime.parse("01/01/2022 20:20:10",d);



        System.out.println(ahora);
        System.out.println(ahoraTime);
        System.out.println(unoEnero.minus(1, ChronoUnit.DAYS).format(d));

        System.out.println(Period.between(ahora,unoEnero.toLocalDate()).getMonths());


    }
}
