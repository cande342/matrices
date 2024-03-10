/*
 * - Dado un número de archivo, eliminarlo. 
 */
public class ejercicioArraysProg5 {
    public static final int MAX= 23;
    public static final int SEPARADOR = -1;
    public static final int N = 2;
    public static void main(String[] args) {
        
    int[] biblioteca = {-1, -1, 3, 1, 4, 2, 3, -1, -1, -1, 2, 12, 5, 3, 0, -1, -1, 1, 2, 3, 1, 6, -1};

     librosDisponibles(biblioteca);

     imprimirArreglo(biblioteca);

    

 }


    public static void librosDisponibles(int[] arre){
        int ini = 0, fin = -1, archivo = 0;
        while(ini < MAX){
            ini= buscarInicio(arre, fin+1);
            if(ini < MAX){
                fin = buscarFin(arre, ini);
                /* Acá va la lógica */
                archivo++;
                if(archivo==N){
                    eliminarArchivo(ini, fin, arre);
                }
            }
        }
      
    }

    public static void eliminarArchivo(int ini, int fin, int []arre){
        for(int i = 0; i <=fin -ini ;i++){
            correrIzq( ini, arre);
        }
    }

    public static void correrIzq(int ini, int [] arre){
        for(int i = ini; i<MAX-1;i++){
            arre[i] = arre[i+1];
        }
    }

    public static int buscarInicio(int [] arre, int pos){
        while(pos<MAX && arre[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int [] arre, int pos){
        while(pos<MAX&&arre[pos]!=SEPARADOR){
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
