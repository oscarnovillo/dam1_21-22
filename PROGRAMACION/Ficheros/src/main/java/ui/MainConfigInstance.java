package ui;

import config.Configuracion;

public class MainConfigInstance {

    public static void main(String[] args) {

        System.out.println(Configuracion.getInstance().getPathDatos());
        System.out.println(Configuracion.getInstance().getUrl());
    }
}
