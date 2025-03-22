package ucr.lab.domain;

// N- Reinas utilizando backtracking(recursividad)
public class NQueen {

    // la idea:
    // si en la fila hay un 1 entonces significa una reina
    // sino se agrega un cero de relleno

    // n es la cantidad de reinas, van a controlar el tamaño del tablero
    private int n;
    // creamos la matriz del tablero
    private int[][] tablero;


    // Constructor
    public NQueen(int n) {
        this.n = n;
        // el tablero empieza con el valor de n o sea en 0
        this.tablero = new int[n][n];
    }

    public boolean puntoInicial() {

        return puntoInicialNQueens(0);
    }

    private boolean puntoInicialNQueens(int row) {
        // si la fila es igual a n entonces se puede agregar
        if (row == n) {
            return true;
        }
        // verifica en la columna
        for (int col = 0; col < n; col++) {
            // verifica los parámetros col y fila para agregar un 1 en el tablero
            if (esValido(row, col)) {
                tablero[row][col] = 1; // si permite

                // usamos recursividad para avanzar
                if (puntoInicialNQueens(row + 1)) {
                    return true;
                }
                // sino agregamos un cero, backtracking, se devuelve
                tablero[row][col] = 0;
            }
        }
        return false;
    }

    private boolean esValido(int row, int col) {

        // verifica columna, fila y diagonales
        // y lo compara con 1
        // si hay un 1 entonces, ruta incorrecta
        // esto se hace en los siguientes 3 for

        // Verificación de columna
        for (int i = 0; i < row; i++) {
            if (tablero[i][col] == 1) {
                return false; // Si ya hay una reina en la columna, no es válido
            }
        }

        // Diagonal izquierda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false; // Si hay una reina en la diagonal izquierda, no es válido
            }
        }

        // Diagonal derecha
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (tablero[i][j] == 1) {
                return false; // Si hay una reina en la diagonal derecha, no es válido
            }
        }

        return true; // Si no hay conflictos, es válido
    }
// no usamos las q y - , solo 1 y 0 para seguir instrucciones
    public void imprimirSoluciones() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("Q");
                } else {
                    System.out.print(" -- ");
                }
            }
            System.out.println();
        }
    }

    // retorna el tablero resuelto
    public int[][] getTablero() {
        return tablero;
    }
}


