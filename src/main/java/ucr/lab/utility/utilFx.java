package ucr.lab.utility;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class utilFx {
    public static void configureTableView(TableView<Integer[]> tableView, int[][] data) {
        if (data == null || data.length == 0) {
            return; // No hay datos para mostrar
        }

        int n = data.length; // Se asume que es una matriz cuadrada (n x n)

        // Convertir int[][] a ObservableList<Integer[]>
        ObservableList<Integer[]> observableData = FXCollections.observableArrayList();
        for (int[] row : data) {
            Integer[] rowData = new Integer[n];
            for (int i = 0; i < n; i++) {
                rowData[i] = row[i];
            }
            observableData.add(rowData);
        }

        // Limpiar columnas previas
        tableView.getColumns().clear();

        // Crear columnas dinámicamente
        for (int col = 0; col < n; col++) {
            final int columnIndex = col;
            TableColumn<Integer[], String> column = new TableColumn<>("C" + (col + 1));

            // Ajustar el tamaño de las columnas equitativamente
            column.setPrefWidth(tableView.getPrefWidth() / n);

            // Definir cómo obtener los valores de la matriz
            column.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue()[columnIndex]).asObject().asString());
            tableView.getColumns().add(column);
        }

        // Asignar datos a la tabla
        tableView.setItems(observableData);
    }
}
