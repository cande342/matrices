/*
 * Mencionar que archivo tiene la mayor cantidad de libros disponibles.
 */
public class ejercicioArraysProg4 {
    public static final int MAX= 23;
    public static final int SEPARADOR = -1;
    public static void main(String[] args) {
        
        int[] biblioteca = {-1, -1, 3, 1, 4, 2, 3, -1, -1, -1, 2, 12, 5, 3, 0, -1, -1, 1, 2, 3, 1, 6, -1};

    int archivo = librosDisponibles(biblioteca);

    System.out.println("el archivo " + archivo + "Es el que tiene mayor cantidad de libros disponibles");

 }


    public static int librosDisponibles(int[] arre){
        int ini = 0, fin = -1, cantidadMayor = 0, cantidad = 0, archivo = 1;
        while(ini < MAX){
            ini= buscarInicio(arre, fin+1);
            if(ini < MAX){
                fin = buscarFin(arre, ini);
                /* Acá va la lógica */
                cantidad = cantidadDisponibles(ini, fin, arre);
                if(cantidadMayor<cantidad){
                    cantidadMayor = cantidad;
                    archivo++; 
                }
            
            }
        }
        return archivo; 

    }

    public static int cantidadDisponibles(int ini, int fin, int [] arre){
        int totales= arre[fin];
        return totales;
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
}
