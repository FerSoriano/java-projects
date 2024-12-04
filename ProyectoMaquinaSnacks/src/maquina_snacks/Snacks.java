package maquina_snacks;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks = new ArrayList<>();

    // Bloque static Inicializador
    static {
        snacks.add(new Snack("Papas", 15.50));
        snacks.add(new Snack("Refresco", 28.00));
        snacks.add(new Snack("Sandwich", 110));
    }

    public static void agregarSnack(String name, double price){
        Snack snack = new Snack();
        snack.setName(name);
        snack.setPrice(price);
        snacks.add(snack);
    }

    public static void mostrarSnack(){
        System.out.println("--- Snacks en el Inventario ---");
        snacks.forEach(System.out::println);
    }

    public static List<Snack> getSnackslist(){
        return snacks;
    }

}
