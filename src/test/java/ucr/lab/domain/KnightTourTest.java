package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTourTest {

    @Test
    void testKnightTour() {
        KnightTour kT = new KnightTour(8);
        System.out.println(printBoard(kT.getBoard()));
        System.out.println((kT.solveKnightTour()? printBoard(kT.getBoard()) : "No solution"));
    }

    private String printBoard(int[][] board) {
        String result = "";
        int n = board.length;
        for (int[] row : board) {
            for (int col : row)
                result += col == -1 ? " ■": " " + String.format("%2d", col);
            result += "\n"; //Salto de linea a la siguiente fila
        }
        return result;
    }
}