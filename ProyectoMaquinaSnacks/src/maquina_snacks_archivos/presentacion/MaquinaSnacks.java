package maquina_snacks_archivos.presentacion;

import maquina_snacks_archivos.dominio.Snack;
import maquina_snacks_archivos.servicio.IServicioSnacks;
import maquina_snacks_archivos.servicio.ServicioSnacksArchivo;
import maquina_snacks_archivos.servicio.ServicioSnacksList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    public static void main(String[] args) {
        boolean runningProgram = true;
        List<Snack> productosComprados = new ArrayList<>();

        System.out.println("\n*** Maquina de Snacks ***");

//        IServicioSnacks snacksList = new ServicioSnacksList();
        IServicioSnacks snacksList = new ServicioSnacksArchivo();
        snacksList.mostrarSnack();

        while (runningProgram){
            Scanner scanner = new Scanner(System.in);
            mostrarMenu();
            try {
                int option = scanner.nextInt();
                switch (option){
                    case 1:
                        System.out.print("Que snack quieres comprar (id)?: ");
                        int id = scanner.nextInt();
                        comprarSnack(snacksList , id, productosComprados);
                        break;
                    case 2:
                        snacksList.mostrarSnack();
                        break;
                    case 3:
                        mostarTicket(productosComprados);
                        break;
                    case 4:
                        agregarSnacks(scanner, snacksList);
                        break;
                    case 5:
                        System.out.println("\nGracias, vuelve pronto!");
                        runningProgram = false;
                        break;
                }
            } catch (Exception e){
                System.out.println("Ocurrio una excepcion: " + e.getMessage());
            } finally {
                System.out.println(); // salto de linea con cada iteracion
            }
        }

    }

    private static void mostrarMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Compar Snack");
        System.out.println("2. Mostrar Snacks");
        System.out.println("3. Mostrar Ticket");
        System.out.println("4. Agregar Nuevo Snack");
        System.out.println("5. Finalizar compra.");
        System.out.print("Elige una opcion: ");
    }

    private static void comprarSnack(IServicioSnacks snacksList, int idSnack, List<Snack> productos){
        boolean idFound = false;
        for (var snack : snacksList.getSnacks()){
            if (idSnack == snack.getIdSnack()){
                productos.add(snack);
                System.out.println("Ok, Snack agregado al carrito: ");
                System.out.println("\t- " + snack.getName() + " - $" + snack.getPrice());
                idFound = true;
                break;
            }
        }
        if (!idFound){
            System.out.println("Id de Snack no encontrado: " + idSnack);
        }
    }

    private static void mostarTicket(List<Snack> productos){
        double total = 0.0;
        System.out.println("*** Ticket de Venta ***");
        for (Snack producto : productos){
            System.out.println("\t- " + producto.getName() + " - $" + producto.getPrice());
            total += producto.getPrice();
        }
        System.out.println("\tTotal -> $" + total);

    }

    private static void agregarSnacks(Scanner scanner, IServicioSnacks snacksList){
        System.out.print("Nombre del snack: ");
        scanner.nextLine();
        var name = scanner.nextLine();

        System.out.print("Precio del snack: ");
        double price = scanner.nextDouble();

        snacksList.agregarSnack(new Snack(name, price));
        System.out.println("Tu Snack se ha agregado correctamente");
        snacksList.mostrarSnack();
    }

}
