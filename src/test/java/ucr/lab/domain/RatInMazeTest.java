package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatInMazeTest {

    private RatInMaze rat = new RatInMaze();

    @Test
    void testMaze1() {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        System.out.println("Rat in maze for a 4x4 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }

    @Test
    void testMaze2() {
        int[][] maze = {
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1}
        };
        System.out.println("Rat in maze for an 8x8 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }

    @Test
    void testMaze3() {
        int[][] maze = new int[10][10];
        fillMaze(maze);
        System.out.println("Rat in maze for a 10x10 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }

    @Test
    void testMaze4() {
        int[][] maze = new int[12][12];
        fillMaze(maze);
        System.out.println("Rat in maze for a 12x12 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }

    @Test
    void testMaze5() {
        int[][] maze = new int[16][16];
        fillMaze(maze);
        System.out.println("Rat in maze for a 16x16 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }

    private void fillMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = (Math.random() < 0.7) ? 1 : 0; // 70% de pasillos
            }
        }
        maze[0][0] = 1; // Entrada
        maze[maze.length - 1][maze[0].length - 1] = 1; // Salida
    }


    private String printBoard(int[][] maze) {
        String result = "";
        int n = maze.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += maze[i][j] == 0 ? " x" : " " + maze[i][j];
            }
            result += "\n";
        }
        return result;
    }
}