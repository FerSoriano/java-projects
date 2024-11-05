import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tickets[] tickets = new Tickets[100];
        LocalDate today = LocalDate.now();
        Scanner scanner = new Scanner(System.in);

        int numTicket = 0;
        boolean flag = true;
        while (flag){
            menu();
            byte option = scanner.nextByte();

            switch (option){
                case 1:
                    System.out.print("Selecciona la fila: ");
                    byte fila = scanner.nextByte();
                    System.out.print("Selecciona el asiento: ");
                    byte asiento = scanner.nextByte();
                    int ticketID = numTicket + 1;
                    tickets[numTicket] = new Tickets(ticketID,fila,asiento, today, today, 120.50);
                    System.out.println("Asiento seleccionado! El precio es de $" + tickets[numTicket].getPrecio());
                    numTicket++;
                    break;
                case 2:
                    double total = sumaTickets(tickets, numTicket);
                    System.out.println("El total es de $" + total);
                    break;
                case 3:
                    System.out.print("Selecciona la fila: ");
                    byte fila_ticket = scanner.nextByte();
                    getInfoFila(tickets,numTicket,fila_ticket);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    flag = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
    }

    static void menu(){
        System.out.println("----- SISTEMA DE TICKETS -----");
        System.out.println("1) Reservar ticket");
        System.out.println("2) Ver total tickets");
        System.out.println("3) Ver tickets de una fila.");
        System.out.println("4) Salir");
        System.out.print("Selecciona una opcion: ");
    }

    static double sumaTickets(Tickets[] ticket, int numTicket){
        double total = 0;
        for (int t = 0; t < numTicket; t++) {
            total += ticket[t].getPrecio();
        }
        return total;
    }

    static void getInfoFila(Tickets[] tickets, int numTicket, byte fila){
        boolean flag = false;
        for (int a = 0; a < numTicket; a++) {
            if ( fila == tickets[a].getFila() ){
                tickets[a].crearTicket();
                flag = true;
            }
        }
        if (!flag){
            System.out.println("No hay boletos para esa fila. Intenta de nuevo.");
        }
    }

}