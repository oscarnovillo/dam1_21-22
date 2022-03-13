package servicios;

public class ServiciosCalculadora {


    public Integer suma(int numero,int numero2)
    {
        if ((numero >= 0) && (numero2 >= 0))
            return (numero + numero2);
        else
            return null;
    }


}
