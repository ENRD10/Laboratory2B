package ucr.lab.domain;

public class RatInMaze {
    /**
     * 0 significa una pared, no hay paso
     * 1 significa una ruta valida, si hay paso
     * 2 significa el camino correcto, la ruta de escape del laberinto
     **/
    public String printSolution(int [][] maze){
        String result = "";
        int n = maze.length; //buenas practicas
        //resolvemos iniciando en la pos fila==0, col==0
        //finalizamos en la pos fila==n-1, col==n-1

        if (solveRatInMaze (maze, 0, 0, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result += " " + maze[i][j];
                }
                result += "\n"; //Salto de linea a la siguiente fila
            }
        } else result += "NO SOLUTION";

        return result;
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

    private boolean isSafe(int[][] maze, int i, int j, int n) {
        return i>=0 && i<n && j>=0 && j<n && maze[i][j]==1;
    }
}
