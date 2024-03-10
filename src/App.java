/*Hacer un programa que dada una matriz de enteros ordenada
creciente por filas de tamaño 4*5 que se encuentra precargada,
solicite al usuario un número entero y una fila, y elimine la primera
ocurrencia de número en la fila indicada (un número igual) si
existe.*/ 
public class App {
    public static final int MAXF = 4;
    public static final int MAXC = 5;
  
    public static final int Num = 3;
  	public static final int Fila = 2;
  	
    
    public static void main(String[] args) {
          
        int [][] matrix = {
                            { 1,2,3,4,5},
                            { 1,2,3,4,5},
                            { 1,2,3,4,5},
                            { 1,2,3,4,5}
                            };
        
          
       imprimirMatriz(matrix);
      
       eliminarNumero(matrix[Fila], Num);
       
      imprimirMatriz(matrix);
    
  }
  
  
   public static void eliminarNumero(int [] fila, int num){

      for(int i = 0; i<MAXC; i++){
        if(num == fila[i]){
            fila[i] = fila [i+1];
        }
      }

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
