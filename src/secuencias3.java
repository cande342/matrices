/*Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada, permita encontrar por cada fila
la posición de inicio y fin de la anteúltima secuencia (considerar
comenzar a buscarla a partir de la última posición de la fila). */

public class secuencias3 {
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final char SEPARADOR = ' ';

    public static void main(String[] args) {
        char[][] matrizAlp = {
                {' ', ' ', 'a', 'z', 'x', 't', ' ', 'g', 'h', 'g', 'f', 't', ' ', 'u', 'o', 'm', 'c', ' ', 'y', 's','f'},
                {' ', 'y', 'a', ' ', 'x', 't', ' ', 'p', 'h', 'g', ' ', 't', ' ', 'u', 'o', 'm', 'c', 'y', 'y', 's','t'},
                {' ', ' ', ' ', 'z', 'x', 't', 'y', 'g', ' ', 'g', 'f', 't', ' ', 'u', ' ', 'm', 'c', ' ', 'y', 's','r'},
                {' ', ' ', 'a', 'z', ' ', 't', 'm', 'g', 'h', 'g', 'f', 't', ' ', 'u', 'o', ' ', 'c', 'h', 'y', 's', 'e'}
        };

        for (int i = 0; i < MAXF; i++) {
            buscarPosiciones(matrizAlp[i]);
        }
    }

    public static void buscarPosiciones(char[] fila) {
        int inicio = -1;
        int fin = -1;
        int contador = 0;
        int ultimaSecuencia = -1;
        int anteultimaSecuencia = -1;

        for (int i = 0; i < MAXC; i++) {
            if (fila[i] != ' ') {
                if (inicio == -1) {
                    inicio = i;
                }
                fin = i;
                contador++;
            } else {
                if (contador > 0) {
                    anteultimaSecuencia = ultimaSecuencia;
                    ultimaSecuencia = i - 1;
                    contador = 0;
                }
            }
        }

        if (anteultimaSecuencia != -1) {
            inicio = ultimaSecuencia;
            fin = anteultimaSecuencia +2;
            System.out.println("Anteúltima secuencia encontrada en la fila: [" + inicio + ", " + fin + "]");
        }
    }
}

