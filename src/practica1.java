/*
 Se tiene un arreglo precargado de numeros enteros con secuencias de números separadas por ceros.
 Se pide eliminar las secuencias que cumplan con:
 -tienen igual cantidad de números pares e impares.
 - no poseen ningún multiplo de 5.
 */

public class practica1 {
    public static final int MAX = 16;
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {
        int[] arre = {0, 1, 2, 3, 2,0, 4, 5, 6, 0, 3, 7, 8, 0, 9, 10, 0};

        int ini = 0, fin = -1;

        while (ini < MAX) {
            ini = buscarInicio(arre, fin + 1);
            if (ini < MAX) {
                fin = buscarFin(arre, ini);
                /* A partir de acá va el razonamiento */
                if (paresImparesIgual(ini, fin, arre) && noMultiplosDeCinco(ini, fin, arre)) {
                    eliminarSec(ini, fin, arre);
                    fin = ini;
                }
            }
        }

        imprimirArreglo(arre);
    }

    public static boolean paresImparesIgual(int ini, int fin, int[] arre) {
        int contadorPares = 0;
        int contadorImpares = 0;

        for (int i = ini; i <= fin; i++) {
            if (arre[i] % 2 == 0) {
                contadorPares++;
            } else {
                contadorImpares++;
            }
        }
        return contadorPares == contadorImpares;
    }

    public static boolean noMultiplosDeCinco(int ini, int fin, int[] arre) {
        boolean cumple = true;

        for (int i = ini; i <= fin; i++) {
            if (arre[i] % 5 == 0) {
                cumple = false;
            }
        }

        return cumple;
    }

    public static void eliminarSec(int ini, int fin, int[] arre) {
        for (int i = ini; i <= fin; i++) {
            arre[i] = SEPARADOR; 
        }
    }

    public static void imprimirArreglo(int[] arre) {
        for (int i : arre) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int buscarInicio(int[] arre, int pos) {
        while (pos < MAX && arre[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[] arre, int pos) {
        while (pos < MAX && arre[pos] != SEPARADOR) {
            pos++;
        }
        return pos - 1;
    }
}

