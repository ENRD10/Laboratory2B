package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ucr.lab.domain.Knapsack;
import ucr.lab.domain.RatInMaze;
import ucr.lab.domain.SudokuSolver;
import ucr.lab.utility.util;
import ucr.lab.utility.utilFx;

import static ucr.lab.utility.util.LlenarCombo;

public class RatInMazeController {

    public ComboBox cbMaze;
    public TableView tvInicial;
    public TableView tvSolution;
    private RatInMaze ratInMaze;
    private RatInMazeController rat;

    @javafx.fxml.FXML
    public void initialize() {
        this.ratInMaze = new RatInMaze();

        ObservableList<String> options = FXCollections.observableArrayList("Maze 1", "Maze 2", "Maze 3", "Maze 4", "Maze 5");
        options.addAll("Board 1", "Board 2", "Board 3", "Board 4", "Board 5");
        cbMaze.setItems(options);
        cbMaze.setValue(cbMaze.getItems().getFirst());
        utilFx.configureTableView(tvInicial, maze1);
        utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze1));
    }

    ObservableList<String> options = FXCollections.observableArrayList("Maze 1", "Maze 2", "Maze 3", "Maze 4", "Maze 5");

    public void listarMaze(Event event) {
        LlenarCombo(cbMaze, options);
    }

    public String printBoard(int[][] maze) {
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

    public void fillMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = (Math.random() < 0.7) ? 1 : 0; // 70% de pasillos
            }
        }
        maze[0][0] = 1; // Entrada
        maze[maze.length - 1][maze[0].length - 1] = 1; // Salida
    }

    int[][] maze1 = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
    };
    int[][] maze2 = {
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1, 1},
            {1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1}
    };

    int[][] maze3 = new int[10][10];

    int[][] maze4 = new int[12][12];

    int[][] maze5 = new int[16][16];

    public void showSolution(int[][] maze) {
        fillMaze(maze);
        printBoard(maze);
        int columns = maze[0].length;

        // Crear columnas
        for (int col = 0; col < columns; col++) {
            final int columnIndex = col;
            TableColumn<int[], Integer> column = new TableColumn<>("Col " + (col + 1));
            column.setCellValueFactory(cellData -> {
                int[] row = cellData.getValue();
                return new javafx.beans.property.SimpleIntegerProperty(row[columnIndex]).asObject();
            });
            tvInicial.getColumns().add(column);

            ratInMaze.printSolution(maze);
            // Crear columnas
            for (int colu = 0; colu < columns; colu++) {
                final int coluIndex = colu;
                TableColumn<int[], Integer> colum = new TableColumn<>("Col " + (colu + 1));
                column.setCellValueFactory(cellData -> {
                    int[] row = cellData.getValue();
                    return new javafx.beans.property.SimpleIntegerProperty(row[columnIndex]).asObject();
                });
                tvSolution.getColumns().add(colum);
            }
        }
    }//end showSolution
    @javafx.fxml.FXML
    public void resolver(ActionEvent actionEvent) {

        switch (cbMaze.getValue().toString()) {
            case "Maze 1":
                fillMaze(maze1);
                utilFx.configureTableView(tvInicial, maze1);
                utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze1));
                break;
            case "Maze 2":
                fillMaze(maze2);
                utilFx.configureTableView(tvInicial, maze2);
                utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze2));
                break;
            case "Maze 3":
                fillMaze(maze3);
                utilFx.configureTableView(tvInicial, maze3);
                utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze3));
                break;
            case "Maze 4":
                fillMaze(maze4);
                utilFx.configureTableView(tvInicial, maze4);
                utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze4));
                break;
            case "Maze 5":
                fillMaze(maze5);
                utilFx.configureTableView(tvInicial, maze5);
                utilFx.configureTableView(tvSolution, ratInMaze.printSolutionMatriz(maze5));
                break;

            default:
                tvInicial.getColumns().clear();
                tvSolution.getColumns().clear();
        }
    }
}









