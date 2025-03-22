package ucr.lab.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import ucr.lab.domain.NQueen;
import ucr.lab.utility.utilFx;

public class NQueenController {

    // Atributos del controlador
    @FXML
    private ComboBox<String> comboBoxSize; // ComboBox para seleccionar el tamaño del tablero (4x4 o 8x8)

    @FXML
    private TableView<Integer []> tableroVista; // TableView donde se muestra la solución del problema de las N-Reinas

    public void initialize() {
        // Configura el ComboBox con las opciones de tamaño de tablero
        comboBoxSize.getItems().clear();
        comboBoxSize.getItems().addAll("4x4", "8x8"); // Opciones para elegir tamaño de tablero
        comboBoxSize.setValue("Presione la flecha"); // Mensaje por defecto en el ComboBox

        // Listener para detectar cuando se selecciona un nuevo tamaño y actualizar la solución
        comboBoxSize.valueProperty().addListener((observable, oldValue, newValue) -> resolverNQueensProblem());
    }

    @FXML
    private void resolverNQueensProblem() {
        // Obtener el valor del ComboBox ya elegido
        String tableroSize = comboBoxSize.getValue();


        int size = 4; // creamos los valores empezamos por 4
        if (tableroSize.equals("8x8")) {
            size = 8; // sino trae tablero size 8
        }

        // Crear el objeto NQueen con el tamaño
        NQueen Queen = new NQueen(size);

        // Si se encuentra solución, mostrarla(TIENE QUE MOSTRARLA)
        if (Queen.puntoInicial()) {
            utilFx.configureTableView(tableroVista, Queen.getTablero());
        }
    }
}