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
    SudokuSolver sudoku1;
    SudokuSolver sudoku2; boolean solved2;
    SudokuSolver sudoku3; boolean solved3;
    SudokuSolver sudoku4; boolean solved4;
    SudokuSolver sudoku5; boolean solved5;

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("Board 1", "Board 2", "Board 3", "Board 4", "Board 5");
        sudoku1 = new SudokuSolver();
        comboBox.setItems(options);
        comboBox.setValue(comboBox.getItems().getFirst());
        utilFx.configureTableView(sudokuTable, sudoku1.getOriginalBoard());
        utilFx.configureTableView(solutionTable, sudoku1.getSolution());
    }

    @javafx.fxml.FXML
    public void comboBox(ActionEvent actionEvent) {
        switch (comboBox.getValue()) {
            case "Board 1":
                utilFx.configureTableView(sudokuTable, sudoku1.getOriginalBoard());
                utilFx.configureTableView(solutionTable, sudoku1.getSolution());
                break;
            case "Board 2":
                if (!solved2) sudoku2 = new SudokuSolver(); solved2 = true;
                utilFx.configureTableView(sudokuTable, sudoku2.getOriginalBoard());
                utilFx.configureTableView(solutionTable, sudoku2.getSolution());
                break;
            case "Board 3":
                if (!solved3) sudoku3 = new SudokuSolver(); solved3 = true;
                utilFx.configureTableView(sudokuTable, sudoku3.getOriginalBoard());
                utilFx.configureTableView(solutionTable, sudoku3.getSolution());
                break;
            case "Board 4":
                if (!solved4) sudoku4 = new SudokuSolver(); solved4 = true;
                utilFx.configureTableView(sudokuTable, sudoku4.getOriginalBoard());
                utilFx.configureTableView(solutionTable, sudoku4.getSolution());
                break;
            case "Board 5":
                if (!solved5) sudoku5 = new SudokuSolver(); solved5 = true;
                utilFx.configureTableView(sudokuTable, sudoku5.getOriginalBoard());
                utilFx.configureTableView(solutionTable, sudoku5.getSolution());
                break;
        }
    }
}
