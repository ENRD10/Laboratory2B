package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {

    @Test
    void test() {
        SudokuSolver sudoku = new SudokuSolver();
        System.out.println("Sudoku Solver Random Board\n");
        System.out.println(printBoard(sudoku.getOriginalBoard()));
        System.out.println("\nSolution");
        System.out.println(printBoard(sudoku.getSolution()));
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