/*Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada, y un número entero ingresado por
el usuario, elimine de cada fila las secuencias de tamaño igual al
número ingresado. */
public class secuencias4 {
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final int SEPARADOR = 0;

    public static final int num = 2;
    
    public static void main(String[] args) {
          
        int [][] matrizInt = {
                            { 0,0,3,4,5,6,0,8,9,0,2,6,0,7,9,8,3,0,6,8},
                            { 0,4,3,4,0,6,7,8,9,0,2,6,0,7,9,0,3,0,6,8},
                            { 0,0,0,4,5,6,0,8,9,0,2,6,8,7,0,8,3,8,6,8},
                            { 0,2,3,4,0,6,0,8,9,0,2,6,8,7,9,0,3,0,6,8}                   
                            };
      
       
       for(int i =0; i< MAXF ; i++){
        eliminarSecuencias(matrizInt[i]);
       }

       imprimirMatriz(matrizInt);
                           
  }

  public static void eliminarSecuencias(int [] fila){
        int ini = 0, fin = -1;

        while(ini <MAXC){
            ini = buscarInicio(fila, fin+1);
            if(ini < MAXC){
                fin = buscarFin(fila, ini);
                /*Acá va la lógica para resolver el ejercicio */
                if((fin - ini)+1 == num){
                    eliminarSec(fila, ini, fin);
                }
            }
        }
  }

  public static void eliminarSec(int[] fila, int pos, int posFin) {
        for(int i = pos; i<=posFin; i++){
            fila[i] = 0;
        }
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
