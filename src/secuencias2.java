/*Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada permita encontrar por cada fila la
posición de inicio y fin de la secuencia cuya suma de valores sea
mayor. */


public class secuencias2 {
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final int SEPARADOR = 0;

    public static void main(String[] args) {

    int [][] matrizInt = {
        { 0,0,3,4,5,6,0,8,9,0,2,6,0,7,9,8,3,0,6,8},
        { 0,4,3,4,0,6,7,8,9,0,2,6,0,7,9,0,3,0,6,8},
        { 0,0,0,4,5,6,0,8,9,0,2,6,8,7,0,8,3,8,6,8},
        { 0,2,3,4,0,6,0,8,9,0,2,6,8,7,9,0,3,0,6,8}                   
        };

    for(int i = 0; i <MAXF; i++){
        int suma = buscarSecuenciaMayor(matrizInt[i]);
        System.out.println("en la fila " + i + " la secuencia mayor suma " + suma);
    }

    }
    public static int buscarSecuenciaMayor(int[] fila) {
        int inicio = 0, fin = -1, comparador = 0;
    
        while (inicio < MAXC) {
            inicio = buscarInicio(fila, fin+1);
            if (inicio < MAXC) {
                fin = buscarFin(fila, inicio);
                /* Ahora hacemos la lógica para resolver la consigna */
                int total = sumarSec(fila, inicio, fin);
                if (total > comparador) {
                    comparador = total;
                }
            }
        }
        return comparador;
    }
    

    public static int sumarSec(int[] fila, int ini, int fin) {
        int suma = 0;
        for (int i = ini; i <= fin; i++) {
            suma += fila[i];
        }
        return suma;
    }

    public static int buscarInicio(int [] fila, int pos){
    
        while ( pos < MAXC && fila[pos] == SEPARADOR)
        pos++;
        return pos; 
      }

    public static int buscarFin(int [] fila, int pos){
        while (pos < MAXC && fila[pos] != SEPARADOR)
        pos++;
        return pos -1;
    }
}
