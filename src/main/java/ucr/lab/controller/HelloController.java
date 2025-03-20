package ucr.lab.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {

    @FXML
    private Text txtMessage;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;

    private void load (String form){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(form));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void Knapsack(ActionEvent actionEvent) {
        load("knapsack.fxml");
    }

    @FXML
    public void SudokuSolver(ActionEvent actionEvent) {
        load("sudokuSolver.fxml");
    }

    @FXML
    public void NQueen(ActionEvent actionEvent) {
        load("nQueen.fxml");
    }

    @FXML
    public void RatInMaze(ActionEvent actionEvent) {
        load("rat-in-maze.fxml");
    }

    @FXML
    public void Home(ActionEvent actionEvent) {
        this.txtMessage.setText("Laboratory No. 2");
        this.bp.setCenter(ap);
    }

    @FXML
    public void KnightTour(ActionEvent actionEvent) {
        load("knightTour.fxml");
    }

    @FXML
    public void Exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}