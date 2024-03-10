/*
Se pide realizar un programa en JAVA que dada una matriz de NxM, un arreglo de tamaño N y un porcentaje P: 
El entrenamiento progresivo es que los elemenos de la secuencia deben ir en orden descendente, los dias
establecidos por el array, despues de saber eso debo...

(a) elimine del arreglo aquellos días en los cuales se cumplió con el entrenamiento establecido; 
(b) informe al entrenador si el atleta ha cumplido con el entrenamiento en al menos P 
por ciento de los días que se le asignó el entrenamiento progresivo.

Para este ejemplo, el atleta cumplió con el entrenamiento progresivo 2 de los 3 días (día 2 y 5), por lo que su
porcentaje de cumplimiento fue de 2/3=0.66 o 66% de lo requerido. En este caso, para un P=0.5 (50%) el atleta
cumplió con lo pedido por el entrenador.
 */
public class practica4 {
    public static final int MAXF = 7;
    public static final int MAXC = 20;
    public static final double P = 0.5;
    public static final int SEPARADOR = 0;

    
    public static void main(String [] args){

        int[] [] matrizEntrenamiento = {
            {0, 300, 298, 298, 297, 0, 240, 233, 245, 240, 0, 257, 254, 254, 0, 234, 230, 222, 0, 0},
            {0, 310, 302, 284, 271, 0, 280, 263, 263, 0, 0, 0, 264, 264, 0, 234, 230, 0, 0, 0,},
            {0, 310, 302, 294, 0, 0, 250, 243, 0, 245, 0, 257, 255, 253, 0, 234, 229, 0, 0, 0,},
            { 0, 315, 320, 395, 398, 0, 351, 333, 353, 0, 0, 0, 334, 354, 0, 454, 490, 499, 0, 0},
            {0, 0, 420, 430, 430, 450, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 410, 400, 397, 0, 0, 250, 243, 0, 0, 0, 257, 255, 253, 0, 234, 229, 220, 0, 0,},
            {0, 415, 425, 435, 420, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

            int[] arregloDias = {1, 2, 5, 0, 0, 0, 0};
            
           

        int i = 0, diasEntrenamiento = 0, diasCumplio= 0;

        
        while(i<MAXF && arregloDias[i] !=SEPARADOR){
            
            if (entrenamientoProgresivo(matrizEntrenamiento[arregloDias[i]-1])){
                diasCumplio++;
                eliminarDia(arregloDias, i);
            } else{
            diasEntrenamiento++;
            i++;
            }
        
        }

    
    System.out.println("dias de entrenamiento: "+ (diasEntrenamiento+diasCumplio) + " dias cumplio: " + diasCumplio);
  }   



  
  public static boolean entrenamientoProgresivo(int [] fila){
    int ini = 0, fin = -1;
    boolean cumple = false;

    while(ini<MAXC){
        ini =buscarInicio(fila, fin+1);
            if(ini<MAXC){
                fin=buscarFin(fila, ini);
                  /*Aca va la logik*/
                  if(esDescendente(ini,fin, fila)){
                    cumple=true;
                  }
            }
          
       }
    return cumple;

  }
  
  public static boolean esDescendente(int ini, int fin, int [] fila){
    boolean desciende = true;
    for(int i = ini;i<=fin;i++){
      if(fila[i]<fila[i+1]){
        desciende = false;
      }
    }
    return desciende;
  }
  
  public static void eliminarDia(int [] arre, int pos){
    for (int i = pos; i < MAXF - 1; i++)
        arre[i] = arre[i + 1];
  }
  
  public static int buscarInicio(int [] arre, int pos){
    while(pos<MAXC && arre[pos]==SEPARADOR){
      pos++;
    }
    return pos;
  }
  
  public static int buscarFin(int [] arre, int pos){
    while(pos<MAXC && arre[pos]!= SEPARADOR){
      pos++;
    }
    return pos -1;
  }

}


