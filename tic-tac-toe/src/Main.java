import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[][] board = new String[3][3];
        createBoard(board);

        Player player1 = new Player("X");
        Player player2 = new Player("O");

        System.out.println("########## NUEVO JUEGO ##########");
        showBoard(board);

        byte turn = 1;
        int attempts = 9;
        while (attempts > 0){

            boolean flag = false;
            if ( turn == 1){
                while (!flag){
                    List options = showOptions(scanner, turn);
                    flag = player1.validMovement((int) options.get(0),(int) options.get(1),board);
                    if (flag){
                        board = player1.playTurn((int) options.get(0),(int) options.get(1),board);
                        boolean isWinner = player1.validWin((int) options.get(0),(int) options.get(1),board);
                        if (isWinner){
                            showBoard(board);
                            System.out.println("Ganador: Jugador " + turn);
                            System.exit(0);
                        }
                        turn = 2;
                    }
                }
            } else {
                while (!flag){
                    List options = showOptions(scanner, turn);
                    flag = player2.validMovement((int) options.get(0),(int) options.get(1),board);
                    if (flag){
                        board = player2.playTurn((int) options.get(0),(int) options.get(1),board);
                        boolean isWinner = player2.validWin((int) options.get(0),(int) options.get(1),board);
                        if (isWinner){
                            showBoard(board);
                            System.out.println("Ganador: Jugador " + turn);
                            System.exit(0);
                        }
                        turn = 1;
                    }
                }
            }

            showBoard(board);
            attempts--;
        }
        if ( attempts == 0){
            System.out.println("Empate!");
        }
    }

    static List showOptions(Scanner scanner, byte turn){
        System.out.println("Turno jugador " + turn);
        System.out.print("Elige una fila y columna (separada por espacio): ");

        String input = scanner.nextLine();
        String[] values = input.split(" ");

        int row = -1;
        int col = -1;

        try {
            row = Byte.parseByte(values[0]) - 1;
            col = Byte.parseByte(values[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.print("Error: Formato de número inválido. ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Error: No hay suficientes valores. ");
        }

        List result = new ArrayList();
        result.add(row);
        result.add(col);

        return result;
    }

    static void createBoard(String[][] board){
        for ( int i = 0; i < board.length; i++){
            for ( int j = 0; j < board.length; j++){
                board[i][j] = "[ ]";
            }
        }
    }

    static void showBoard(String[][] board){
        for (String[] strings : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(strings[j]);
            }
            System.out.print("\n");
        }
        cleanConsole();
    }

    public static void cleanConsole() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

}