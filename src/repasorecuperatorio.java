/*Un dispositivo que toma imágenes de un fenómeno natural está corriendo sobre una
plataforma tecnológica con recursos limitados. Cada imagen (representada por una matriz
de NxM) está compuesta por píxeles con valores entre 0 y 255. Se tiene implementado un
algoritmo de compresión que comprime aquellas porciones de la imagen distintas del color
negro (0 en la escala de valores del pixel). Dicho algoritmo procede de la siguiente manera:
por cada una de las filas de la matriz, toma cada secuencia delimitada por uno o mas
pixeles de color negro (valor 0) con más de X repeticiones de un valor de píxel (para ser
comprimida todos los elementos de la secuencia deben ser iguales), comprime la secuencia
poniendo en la primera posición el valor negado de la cantidad de ocurrencias y a
continuación el valor del pixel que se repite. Cada fila de la matriz empieza y termina con
uno o más pixeles negros.
Se pide implementar el algoritmo de descompresión que restablezca la matriz
original. Asumir que cada fila posee suficientes lugares como para realizar la
descompresión.
Ejemplo de matriz comprimida con X = 3: */

public class repasorecuperatorio {
    public static final int MAXF = 3;  //Filas
    public static final int MAXC = 20; //Columnas
    public static final int SEPARADOR = 0;
   

    	public static void main(String[] args) {
		int[][] matriz = {
         { 0,-8,67,0, 14, 0, -4, 33, 0, 5, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         { 0, 0, 25, 25, 0, -5, 3, 0, 25, 44, 44, 0, -4, 1, 0, 0, 0, 0, 0, 0 },
         { 0, 44, 44, 44, 0, -7, 15, 0, -4, 9, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0 }
         };

         for(int i = 0; i<MAXF;i++){
            descomprimirFila(matriz[i]);
         }

         imprimirMatriz(matriz);
         

    }

    public static void descomprimirFila(int [] fila){
        int ini = 0, fin =-1;
        while(ini<MAXC){
            ini = buscarInicio(fila, fin+1);
            if(ini<MAXC){
                fin = buscarFin(fila, ini);
                /*Lógica... */
                if(fila[ini]<0){
                    int cantidad = -fila[ini];
                    descomprimirSecuencia(ini, fila, cantidad);
                    fin= buscarFin(fila, ini);
                }
            }
        }
    }

    public static void descomprimirSecuencia(int ini, int[]fila, int cantidad){
        fila[ini] = fila[ini+1];
        for(int i = 0; i <cantidad-2;i++){
            corrimientoDerecha(ini,fila);
        }
        
    }

    public static void corrimientoDerecha(int ini, int []fila){
        for(int i = MAXC-1; i>ini; i--){
            fila[i] = fila[i-1];
        }
    }

    /* public static void corrimientoIzquierda(int pos, int []fila){
        for(int i = pos; i<MAX-1;i++){
            fila[i] = fila[i+1];
        }

       public static void corrimientoDerecha(int pos, int [] fila){
        for(int i = MAX-1; i>pos; i--){
            fila[i] = fila[i-1];
        }
       } 
    } */

    public static int buscarInicio(int [] fila, int pos){
        while(pos<MAXC&&fila[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int [] fila, int pos){
        while(pos<MAXC&&fila[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
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
