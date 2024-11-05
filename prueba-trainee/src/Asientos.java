import java.util.Arrays;

class Cine{

    String[][] asientos;
    Cine(String[][] asientos){
        this.asientos = asientos;
    }

    String[][] inicializarAsientos(){
        for ( int fila = 0; fila < 10; fila++ ) {
            for ( int asiento = 0; asiento < 10; asiento++){
                this.asientos[fila][asiento] = "L";
            }
        }
        return this.asientos;
    }

    void mostrarAsientos(){
        for ( String[] asiento : this.asientos){
            System.out.println(Arrays.deepToString(asiento));
        }
        System.out.println("\n");
    }

    void asignarLugar(int fila, int asiento){
        if (this.asientos[fila - 1][asiento - 1].equals("X")){
            System.out.println("Asiento Ocupado ⚠️ Intenta de nuevo.");
        } else {
            if (fila > 10 || asiento > 10){
                System.out.println("Asiento incorrecto, favor de elgir un asiento dentro del mapa");
            } else {
                this.asientos[fila - 1][asiento - 1] = "X";
                System.out.println("Listo! Ya tienes tu asiento seleccionado! 😎");
            }
        }
    }
}