package personas.dao;

import personas.dao.modelo.Persona;

import java.util.Arrays;

public class DaoPersona {


    private Persona[] pueblo = new Persona[100];
    private int indicePersona = 0;


    public void addPersona(Persona p)
    {
        pueblo[indicePersona] = p;
        indicePersona++;
    }



    public Persona damePersona(int indice)
    {
        return pueblo[indice];
    }

    public Persona[] damePueblo()
    {
        return Arrays.copyOf(pueblo,indicePersona);
    }



}
