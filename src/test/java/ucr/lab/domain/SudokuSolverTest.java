package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void test() {
        SudokuSolver solver = new SudokuSolver();
        int[][] board = solver.randomBoard();
        System.out.println("Sudoku Solver Random Board\n");
        System.out.println(printBoard(board));
        int[][] solution = solver.getSolution(board);
        System.out.println("\nSolution");
        System.out.println(printBoard(solution));
    }

    private String printBoard(int[][] board) {
        String result = "";
        int n = board.length;
        for (int[] ints : board) {
            for (int j = 0; j < n; j++) {
                result += " " + ints[j];
            }
            result += "\n"; //Salto de linea a la siguiente fila
        }
        return result;
    }
}