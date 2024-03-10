/*
 * Mencionar que que archivo tiene la menor cantidad de libros totales.
 */

public class ejercicioArraysProg3 {
    
    public static final int MAX= 23;
    public static final int SEPARADOR = -1;
    public static void main(String[] args) {
        
        int[] biblioteca = {-1, -1, 3, 1, 4, 2, 3, -1, -1, -1, 2, 12, 5, 3, 0, -1, -1, 1, 2, 3, 1, 6, -1};

    int archivo = librosTotales(biblioteca);

    System.out.println("el archivo " + archivo + "Es el que tiene menor cantidad");

 }


    public static int librosTotales(int[] arre){
        int ini = 0, fin = -1, cantMenor = 0, cantidad = 0, archivo = 1;
        while(ini < MAX){
            ini= buscarInicio(arre, fin+1);
            if(ini < MAX){
                fin = buscarFin(arre, ini);
                /* Acá va la lógica */
                cantidad = cantidadTotales(ini, fin, arre);
                cantMenor = cantidad;
                if(cantidad<cantMenor){
                    cantMenor = cantidad;
                    archivo++; 
                }
            
            }
        }
        return archivo; 

    }

    public static int cantidadTotales(int ini, int fin, int [] arre){
        int totales = 0;
        for(int i = ini+1; i <=fin;i++){
            totales+=arre[i];
        }
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

