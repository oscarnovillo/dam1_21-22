package ui;

import domain.modelo.Cliente;
import jakarta.inject.Inject;
import servicios.ServiciosClientes;

import java.util.Scanner;

public class MainClientes {

    private ServiciosClientes serviciosClientes;

    @Inject
    public MainClientes(ServiciosClientes sc) {
        this.serviciosClientes = sc;
    }

    public void main() {

        //menu de opciones
        Scanner sc = new Scanner(System.in);
        String dni = null;
        String nombre = null;
        boolean hecho = false;
        int opcion = 0;
        do {
            System.out.println("1. Listar clientes");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Añadir cliente");
            System.out.println("4. Modificar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Salir");
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(serviciosClientes.getClientes());
                    break;
                case 2:
                    System.out.println("Introduce el dni del cliente a eliminar: ");
                    dni = sc.nextLine();
                    Cliente encontrado = serviciosClientes.buscarCliente(dni);
                    if (encontrado != null) {
                        System.out.println(encontrado);

                    } else {
                        System.out.println("No se ha encontrado el cliente");
                    }
                    break;
                case 3:
                    //pedir datos del cliente
                    System.out.println("Introduce el dni: ");
                    dni = sc.nextLine();
                    System.out.println("Introduce el nombre: ");
                    nombre = sc.nextLine();
                    hecho = serviciosClientes.addCliente(new Cliente(dni, nombre));
                    if (hecho) {
                        System.out.println("Cliente añadido correctamente");
                    } else {
                        System.out.println("No se ha podido añadir el cliente");
                    }
                    break;
                case 4:
                    //pedir datos del cliente
                    System.out.println("Introduce el dni: ");
                    dni = sc.nextLine();
                    System.out.println("Introduce el nombre: ");
                    nombre = sc.nextLine();
                    hecho = serviciosClientes.updateCliente(new Cliente(dni, nombre));
                    if (hecho) {
                        System.out.println("Cliente modificado correctamente");
                    }
                    else {
                        System.out.println("No se ha podido modificar el cliente");
                    }
                    break;
                case 5:
                    System.out.println("Eliminar cliente");
                    // pedir dni del cliente
                    System.out.println("Introduce el dni del cliente a eliminar: ");
                    dni = sc.nextLine();
                    hecho = serviciosClientes.eliminarCliente(dni);
                    if (hecho) {
                        System.out.println("Cliente eliminado correctamente");
                    }
                    else {
                        System.out.println("No se ha podido eliminar el cliente");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 6);


    }
}
