package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksList implements IServicioSnacks {
    private static final List<Snack> snacks = new ArrayList<>();

    // Bloque static Inicializador
    static {
        snacks.add(new Snack("Papas", 15.50));
        snacks.add(new Snack("Refresco", 28.00));
        snacks.add(new Snack("Sandwich", 110));
    }

    public void agregarSnack(Snack snack) {
        snacks.add(snack);
    }

    public void mostrarSnack() {
        System.out.println("--- Snacks en el inventario ---");
        snacks.forEach(System.out::println);
    }

    public List<Snack> getSnacks() {
        return snacks;
    }


}
