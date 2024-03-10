/*
 * 2- Un programa que diga el total de libros disponibles x acda archivo, si alguno no tiene libros disponibles para prestar 
 también debe decirlo.
 */
public class ejercicioArraysProg2 {
    public static final int MAX= 23;
    public static final int SEPARADOR = -1;
    public static void main(String[] args) {
        
        int[] biblioteca = {-1, -1, 3, 1, 4, 2, 3, -1, -1, -1, 2, 12, 5, 3, 0, -1, -1, 1, 2, 3, 1, 6, -1};

    librosDisponibles(biblioteca);


 }


 public static void librosDisponibles(int[] arre){
    int ini = 0, fin = -1, N = 0, libros = 0;
    while(ini < MAX){
        ini= buscarInicio(arre, fin+1);
        if(ini < MAX){
            fin = buscarFin(arre, ini);
            /* Acá va la lógica */
            N++;
            libros = librosD(ini, fin, arre);
            System.out.println("El archivo " + N + " Tiene " + libros+ " libros disponibles");
            if(!disponibles(fin, arre)){
                System.out.println("El archivo " + N + " no tiene libros disponibles para prestar");
            }           
           
        }
    }

 }
 public static int librosD(int ini, int fin, int [] arre){
    int libros = 0;
  for(int i = ini+1; i<=fin;i++){
    libros+=arre[i];
  }
  return libros;
 }

 public static boolean disponibles(int fin, int [] arre){
    return arre[fin] != 0;
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
