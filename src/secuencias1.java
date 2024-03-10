/*Hacer un programa que dada la matriz de secuencias de
enteros definida y precargada, permita obtener a través de
métodos la posición de inicio y la posición de fin de la secuencia
ubicada a partir de una posición entera y una fila, ambas
ingresadas por el usuario. Finalmente, si existen imprima por
pantalla ambas posiciones obtenidas. */

public class secuencias1 {
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final int SEPARADOR = 0;

    public static final int num = 9;
    public static final int fila = 3;
    
    public static void main(String[] args) {
          
        int [][] matrizInt = {
                            { 0,0,3,4,5,6,0,8,9,0,2,6,0,7,9,8,3,0,6,8},
                            { 0,4,3,4,0,6,7,8,9,0,2,6,0,7,9,0,3,0,6,8},
                            { 0,0,0,4,5,6,0,8,9,0,2,6,8,7,0,8,3,8,6,8},
                            { 0,2,3,4,0,6,0,8,9,0,2,6,8,7,9,0,3,0,6,8}                   
                            };
        
        /* char [][] matrizAlp = {
                            { ' ',' ','a','z','x','t',' ','g','h','g','f','t',' ','u','o','m','c',' ','y','s'},
                            { ' ','y','a',' ','x','t',' ','p','h','g',' ','t',' ','u','o','m','c','y','y','s'},
                            { ' ',' ',' ','z','x','t','y','g',' ','g','f','t',' ','u',' ','m','c',' ','y','s'},
                            { ' ',' ','a','z',' ','t','m','g','h','g','f','t',' ','u','o',' ','c','h','y','s'}                 
                            };*/
          
       imprimirMatriz(matrizInt);
      
       
       buscarSecuencia(matrizInt[fila], num);
    
  }

  public static void buscarSecuencia(int [] fila, int num){
       int  inicio = buscarInicio(fila, num);
       int  fin = buscarFin(fila, inicio);

       System.out.println("La secuencia comienza en la poisicion " + inicio + " y acaba en la posicion " + fin);

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
