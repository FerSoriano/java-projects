class Player{

    String icon;

    public Player(String icon){
        this.icon = "[" + icon + "]";
    }

    public String[][] playTurn(int row, int column,String[][] board){
            board[row][column] = this.icon;
            return board;
        }

    public boolean validMovement2(int row, int column,String[][] board){
        if ( row > 3 || column > 3){
            System.out.println("Opcion invalida. Intenta de nuevo.");
            return false;
        }
        if ( board[row][column].equals("[ ]") ) {
            board[row][column] = this.icon;
            return true;
        } else {
            System.out.println("Casilla ocupada. Intenta de nuevo.");
            return false;
        }
    }

    public boolean validMovement(int row, int column, String[][] board) {
        if (row < 0 || column < 0 ){
            System.out.println("Opción inválida. Intenta de nuevo.");
            return false;
        }
        if (row > 2 || column > 2 || !board[row][column].equals("[ ]")) {
            System.out.println((row > 2 || column > 2) ? "Opción inválida. Intenta de nuevo." : "Casilla ocupada. Intenta de nuevo.");
            return false;
        }
        board[row][column] = this.icon;
        return true;
    }

    public boolean validWin(int row, int column,String[][] board){
        String currentPosition = board[row][column];
        if (currentPosition.equals(board[row][0]) && currentPosition.equals(board[row][1]) && currentPosition.equals(board[row][2])){
            return true;
        }
        if (currentPosition.equals(board[0][column]) && currentPosition.equals(board[1][column]) && currentPosition.equals(board[2][column])) {
            return true;
        }
        if (row == column && currentPosition.equals(board[0][0]) && currentPosition.equals(board[1][1]) && currentPosition.equals(board[2][2])) {
            return true;
        }
        return row + column == 2 && currentPosition.equals(board[0][2]) && currentPosition.equals(board[1][1]) && currentPosition.equals(board[2][0]);
    }

}