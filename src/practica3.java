/* se pide realizar un programa en JAVA que, dado un arreglo de tamaño M, 
para cada secuencia delimitada por uno o mas 0, con más de X repeticiones de un valor
(todos los elementos de la secuencia deben ser iguales), 
comprima la secuencia poniendo en la primera posición el valor negado de la
cantidad de ocurrencias y a continuación el valor del pixel que se repite. */

public class practica3 {
    public static final int MAX= 20;
    public static final int SEPARADOR = 0;

    
    public static void main (String [] args){


        int[] arre = {0, 67, 67, 67, 67, 67, 67, 67, 67, 0, 14, 0, 33,33, 33, 33, 0, 5, 98, 0};
        procesarArreglo(arre);
        imprimirArreglo(arre);

    }

    
    public static void procesarArreglo(int [] arre){
        int ini = 0, fin = -1;

        while(ini < MAX){
            ini= buscarInicio(arre, fin+1);
            if(ini < MAX){
                fin = buscarFin(arre, ini);
                /*Acá va la lógica, lo que vamos a hacer x cada secuencia:
                 * 1. Verificar si todos los numeros son iguales
                 * 2. Si son iguales, saber su cantidad.
                 * 3. Comprimir la secuencia(corrimiento izquierda) y colocar el numero negado primero, y el valor despues.
                 */

                 if(fin -ini +1 > 3 && seRepite(arre, ini, fin)){
                    comprimirSecuencia(arre, ini, fin);
                    fin = ini+2;
                    
                 }
            }
        }
    }
    public static boolean seRepite(int [] arre, int ini, int fin){
        boolean repiten = true;
        for(int i = ini ; i<=fin; i++){
            if(arre[i]!=arre[i+1]){
                repiten=false;
            }
        }
        return repiten;
    }

    public static void comprimirSecuencia(int[] arre, int ini, int fin) {
       
        int cantidad = fin - ini + 1;
        while (ini<fin-1){
        corrimientoIzquierda(ini, arre);
         fin--;
            }
        arre[ini] = cantidad * -1;
    }
    

    public static void corrimientoIzquierda(int pos, int [] arre){
        for(int i = pos; i<MAX-1;i++){
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
