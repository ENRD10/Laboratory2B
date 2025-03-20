package ucr.lab.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import ucr.lab.domain.Item;
import ucr.lab.domain.Knapsack;
import ucr.lab.utility.util;

import java.util.ArrayList;

public class KnapsackController {
    @javafx.fxml.FXML
    private TableView<Item> listItems;
    @javafx.fxml.FXML
    private TableColumn<Item, String> nameColumn;
    @javafx.fxml.FXML
    private TableColumn<Item, Double> valueColumn;
    @javafx.fxml.FXML
    private TableColumn<Item, Double> weightColumn;
    @javafx.fxml.FXML
    private TableColumn<Item, Integer> stockColumn;
    @javafx.fxml.FXML
    private TableColumn<Item, Double> ratioColumn;
    @javafx.fxml.FXML
    private TableView<Item> kpItems;
    @javafx.fxml.FXML
    private TableColumn<Item, String> nameColumnKp;
    @javafx.fxml.FXML
    private TableColumn<Item, Double> valueColumnKp;
    @javafx.fxml.FXML
    private TableColumn<Item, Double> weightColumnKp;
    @javafx.fxml.FXML
    private TableColumn<Item, Integer> stockColumnKp;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField valueField;
    @javafx.fxml.FXML
    private TextField weightField;
    @javafx.fxml.FXML
    private TextField stockField;
    @javafx.fxml.FXML
    private ComboBox<Double> comboBox;
    @javafx.fxml.FXML
    private HBox hb;
    private Knapsack knapsack;
    private ObservableList<Item> observableItems;
    private ObservableList<Item> observableKpItems;

    @javafx.fxml.FXML
    public void initialize() {
        this.knapsack = new Knapsack(0);
        this.observableItems = FXCollections.observableArrayList();
        this.observableKpItems = FXCollections.observableArrayList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumnKp.setCellValueFactory(new PropertyValueFactory<>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        valueColumnKp.setCellValueFactory(new PropertyValueFactory<>("value"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        weightColumnKp.setCellValueFactory(new PropertyValueFactory<>("weight"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockColumnKp.setCellValueFactory(new PropertyValueFactory<>("stock"));
        ratioColumn.setCellValueFactory(new PropertyValueFactory<>("valueWeightRatio"));
        listItems.setItems(observableItems);
        kpItems.setItems(observableKpItems);
        comboBox.setItems(getOptions());
        stockField.setTextFormatter(getTextFormatterInteger());
        weightField.setTextFormatter(getTextFormatterDouble());
        valueField.setTextFormatter(getTextFormatterDouble());
        test();
    }

    private ObservableList<Double> getOptions (){
        ObservableList<Double> options = FXCollections.observableArrayList();
        options.add(util.randomDouble(10.0, 15.1));
        options.add(util.randomDouble(20.0, 25.1));
        options.add(util.randomDouble(30.0, 35.1));
        options.add(util.randomDouble(40.0, 45.1));
        options.add(util.randomDouble(50.0, 55.1));
        return options;
    }

    private void test (){
        observableItems.add(new Item("Smart TV 65 pulg 4k", 1000, 20, 1));
        observableItems.add(new Item("PS5", 600, 2, 1));
        observableItems.add(new Item("Libro Java", 20, 1, 1));
        observableItems.add(new Item("Samsung Galaxy", 700, 0.5, 1));
        observableItems.add(new Item("Huawei", 400, 0.5, 1));
        observableItems.add(new Item("Libro C++", 25, 0.5, 1));
        observableItems.add(new Item("Xbox One", 500, 2.2, 1));
        observableItems.add(new Item("Drone", 500, 3, 1));
        observableItems.add(new Item("Proyector", 200, 3, 1));
        observableItems.add(new Item("LapTop", 800, 3, 1));
        observableItems.add(new Item("Impresora 3D", 800, 4, 1));
    }

    @javafx.fxml.FXML
    public void comboBox(ActionEvent actionEvent) {
        knapsack.setKpItems(new ArrayList<Item>());
        knapsack.setActualWeight(0);
        observableKpItems.clear();
        knapsack.setMaxWeight(comboBox.getValue());
        observableKpItems.addAll(knapsack.fillBackpack(observableItems));
    }

    @javafx.fxml.FXML
    public void add(ActionEvent actionEvent) {
        if (nameField.getText().isBlank() || valueField.getText().isBlank() || weightField.getText().isBlank() || stockField.getText().isBlank()) {
            getAlertError("Rellene todos los campos.").show();
        }else {
            double weight = Double.parseDouble(weightField.getText());
            double value = Double.parseDouble(valueField.getText());
            int stock = Integer.parseInt(stockField.getText());
            if (weight <= 0 || value <= 0 || stock <= 0)
                getAlertError("El precio, el peso y el stock deben ser mayor que 0.").show();
            else {
                observableItems.add(new Item(nameField.getText(), value, weight, stock));
                nameField.clear(); valueField.clear(); weightField.clear(); stockField.clear();
            }
        }
    }

    @javafx.fxml.FXML
    public void example(ActionEvent actionEvent) {
        observableItems.clear();
        test();
    }

    @javafx.fxml.FXML
    public void remove(ActionEvent actionEvent) {
        observableItems.remove(listItems.getSelectionModel().getSelectedItem());
    }

    public Alert getAlertError (String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null); alert.setContentText(message);
        return alert;
    }

    public TextFormatter<Double> getTextFormatterDouble() {
        return new TextFormatter<>(new DoubleStringConverter(), 0.0,
                change -> (change.getControlNewText().matches("\\d*(\\.\\d*)?")) ? change : null);
    }

    public TextFormatter<Integer> getTextFormatterInteger() {
        return new TextFormatter<>(new IntegerStringConverter(), 0,
                change -> (change.getControlNewText().matches("\\d*")) ? change : null);
    }
}
