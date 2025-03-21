package ucr.lab.domain;

import org.junit.jupiter.api.Test;

public class NQueenTest {

    // Atributos de NQueen
    NQueen Test4x4;
    NQueen Test8x8;


    public NQueenTest() {
        // Inicializamos con diferentes tamaños de tablero
        this.Test4x4 = new NQueen(4);
        this.Test8x8 = new NQueen(8);

    }

    @Test
    public void test4x4() {
        System.out.println("Test para tablero 4x4:");
        // Verificamos si hay una solución para 4 reinas en un tablero 4x4
        if (Test4x4.puntoInicial()) {
            Test4x4.imprimirSoluciones();
        } else {
            System.out.println("No hay solución para este tablero.");
        }
        System.out.println();
    }

    @Test
    public void test8x8() {
        System.out.println("Test para tablero 8x8:");
        // Verificamos si hay una solución para 8 reinas en un tablero 8x8
        if (Test8x8.puntoInicial()) {
            Test8x8.imprimirSoluciones();
        } else {
            System.out.println("No hay solución para este tablero.");
        }
        System.out.println();
    }

}

