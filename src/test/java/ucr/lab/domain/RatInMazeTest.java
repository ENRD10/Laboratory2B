package ucr.lab.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatInMazeTest {

    @Test
    void testMaze1() {
        RatInMaze rat  = new RatInMaze();
        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        System.out.println("Rat in maze for a 4x4 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }
    @Test
    void testMaze2() {
        RatInMaze rat  = new RatInMaze();
        int[][] maze = {
                {1,0,0,1,0,0,1,0},
                {0,1,0,1,0,1,0,0},
                {0,1,1,0,0,1,0,0},
                {0,0,1,1,0,1,0,0},
                {0,1,0,1,1,0,0,0},
                {0,0,0,0,1,1,0,0},
                {0,1,1,1,1,1,0,0},
                {0,0,0,1,0,1,1,1}
        };
        System.out.println("Rat in maze for a 8x8 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }
    @Test
    void testMaze3() {
        RatInMaze rat  = new RatInMaze();
        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        System.out.println("Rat in maze for a 10x10 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }
    @Test
    void testMaze4() {
        RatInMaze rat  = new RatInMaze();
        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        System.out.println("Rat in maze for a 12x12 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
    }
    @Test
    void testMaze5() {
        RatInMaze rat  = new RatInMaze();
        int[][] maze = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        System.out.println("Rat in maze for a 15x15 board\n");
        System.out.println(printBoard(maze));
        System.out.println("\nSolution");
        System.out.println(rat.printSolution(maze));
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