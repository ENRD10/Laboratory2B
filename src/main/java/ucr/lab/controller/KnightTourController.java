package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import ucr.lab.domain.KnightTour;
import ucr.lab.utility.utilFx;

public class KnightTourController {
    @javafx.fxml.FXML
    private TableView<Integer[]> solutionTable;
    @javafx.fxml.FXML
    private ComboBox<String> comboBox;
    @javafx.fxml.FXML
    private TextArea textArea;
    int[][] solution;
    KnightTour knightTour;

    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<String> options = FXCollections.observableArrayList();
        options.addAll("8x8", "4x4");
        comboBox.setItems(options);
        comboBox.setValue(comboBox.getItems().getFirst());
        action(8);
    }

    @javafx.fxml.FXML
    public void comboBox(ActionEvent actionEvent) {
        switch (comboBox.getValue()) {
            case "8x8":
                action(8);
                break;
            case "4x4":
                action(4);
                break;
        }
    }

    public void action(int size) {
        knightTour = new KnightTour(size);
        if (knightTour.solveKnightTour()) {
            solution = knightTour.getBoard();
            utilFx.configureTableView(solutionTable, solution);
            textArea.setText(printBoard(solution));
        }else{
            textArea.setText("No solution");
            solutionTable.setItems(null);
        }

    }

    private String printBoard(int[][] board) {
        String result = "\n";
        int n = board.length;
        for (int[] row : board) {
            for (int col : row)
                result += "\t" + String.format("%2d", col);
            result += "\n\n"; //Salto de linea a la siguiente fila
        }
        return result;
    }
}
