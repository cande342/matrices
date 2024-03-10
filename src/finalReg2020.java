/*Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que 
extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
(quedando separadas por un 0).
Observaciones generales:
_ARR está cargado inicialmente y PAR está inicializado con ceros.
_No se pueden utilizar estructuras auxiliares.
_Puede haber uno o más ceros al principio y al final del arreglo.
_Realizar el programa completo bien modularizado. */

public class finalReg2020 {
    public static final int MAX= 17;
    public static final int SEPARADOR =0;

    
    public static void main (String [] args){
        int[] arre = {0, 4, 2, 2, 2, 0, 4, 5, 6, 0, 4, 6, 8, 0, 9, 10, 0};
        int[] par = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
        int ini = 0, fin = -1;

        while (ini<MAX) {
            ini = buscarInicio(arre, fin+1);
            if (ini<MAX) {
                fin= buscarFin(arre, ini);
                /*Aca resolvemos */
                if (contenidoPar(ini, fin)) {
                    copiarSec(ini, fin, arre, par);
                }
            }
        }
        imprimirArreglo(arre);
        imprimirArreglo(par);

    }

    
    public static boolean contenidoPar(int ini, int fin){
        
         return (fin-ini+1)%2==0;
        
    }
    
    
    public static void copiarSec(int ini, int fin, int [] arre, int [] par){

        for(int i = ini; i<=fin; i++){
            par[i] = arre[i];
        }

    }


    public static int buscarInicio(int [] arre, int pos) {
        while (pos<MAX && arre[pos]==SEPARADOR) {
            pos++;
        }
        return pos;
    }
    public static int buscarFin(int [] arre, int pos) {
        while (pos<MAX && arre[pos]!=SEPARADOR) {
            pos++;
        }
        return pos-1;
    }

    public static void imprimirArreglo(int[] arre) {
        for (int i : arre) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}






