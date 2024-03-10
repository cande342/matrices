public class ejercicioArraysProg1 {
    public static final int MAX= 23;
    public static final int SEPARADOR = -1;
    public static void main(String[] args) {

        int[] biblioteca = {-1, -1, 3, 1, 4, 2, 3, -1, -1, -1, 2, 12, 5, 3, 0, -1, -1, 1, 2, 3, 1, 6, -1};

    int cantidadLibros = procesarArreglo(biblioteca);

    System.out.println("El total de libros es: " + cantidadLibros);
 }


 public static int procesarArreglo(int[] arre){
    int ini = 0, fin = -1, cantidadFinal = 0, total = 0;
    while(ini < MAX){
        ini= buscarInicio(arre, fin+1);
        if(ini < MAX){
            fin = buscarFin(arre, ini);
            /* Acá va la lógica */
            total =  totalLibros(ini, fin, arre);
            if(total >0){
                cantidadFinal+=total;
            }
        }
    }

    return cantidadFinal;
 }

 public static int totalLibros(int ini, int fin, int [] arre){
    int total = 0;
    for(int i = ini+1; i<=fin; i++){
        total+=arre[i];
    }

    return total;
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
