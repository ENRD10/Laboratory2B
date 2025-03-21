package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import ucr.lab.domain.SudokuSolver;
import ucr.lab.utility.utilFx;

public class SudokuSolverController {
    @javafx.fxml.FXML
    private ComboBox<String> comboBox;
    @javafx.fxml.FXML
    private TableView<Integer[]> solutionTable;
    @javafx.fxml.FXML
    private TableView<Integer[]> sudokuTable;
    SudokuSolver sudokuSolver;
    int[][] board1;
    TableView<Integer[]> sudokuTable1;
    TableView<Integer[]> sudokuTable2;
    TableView<Integer[]> sudokuTable3;
    TableView<Integer[]> sudokuTable4;
    TableView<Integer[]> sudokuTable5;
    int[][] board2;
    int[][] board3;
    int[][] board4;
    int[][] board5;


    @javafx.fxml.FXML
    public void initialize() {
        sudokuSolver = new SudokuSolver();
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("Board 1", "Board 2", "Board 3", "Board 4", "Board 5");

        board1 = sudokuSolver.randomBoard();
        sudokuTable1 = new TableView<>();
        utilFx.configureTableView(sudokuTable1, board1);

        board2 = sudokuSolver.randomBoard();
        sudokuTable2 = new TableView<>();
        utilFx.configureTableView(sudokuTable2, board2);

        board3 = sudokuSolver.randomBoard();
        sudokuTable3 = new TableView<>();
        utilFx.configureTableView(sudokuTable3, board3);

        board4 = sudokuSolver.randomBoard();
        sudokuTable4 = new TableView<>();
        utilFx.configureTableView(sudokuTable4, board4);

        board5 = sudokuSolver.randomBoard();
        sudokuTable5 = new TableView<>();
        utilFx.configureTableView(sudokuTable5, board5);

        comboBox.setItems(options);
        comboBox.setValue(comboBox.getItems().getFirst());
        utilFx.configureTableView(sudokuTable, board1);
        utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board1));
    }

    @javafx.fxml.FXML
    public void comboBox(ActionEvent actionEvent) {
        switch (comboBox.getValue()) {
            case "Board 1":
                sudokuTable.setItems(sudokuTable1.getItems());
                utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board1));
                break;
            case "Board 2":
                sudokuTable.setItems(sudokuTable2.getItems());
                utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board2));
                break;
            case "Board 3":
                sudokuTable.setItems(sudokuTable3.getItems());
                utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board3));
                break;
            case "Board 4":
                sudokuTable.setItems(sudokuTable4.getItems());
                utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board4));
                break;
            case "Board 5":
                sudokuTable.setItems(sudokuTable5.getItems());
                utilFx.configureTableView(solutionTable, sudokuSolver.getSolution(board5));
                break;
        }
    }
}
