/*Un dispositivo que lleva un animal bovino en su cuello recolecta datos de un acelerómetro en tres ejes: X Y Z.
Cada toma de datos se representa como una secuencia de valores enteros entre 0 y 1023 para cada eje, las
secuencias están separadas por -1 (valor no válido para esta lógica). El productor quiere conocer cómo se ha
comportado su animal en el transcurso del día y para ello ingresa un patrón de aceleración X Y Z y una cantidad
N de repeticiones. Un patrón que se repite una cierta cantidad de veces consecutivas significa que el animal
puede estar pastoreando, caminando, rumiando, etc. Dado un valor N y el patrón X Y Z en un arreglo inicializado
con -1 (de tamaño igual al arreglo que tiene los datos), hacer un programa en JAVA que:
- Compruebe si el patrón se repitió N o más veces y si es así que elimine del arreglo las secuencias que se
siguen repitiendo consecutivamente luego de la cantidad N. */



public class repasoparcial2 {

    public static final int SEPARADOR = -1; 
    public static final int MAX = 21;
    public static final int N = 1;
    
    public static void main(String[] args) {
      
      int [] arregloPrincipal = {-1, 12,22,44,-1,23,34,55,-1,23,34,55,-1,23,34,55,-1,23,34,57,-1};
      int [] patron= {-1, -1,-1,-1,-1,-1,-1,-1,-1,23,34,55,-1,-1,-1,-1,-1,-1,-1,-1,-1};
      
        int ini =0,fin =-1, contadorSecuencias = 0, iniP = 0, finP = -1;
        iniP = buscarInicio(patron, finP+1);
        finP = buscarFin(patron, iniP);

        while(ini<MAX){
            ini=buscarInicio(arregloPrincipal, fin+1);
            if(ini<MAX){
                fin=buscarFin(arregloPrincipal, ini);
                /*Lógica... */
                if((finP-iniP+1)==(fin-ini+1) && sonIguales(arregloPrincipal, ini, fin, patron, iniP)){
                    contadorSecuencias++;
                    if(contadorSecuencias>N){
                        eliminarSecuencia(ini,fin,arregloPrincipal);
                        fin = ini; 
                        }                  
                } 
                else{
                    contadorSecuencias = 0;
                }

            }
        }

        imprimirArreglo(arregloPrincipal);

    }


    public static boolean sonIguales(int [] arregloPrincipal, int ini, int fin, int []patron, int iniP){
        while (ini <= fin && arregloPrincipal[ini] == patron[iniP]) {
            ini++;
            iniP++;
        }

      return ini > fin;
 
      }

    public static void eliminarSecuencia(int ini, int fin, int []arre){
        for(int i = ini; i<=fin; i++){
            correrIzquierda(ini, arre);
        }
    }

    public static void correrIzquierda(int pos, int []arre){
        for(int i = pos; i<MAX-1; i++){
            arre[i] = arre[i+1];
        }
    }

    public static int buscarInicio(int[]arr, int pos){
        while(pos<MAX && pos >= 0 && arr[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(int[]arr, int pos){
        while(pos<MAX&& pos >= 0 && arr[pos]!=SEPARADOR){
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
