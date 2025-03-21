package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import ucr.lab.domain.Knapsack;
import ucr.lab.domain.RatInMaze;
import ucr.lab.utility.util;

import static ucr.lab.utility.util.LlenarCombo;

public class RatInMazeController {

    public TableView tvInicial;
    public TableView tvSolution;
    private RatInMaze ratInMaze;

    @javafx.fxml.FXML
    public void initialize() {
        this.ratInMaze = new RatInMaze();
    }

    public ComboBox cbMaze;

    ObservableList<String> options = FXCollections.observableArrayList("Maze 1","Maze 2","Maze 3","Maze 4","Maze 5");
    public void listarMaze(Event event) {
      LlenarCombo(cbMaze,options);
    }



}
