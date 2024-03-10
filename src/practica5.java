/*Se desea encriptar los nombres propios (comienzan con mayúscula) que aparezcan en el
documento. Realizar una simple inversión de los caracteres y la duplicación de las vocales minúsculas 
sólo de los nombres propios (secuencias) presentes en el documento. Se pide:
(a) implementar el mecanismo de encriptación antes descrito sobre una matriz de NxM e
(b) informar, al finalizar la ejecución del mismo, la cantidad de secuencias encriptadas. */

public class practica5 {
    public static final int MAXC = 15;
    public static final int MAXF = 4;
    public static final char SEPARADOR = ' ';

    

    public static void main (String [] args){

        char [][] matrizChar = {
            { ' ','e','l',' ','a','g','e','n','t','e',' ',' ',' ',' ',' '},
            { ' ','J','a','m','e','s',' ','B','o',' ','s','e',' ',' ',' '},
            { ' ','e','n','c','u','e','n','t','r','a',' ','e','n',' ',' '},
            { ' ','C','o','l','o','n','i','a',' ',' ',' ',' ',' ',' ',' '}                 
            };


            
            for(int i = 0; i<MAXF; i++){
                encriptarMatriz(matrizChar[i]);
            }

            imprimirMatriz(matrizChar);

    }

   

    
    public static void encriptarMatriz(char [] fila){

        int ini = 0, fin = -1, secuenciasEncriptadas = 0;


        
        while(ini < MAXC){
            ini=buscarInicio(fila, fin+1);       
                if(ini<MAXC){
                    fin=buscarFin(fila, ini);
                    /*Comienza la parte lógica */
                    if(esPropio(ini,fin,fila)){
                        int vocales = duplicarVocales(fila, ini, fin);
                        fin+= vocales;
                        invertirLetras(ini, fin, fila);
                        secuenciasEncriptadas++;
                    }

                }
                

        }
        System.out.println("Se encriptaron " + secuenciasEncriptadas + " secuencias en total");

    }

    public static boolean esPropio(int ini, int fin, char []fila){ 
        /*Devuelve verdadero si es mayor o igual que A, y si también es menor o igual que Z
         * A,B,C... etc, se los toma como si fueran números donde A es el numero menor y Z el mayor
         */
        return 'A' <= fila[ini] && fila[ini] <= 'Z';
    }

    
    public static int duplicarVocales(char[] arr, int ini, int fin) {
        int cont = 0;
            while (ini <= fin) {
                if (esVocal(arr[ini])) {
                    correrADerecha(arr, ini);
                    cont++;
                    ini++; // Mueve doble para no duplicar el duplicado
                    fin++;
                    }
              ini++;
            }
        return cont;
    }
    
    public static void correrADerecha(char[] arr, int ini) {
        for (int pos = MAXC - 1; pos > ini; pos--)
        arr[pos] = arr[pos - 1];
        }
       /*CORRER IZQUIERDA, DIFERENCIAS:
        public static void correrAIzquierda(char[] arr, int ini) {
        for (int i = ini; i < MAX_A - 1; i++){   
      	arr[i]  = arr[i + 1];
          
       */ 

    public static boolean esVocal(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
        }

    
    public static void invertirLetras(int ini, int fin, char[]fila){
        char aux;
        while (ini < fin) {
            aux = fila[ini];
            fila[ini] = fila[fin];
            fila[fin] = aux;
            ini++;
            fin--;
            }
        
    }      


    public static int buscarInicio(char[] arr, int pos) {
        while (pos < MAXC && arr[pos] == SEPARADOR) {
            pos++;
        }
        return pos;
    }

    
    public static int buscarFin(char [] fila, int pos){
        while(pos<MAXC&& fila[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
    } 

    public static void imprimirMatriz(char[][] matriz) {
        
        for (int i = 0; i < MAXF; i++) {
            for (int j = 0; j < MAXC; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
