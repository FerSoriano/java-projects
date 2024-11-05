import java.util.Scanner;

/** Prueba Trainee - Hacer un sistema de apartado de un Cine, hay 10 filas de 10 asientos.
 *  Al inicio todos los asientos deben de marcarse como L (libres)
 *  Cuando uno se ocupe debe aparecer como X
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] asientos = new String[10][10];
        Cine cine = new Cine(asientos);
        cine.inicializarAsientos();

        while (true){
            mostrarMenu();
            byte option = scanner.nextByte();
            if (option == 1){
                cine.mostrarAsientos();
            } else if (option == 2) {
                seleccionarAsiento(scanner, cine);
            } else if (option == 3) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opcion incorrecta!");
            }
        }
    }

    static void mostrarMenu(){
        System.out.println("1. Mostrar mapa");
        System.out.println("2. Seleccionar un asiento");
        System.out.println("3. Salir");
    }

    static void seleccionarAsiento(Scanner scanner, Cine cine){
        System.out.print("Selecciona una fila: ");
        byte fila = scanner.nextByte();
        System.out.print("Selecciona un asiento: ");
        byte asiento = scanner.nextByte();
        cine.asignarLugar(fila,asiento);
    }

}