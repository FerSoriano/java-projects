package maquina_snacks;

import java.io.Serializable;
import java.util.Objects;

// clase Entidad o Dominio del Problema
public class Snack implements Serializable {
    private static int contadorSnack = 0;
    private final int idSnack;
    private String name;
    private double price;

    public Snack(){
        this.idSnack = ++Snack.contadorSnack;
    }

    public Snack(String name, double price){
        this(); // se llama al constructor vacio
        this.name = name;
        this.price = price;
    }

    // Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // Getters
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getIdSnack(){
        return this.idSnack;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + this.idSnack +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(price, snack.price) == 0 && Objects.equals(name, snack.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, name, price);
    }
}
