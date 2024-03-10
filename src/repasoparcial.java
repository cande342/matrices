/*NO CORRE PERO ESTÁ IGUAL A LA RESOLUCIÓN QUE SUBIERON DE LA CÁTEDRA
 Cuando se debe procesar texto expresado en lenguaje natural, una de las primeras tareas que se realiza es la
 de eliminación de stopwords. Las stopwords son palabras muy comunes en un determinado lenguaje, por
 ejemplo, artículos (el, la, las, los...), preposiciones (a, ante, con, por...), etc.
 Dado un texto almacenado en un arreglo de caracteres de tamaño MAX_A, donde cada palabra está delimitada
 por espacios, comas (,) o puntos (.) se pide eliminar todas las stopwords almacenadas en otro arreglo de
 caracteres de tamaño MAX_S que se encuentra delimitado por espacios.
 Por ejemplo, dado un texto almacenado en un arreglo A:
 */
public class repasoparcial {
  public static final int MAX_A = 42;
  public static final int MAX_S = 20;
  public static final char SEPARADOR1=' ';
  public static final char SEPARADOR2=',';
  public static final char SEPARADOR3='.';

  public static void main(String[] args) {
    
    char[] arrA = {' ','l','a',' ','c','a','s','a',' ','r','o','j','a',',',
    'a',' ','l','a',' ','v','u','e','l','t','a',' ','d','e',' ','l','a',' ','e','s','q','u','i','n','a','.', ' '};
      
    char[] arrS = {' ','a',' ','l','o',' ','l','o','s',' ','d','e',' ','l','a',' ','l','a','s',' '};



    int ini = 0, fin = -1;

    while(ini < MAX_A){
        ini =buscarInicio(arrA, fin+1, MAX_A);
        if(ini<MAX_A){
            fin=buscarFin(arrA, ini, MAX_A);
            /*Lógica... */
            if(esStopWord(ini,fin,arrA, arrS)){
                eliminarSecuencia(ini,fin,arrA);
                fin = buscarFin(arrA,ini, MAX_A);
            }
        }
    }

    imprimirArreglo(arrA);
  }

  public static boolean esStopWord(int ini, int fin, char [] arrA, char [] arrS){
    boolean cumple = false;
    int iniS = 0, finS=-1;
    while(ini<MAX_S){
        ini=buscarInicio(arrS, finS+1, MAX_S);
        if(ini<MAX_S){
            fin=buscarFin(arrS, iniS, MAX_S);
            /*logica */
            if((fin-ini+1)==(finS-iniS+1) && sonIguales(ini,fin,arrA,iniS,finS,arrS)){
                cumple = true;
            }
        }
    }


    return cumple;
  }

  public static boolean sonIguales(int ini, int fin, char[] arrA, int iniS, int finS, char []arrS){
    boolean sonIguales = true;
    for(int i = ini; i <= fin; i++){
        if(arrA[i] != arrS[iniS]){
            sonIguales = false;
        } else{
            iniS++;
        }
    }
    return sonIguales;
  }

  public static void eliminarSecuencia(int ini, int fin, char []arr){
    for(int i = ini; i <=fin ; i++){
        correrIzquierda(ini,arr);
    }
  }

  public static void correrIzquierda(int pos, char [] arr){
    for(int i = pos; i < MAX_A-1; i++){
        arr[i] = arr[i+1];
    }
  }

  public static int buscarInicio(char [] arr, int pos, int MAX){
    while(pos<MAX&& arr[pos]==SEPARADOR1 ||arr[pos]==SEPARADOR2 ||arr[pos]==SEPARADOR3){
        pos++;
    }
    return pos;
  }

  public static int buscarFin(char [] arr, int pos, int MAX){
    while(pos<MAX&& arr[pos]!=SEPARADOR1 && arr[pos]!=SEPARADOR2 && arr[pos]!=SEPARADOR3){
        pos++;
    }
    return pos-1;
  }

  public static void imprimirArreglo(char[] arre) {
    for (int i : arre) {
        System.out.print(i + " ");
    }
    System.out.println();
}
}
