package ucr.lab.utility;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class util {
    private static final Random random;

    //constructor estatico, inicializador estatico
    static {
        //semilla para el random
        long seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static int random (int min, int max){ //min y max incluyentes
        return min + random.nextInt((max - min) + 1);
    }

    public static int random (int bound){
        //return (int) Math.floor(Math.random()*bound); //forma 1
        return 1+random.nextInt(bound);
    }

    public static double randomDouble (double min, double max) { //min incluyente, max excluyente
        double value = min + (random.nextDouble() * (max - min));
        return Math.round(value * 100.0) / 100.0; // Limita a 2 decimales
    }

    public static void fill(int[] a) {
        for (int i = 0; i < a.length ; i++) {
            a[i] = random(99);
        }
    }

    public static <T> void bubbleSort(T[] array, Comparator<T> criterio) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (criterio.compare(array[j], array[j + 1]) < 0) { // Mayor a menor
                    // Intercambiar elementos
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) break;
        }
    }

    public static <T> void bubbleSort(List<T> list, Comparator<T> criterio) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (criterio.compare(list.get(j), list.get(j + 1)) < 0) { // Mayor a menor
                    // Intercambiar elementos
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) break;
        }
    }

    public static String format(double n) {
        return new DecimalFormat("#### ####.##").format(n);
    }

    public static void LlenarCombo(ComboBox<String>  llenarcombo, ObservableList<String> infocombo){
        llenarcombo.setItems(infocombo);
    }


}

