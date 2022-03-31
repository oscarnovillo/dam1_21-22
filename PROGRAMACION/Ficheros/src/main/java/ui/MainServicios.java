package ui;

import jakarta.inject.Inject;
import servicios.ServiciosClientes;

public class MainServicios {


    private ServiciosClientes serviciosClientes;

    @Inject
    public MainServicios(ServiciosClientes serviciosClientes) {
        this.serviciosClientes  = serviciosClientes;
    }

    private void menu(){
        System.out.println("1. Agregar Servicio");
        System.out.println("2. Eliminar Servicio");
        System.out.println("3. Modificar Servicio");
        System.out.println("4. Listar Servicios");
        System.out.println("5. Volver");



        System.out.println(serviciosClientes.getClientes());


    }

    public void run() {
        menu();
    }
}
