package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NQueenProblemTest {
    @Test
    void testBoard8x8() {
        NQueenProblem queen1= new NQueenProblem();
        int[][] board1= {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},  {0,0,0,0,0,0,0,0}
        };
        System.out.println("N Queen Problem for a 8x8 board\n"); System.out.println(printBoard(board1));
        System.out.println("\nSolution");
        System.out.println(queen1.printSolution(board1));//tiene 92soluciones posibles
}
    @Test
    void testBoard4x4() {
        NQueenProblem queen = new NQueenProblem();
        int[][] board = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        System.out.println("N Queen Problem for a 4x4 board\n"); System.out.println(printBoard(board));
        System.out.println("\nSolution");
        System.out.println(queen.printSolution(board));//tiene dos soluciones posibles
    }public String printBoard(int[][] board) {
        String result = "";
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += board[i][j] == 0 ? " x" : " " + board[i][j];
            }
            result += "\n";
        }
        return result;
    }
}



