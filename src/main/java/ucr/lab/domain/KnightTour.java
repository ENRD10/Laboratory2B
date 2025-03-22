package ucr.lab.domain;

public class KnightTour {
    private final int n;
    private int[][] board;
    private final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightTour(int boardSize) {
        this.n = boardSize;
        this.board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1; //Inicializar el tablero con -1
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean solveKnightTour() {
        board[0][0] = 0; //Iniciar desde la primera casilla
        return solve(0, 0, 1);

    }

    private boolean solve(int x, int y, int moveCount) {
        if (moveCount == n * n) {
            return true; //Se ha visitado cada casilla
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (isValidMove(nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                if (solve(nextX, nextY, moveCount + 1)) {
                    return true;
                }
                board[nextX][nextY] = -1; //BACKTRACK
            }
        }
        return false;
    }

    private boolean isValidMove(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1);
    }
}
