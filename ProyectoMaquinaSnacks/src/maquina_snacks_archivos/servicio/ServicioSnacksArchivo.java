package maquina_snacks_archivos.servicio;

import maquina_snacks_archivos.dominio.Snack;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivo implements IServicioSnacks {
    String FILENAME = "snacks.txt";
    boolean append = true;
    private final List<Snack> snacks = new ArrayList<>();

    public ServicioSnacksArchivo(){
        File file = new File(FILENAME);
        try {
            if (file.exists()){
                obtenerSnacks(file);
            } else{
                var fileOutput = new PrintWriter(new FileWriter(file, append));
                this.agregarSnack(new Snack("Papas", 15.50));
                this.agregarSnack(new Snack("Refresco", 28.50));
                this.agregarSnack(new Snack("Sandwich", 110));
                fileOutput.close();
                System.out.println("Se ha creado el archivo");
            }
        } catch (IOException e){
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarSnack(Snack snack){
        // agregar a la lista en memoria
        this.snacks.add(snack);
        // guardar en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack){
        File file = new File(FILENAME);
        try {
            var fileOutput = new PrintWriter(new FileWriter(file, append));
            fileOutput.println(snack.escribirSnack());
            fileOutput.close();
        } catch (IOException e){
            System.out.println("Error al agregar Snack: " + e.getMessage());
        }
    }

    private void obtenerSnacks(File file){
        try{
            var bufReader = new BufferedReader(new FileReader(file));
            var line = bufReader.readLine();
            while (line != null){
                String[] cadena = line.split(",");
                String name = cadena[1];
                double price = Double.parseDouble(cadena[2]);
                Snack snack = new Snack(name, price);
                this.snacks.add(snack);
                line = bufReader.readLine();
            }
        } catch (IOException e){
            System.out.println("Error al leer el archivo " + file.getName()
                    + ". Mensaje: " + e.getMessage());
        }

    }

    @Override
    public void mostrarSnack() {
        System.out.println("--- Snacks en el inventario ---");
        try{
            List<String> lines = Files.readAllLines(Paths.get(FILENAME));
            lines.forEach(System.out::println);
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Snack> getSnacks() {
        return snacks;
    }


}
