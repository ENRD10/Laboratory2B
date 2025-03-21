package ucr.lab.domain;

public class RatInMaze {
    /**
     * 0 significa una pared, no hay paso
     * 1 significa una ruta valida, si hay paso
     * 2 significa el camino correcto, la ruta de escape del laberinto
     **/
    public String printSolution(int[][] maze) {
        String result = "";
        int n = maze.length; //buenas practicas
        //resolvemos iniciando en la pos fila==0, col==0
        //finalizamos en la pos fila==n-1, col==n-1

        if (solveRatInMaze(maze, 0, 0, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result += " " + maze[i][j];
                }
                result += "\n"; //Salto de linea a la siguiente fila
            }
        } else result += "NO SOLUTION";

        return result;
    }

    public int[][] printSolutionMatriz(int[][] maze) {
        int n = maze.length; // Buenas prácticas
        int[][] solution = new int[n][n]; // Matriz para almacenar la solución

        // Si se encuentra una solución, copiar el laberinto con el camino solucionado
        if (solveRatInMaze1(maze, 0, 0, n,solution)) {
                    return solution;

        } else {
            return new int[0][0]; // Retornar matriz vacía si no hay solución
        }
    }


    private boolean solveRatInMaze (int[][] maze, int i, int j, int n) {
        //Si hemos llegado a la posicion final entonces ya encontramos la solucion
        if (i==n-1 && j==n-1) {
            maze[i][j] = 2; //marcamos la ultima posicion como ruta valida
            return true;
        }
        if (isSafe(maze, i, j, maze.length)){
            maze[i][j] = 2; //marcamos la ruta
            if (solveRatInMaze (maze, i+1, j, n)) return true;
            if (solveRatInMaze (maze, i, j+1, n)) return true;

            //BACKTRACK: desmarca (i, j) como parte de la ruta
            maze[i][j] = 1; //desmarcamos la ruta
        }
        return false;
    }
    // Método auxiliar para resolver el laberinto y almacenar el camino en `solution`
    private boolean solveRatInMaze1(int[][] maze, int x, int y, int n, int[][] solution) {
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, n)) {
            solution[x][y] = 1; // Marcar la celda como parte del camino

            // Moverse hacia la derecha
            if (solveRatInMaze1(maze, x, y + 1, n, solution)) return true;

            // Moverse hacia abajo
            if (solveRatInMaze1(maze, x + 1, y, n, solution)) return true;

            // Si ninguna dirección funciona, hacer backtracking
            solution[x][y] = 0;
        }

        return false;
    }

    private boolean isSafe(int[][] maze, int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n && maze[i][j]==1;
    }
}
