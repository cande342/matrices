/*Hacer un programa que dada la matriz de secuencias de
caracteres definida y precargada, elimine de cada fila todas las
ocurrencias de una secuencia patrón dada por un arreglo de
caracteres de tamaño igual al tamaño de columnas de la matriz
(sólo tiene esa secuencia con separadores al inicio y al final). Al
eliminar en cada fila se pierden los valores haciendo los
corrimientos. */

public class secuencias5 {
    
    public static final int MAXF = 4;
    public static final int MAXC = 20;
    public static final char SEPARADOR = ' ';
    
    public static void main(String[] args) {
          
        char[][] matrizChar = {
            {' ', ' ', 'a', 'z', 'x', 't', ' ', 'g', 'h', 'g', 'f', 't', ' ', 'u', 'o', 'm', 'c', ' ', 'y', 's','f'},
            {' ', 'y', 'a', ' ', 'x', 't', ' ', 'p', 'h', 'g', ' ', 't', ' ', 'u', 'o', 'm', 'c', 'y', 'y', 's','t'},
            {' ', ' ', ' ', 'z', 'x', 't', 'y', 'g', ' ', 'g', 'f', 't', ' ', 'u', ' ', 'm', 'c', ' ', 'y', 's','r'},
            {' ', ' ', 'a', 'z', ' ', 't', 'm', 'g', 'h', 'g', 'f', 't', ' ', 'u', 'o', ' ', 'c', 'h', 'y', 's', 'e'}
    };
        char [] arregloChar = {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'p', 'h', 'g', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',' '};
       


    for (int i = 0; i<MAXF; i++){
            procesarArreglo(matrizChar[i], arregloChar);
        }

    imprimirMatriz(matrizChar);

    }

    public static void procesarArreglo(char [] fila, char [] secuencia){
        int ini= 0, fin = -1;

        while(ini<MAXC){
            ini = buscarInicio(fila, fin+1);
            if( ini < MAXC){
                fin = buscarFin(fila, ini);
                /*ahora  va la lógica */
                 if(contieneSecuencia(ini,fin, secuencia, fila)){
                    eliminarSec(fila, ini, fin);
                 }
            fin = ini;     
            }
        }
        

    }

    public static boolean contieneSecuencia(int ini, int fin, char [] secu, char [] fila){

        int iniS = 0, finS=-1;
        boolean contiene = false;

        while (iniS<MAXC && contiene == false){
            iniS = buscarInicio(secu, finS+1);{
                if(iniS<MAXC){
                    finS = buscarFin(secu, iniS);
                /* comparamos longitud y contenido */
                    if ((fin-ini+1==finS-iniS+1) && sonIguales(fila, ini, fin, secu, iniS,finS)){
                        contiene = true;
                     }
                }
            }
        }
        return contiene;
    }

    public static boolean sonIguales(char [] fila, int ini, int fin, char[] secu, int iniS, int finS ){
        while (ini <= fin && fila[ini] == secu[iniS]) {
            ini++;
            iniS++;
            }     
          return ini > fin;
      
          }

    public static void eliminarSec(char[] arrA, int ini, int fin) {
     // La "eliminación" es en realidad correr los valores, un corrimiento:
            for (int i = ini; i <= fin; i++) {
                arrA[i] = SEPARADOR;
            }
     // Corrimiento a la izquierda. i + fin - ini: Es la posición del último elemento de la secuencia original 
     //antes de la eliminación.
            for (int i = ini; i + fin - ini + 1 < MAXC; i++) {
                arrA[i] = arrA[i + fin - ini + 1];
            }
    }
/* Lo hicieron en clase de esta manera, pero no me corre:

  	   public static void eliminarPalabra(char[] arrA, int ini, int fin) {
      
         //la "eliminación" es en realidad reemplazar los lugares ocupados por stopworlds.
         
        for (int i = ini ; i <= fin; i++){
          correrAIzquierda(arrA, i);
        }
      	
      }
  
        public static void correrAIzquierda(char[] arr, int ini) {
      	
        for (int i = ini; i < MAX_A - 1; i++){   
		//acá se está reemplazando el valor de la posición de la stopword por el siguiente lugar. 
      	arr[i]  = arr[i + 1];
          
        }

      }
 */
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
