package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ucr.lab.domain.NQueenProblem;

import static ucr.lab.utility.util.LlenarCombo;

public class NQueenController {

    public ComboBox cbBoard;
    public TableView tbBoard;
    public Button btShow;

    ObservableList<String> options = FXCollections.observableArrayList("8 x 8","4 x 4");

    public void listarBoards(Event event) {
        LlenarCombo(cbBoard,options);
    }

    public void showSolution(Event event) {
        NQueenProblem queen = new NQueenProblem();
        if (cbBoard.getValue() == "4 x 4"){

            int[][] board = {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}
            };
            queen.printSolution(board);
            int columns = board[0].length;

            // Crear columnas
            for (int col = 0; col < columns; col++) {
                final int columnIndex = col;
                TableColumn<int[], Integer> column = new TableColumn<>("Col " + (col + 1));
                column.setCellValueFactory(cellData -> {
                    int[] row = cellData.getValue();
                    return new javafx.beans.property.SimpleIntegerProperty(row[columnIndex]).asObject();
                });
                tbBoard.getColumns().add(column);
            }

            // Convertir matriz en ObservableList
            ObservableList<int[]> data = FXCollections.observableArrayList(board);
            tbBoard.setItems(data);

        }else{
            int[][] board1= {
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0}
            };
            queen.printSolution(board1);
            int columns = board1[0].length;

            // Crear columnas
            for (int col = 0; col < columns; col++) {
                final int columnIndex = col;
                TableColumn<int[], Integer> column = new TableColumn<>("Col " + (col + 1));
                column.setCellValueFactory(cellData -> {
                    int[] row = cellData.getValue();
                    return new javafx.beans.property.SimpleIntegerProperty(row[columnIndex]).asObject();
                });
                tbBoard.getColumns().add(column);
            }

            // Convertir matriz en ObservableList
            ObservableList<int[]> data = FXCollections.observableArrayList(board1);
            tbBoard.setItems(data);

        }

    }

    public void cleanBoard(ActionEvent actionEvent) {
        if (!tbBoard.getColumns().isEmpty()) {
            tbBoard.getColumns().clear();
        }
    }
}

