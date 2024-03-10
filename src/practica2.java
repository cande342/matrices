/*
 * Se tiene una matriz precargada con secuencias de enteros distintos de cero en sus filas. 
 * Además se tiene precargado un arreglo con algunos numeros de filas. 
 * Los numeros de fila no se repiten y están ubicados de forma consecutiva desde el principio del arreglo, 
 * luego se completa con -1. 
 * 
 * De dichas filas se pide eliminar la ultima secuencia que cumpla con la condición 
 * de tener sólo valores pares.

- El tamaño del arreglo es igual al de la matriz.
- las secuencias estan separadas y empiezan y terminan con uno o mas ceros.


 */
public class practica2 {
    public static final int MAXF= 4;
    public static final int MAXC= 10;
    public static final int SEPARADOR = 0;
    public static final int RELLENO = -1;

    public static void main(String [] args){

        int [][] matrizInt = {
            { 0, 2, 4, 6, 0, 8, 10, 12, 0, 0},
            { 0, 5, 7, 0, 9, 11, 13, 15, 17, 0},
            { 0, 4, 6, 8, 10, 0, 12, 14, 16, 0},
            { 0, 3, 0, 6, 0, 0, 11, 13, 15, 0}                   
            };

        int[] numerosFila = {1, 2, 3, -1, -1, -1, -1, -1, -1, -1};    
            
        int i = 0;

        while(i<MAXC && numerosFila[i]!= RELLENO){
            procesarMatriz(matrizInt[numerosFila[i]-1]);
            i++;
        }
        imprimirMatriz(matrizInt);
}

        public static void procesarMatriz(int [] fila){
            int ini = 0, fin = -1, contador =0, iniUl= 0, finUlt=0;

            while(ini <MAXC){
                ini = buscarInicio(fila, fin+1);
                if(ini<MAXC){
                    fin = buscarFin(fila, ini);
                    /* Arranca la lógica que resuelve el problema */
                    if(soloPares(ini, fin, fila)){
                        contador++;
                        iniUl = ini;
                        finUlt = fin;
                    }

                }
            }
            if (contador >= 1) {
                // puedo usar este codigo o un "eliminar sec"
                for (int i = iniUl; i <= finUlt; i++) {
                    fila[i] = SEPARADOR;
                }
            }    
               
        }


        public static boolean soloPares(int ini, int fin, int [] fila){
            boolean cumple = true;
            for(int i = ini; i <= fin; i++){
                if(fila[i]%2 !=0){
                    cumple = false; 
                }
            }
            return cumple;
        }

        public static void eliminarSec(int ini, int fin, int [] fila){
            for(int i=ini; i<=fin;i++){
                fila[i]=SEPARADOR;
            }
        }

        public static int buscarInicio(int[] arre, int pos) {
            while (pos < MAXC && arre[pos] == SEPARADOR) {
                pos++;
            }
            return pos;
        }
    
        public static int buscarFin(int[] arre, int pos) {
            while (pos < MAXC && arre[pos] != SEPARADOR) {
                pos++;
            }
            return pos - 1;
        }

        public static void imprimirMatriz(int[][] matriz) {
        
            for (int i = 0; i < MAXF; i++) {
                for (int j = 0; j < MAXC; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
}

