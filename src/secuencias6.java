/*Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada elimine todas las secuencias que
tienen orden descendente entre sus elementos. */

public class secuencias6 {
    
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final char SEPARADOR = ' ';
    
    public static void main(String[] args) {
          
        char[][] matrizChar = {
            {' ', ' ', 'a', 'z', 'x', 't', ' ', 'e', 'd', 'c', 'b', 'a', ' ', 'u', 'o', 'm', 'c', ' ', 'y', 's','f'},
            {' ', 't', 's', 'r', 'q', 'p', ' ', 'p', 'h', 'g', ' ', 't', ' ', 'u', 'o', 'm', 'c', 'y', 'y', 's','t'},
            {' ', ' ', ' ', 'z', 'x', 't', 'y', 'g', ' ', 'g', 'f', 't', ' ', 'u', ' ', 'm', 'c', ' ', 'y', 's','r'},
            {' ', ' ','z', 'y', 'x', 'w', 'v', ' ', 'h', 'g', 'f', 't', ' ', 'u', 'o', ' ', 'c', 'h', 'y', 's', 'e'}
    };

    for(int i =0; i<MAXF; i++){
        procesarMatriz(matrizChar[i]);
    }

    imprimirMatriz(matrizChar);
  }

  public static void procesarMatriz(char []fila){
    int ini = 0, fin = -1;
        while (ini < MAXC) {
            ini = buscarInicio(fila, fin+1);
            if(ini <MAXC){
                fin = buscarFin(fila, ini);
                    /*Acá va la lógica */
                if(esDescendente(fila, ini, fin)){
                    eliminarSec(ini, fin, fila);
                    fin = ini;
                }

            }
         }
    }

  public static boolean esDescendente(char [] fila, int ini, int fin){
    boolean desciende = true;
    for(int i = ini; i < fin; i++ ){
        if(fila[i] < fila[i + 1]){
            desciende = false; // Si encuentra un elemento mayor al siguiente, no es descendente
        }
    }
    return desciende; // Si no encuentra ningún elemento mayor, es descendente
}

  public static void eliminarSec(int ini, int fin, char [] fila){

    for(int i = ini; i <= fin; i++){
        fila[i]= SEPARADOR; 
    }

  }

  public static int buscarInicio(char [] fila, int pos){
    
    while ( pos < MAXC && fila[pos] == SEPARADOR)
    pos++;
    return pos; 
  }

  public static int buscarFin(char [] fila, int pos){
    while (pos < MAXC && fila[pos] != SEPARADOR)
    pos++;
    return pos -1;
  }

  public static void imprimirMatriz(char[][] matriz) {
    
    for (int i = 0; i < MAXF; i++) {
        for (int j = 0; j < MAXC; j++) {
            System.out.print(matriz[i][j] + "\t");
        }
        System.out.println();
    }
    System.out.println();
}

}
