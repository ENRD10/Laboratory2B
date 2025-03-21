package ucr.lab.domain;

public class NQueenProblem {
    public String printSolution(int [][] board){
        String result = "";
        int n = board.length;
        //resolvemos iniciando en la pos fila==0, col==0
        //finalizamos en la pos fila==n-1, col==n-1

        if (solveNQueenProblem(board,0)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result += " " + board[i][j];
                }
                result += "\n"; //Salto de linea a la siguiente fila
            }
        } else result += "NO SOLUTION";

        return result;
    }

    // Método que verifica si es seguro colocar una reina en la posición (i, j)
    public boolean isSafe(int[][] board, int i, int j) {
        int n = board.length;
        int jLeft = j; // Para verificar la diagonal izquierda
        int jRight = j; // Para verificar la diagonal derecha

        while (i >= 0) { // Recorre todas las filas anteriores
            // Verifica si hay una reina en la columna, diagonal izquierda o diagonal derecha
            if ((jLeft >= 0 && board[i][jLeft] == 1) || board[i][j] == 1 || (jRight < n && board[i][jRight] == 1)) {
                return false; // No es seguro colocar la reina
            }
            i--; // Subir una fila
            jLeft--; // Moverse en diagonal izquierda
            jRight++; // Moverse en diagonal derecha
        }
        return true; // Es seguro colocar la reina
    }

    // Método recursivo que intenta colocar las reinas y cuenta las soluciones
    public boolean solveNQueenProblem(int[][] board, int i) {
        int n = board.length;

        if (i == n) { // Si todas las reinas han sido colocadas, se encontró una solución
            return true;
        } else {

            for (int j = 0; j < n; j++) { // Intentar colocar la reina en cada columna de la fila actual
                if (isSafe(board, i, j)) { // Si es seguro colocar la reina
                    board[i][j] = 1; // Coloca la reina
                   //olveNQueenProblem(board, i + 1); // Llamada recursiva para la siguiente fila
                    if (solveNQueenProblem (board, i+1)) return true;
                    board[i][j] = 0; // Retroceder (backtracking), quitar la reina para probar otra posibilidad
                }
            }
            return false;
        }
    }



}
