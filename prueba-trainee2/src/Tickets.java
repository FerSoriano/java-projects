import java.time.LocalDate;

public class Tickets{

    int numero, fila, asiento;
    LocalDate fechaCompra, fechaValidez;
    double precio;

    // constructor
    Tickets(int numero, int fila, int asiento, LocalDate fechaCompra, LocalDate fechaValidez, double precio){
        this.numero = numero;
        this.fila = fila;
        this.asiento = asiento;
        this.fechaCompra = fechaCompra;
        this.fechaValidez = fechaValidez;
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    public int getFila(){
        return this.fila;
    }

    public void crearTicket(){
        System.out.println("\n#################################");
        System.out.println("Numero de ticket: " + this.numero);
        System.out.println("Fila: " + this.fila);
        System.out.println("Asiento: " + this.asiento);
        System.out.println("Fecha Compra: " + this.fechaCompra);
        System.out.println("Fecha Validez: " + this.fechaValidez);
        System.out.println("Precio: " + this.precio );
        System.out.println("#################################\n");
    }

}
