package cartas.servicios;

import java.util.Random;

public class ServiciosCartas {

    public int[] generarBaraja(int numeroCartas,int numeroCartasPalo)
    {
        int cartas[] = new int[numeroCartas];
        for (int i = 0; i <numeroCartas; i++) {
            cartas[i] = (i+1)%numeroCartasPalo;
        }
        barajar(cartas);
        return cartas;
    }

    private void barajar(int []cartas)
    {
        //swap
        Random r = new Random();
        r.nextInt(39);



    }


}
