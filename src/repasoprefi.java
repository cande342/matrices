/*//Dado una matriz de NxM, donde N es la cantidad de lecturas realizadas y M la cantidad de
//canales analizados más 2 (cada fila comienza y termina con un espacio), se pide:
//determinar la cantidad de señales de posible origen extraterrestre en la matriz. Una señal es
//de posible origen extraterrestre si en P lecturas consecutivas (filas) existen al menos K
//intensidades(columnas) superiores a un determinado valor alfanumérico L en una de sus secuencias
//(canales de rastreo con lecturas consecutivas distintas de 0).
//Para el siguiente ejemplo donde N=5 y M=20 (18 canales), K=2, L=’F’ y P=2 existe UNA
//señal de posible origen extraterrestre en las lecturas 0 y 1 

Eso es así, porque, en la fila 0, la secuencia 12GH y la secuencia 3RBJ poseen al menos
dos intensidades superiores a ‘F’, además, de forma consecutiva, en la fila 1, la secuencia
RP y la secuencia 7MNW también lo cumplen. Nótese que la fila 4 cumple el criterio de que
al menos posee una secuencia con más de dos intensidades superiores a ‘F’ pero no la fila
que sigue (fila 5).
*/

/*Decir la cantidad de veces que existen DOS(P) filas consecutivas en donde al menos 
DOS(K) elementos dentro de las secuencias de cada fila superen el valor L */


public class repasoprefi {
    public static final int MAXF = 5; 
    public static final int MAXC = 20;
    public static final int K = 2;
    public static final char L = 'F';
    public static final int P = 2;
    public static final char SEPARADOR = ' ';
    
    
    public static void main(String[] args) {
      
      
      char [][] mat = {
        {' ','1','2','G','H',' ','2','A','3',' ','3','R','B','J',' ','6','5','K',' ',' '},
        {' ',' ','2','1','4','5',' ','R','P',' ','D','3',' ','7','M','N','W',' ',' ',' '},
        {' ','4','G','8',' ','3','5','7','1',' ',' ','2','X',' ','D','4','1',' ',' ',' '},
        {' ',' ',' ','5','T','T','M',' ','A','P','1','1',' ','2','1','3',' ','1','3',' '},
        {' ','6','6','4',' ','5','4',' ',' ','A','2','1','2',' ','G','4','2','1','8',' '}
      };

    int cantidadDeVeces = procesarMatriz(mat);
    System.out.println("La consigna se cumple "+ cantidadDeVeces + "vez/veces");
    }

    

    public static int procesarMatriz(char[][] mat){
        int cantidad = 0, cantidadFinal = 0;
        
        for(int i = 0; i<MAXF;i++){
            if(cumpleIntensidad(mat[i])){
                cantidad++;
            } else{
                cantidad = 0;
            }
           
            if (cantidad == P){
                cantidadFinal++;
                cantidad=0;
            }
    }
        return cantidadFinal;
    }

    public static boolean cumpleIntensidad(char [] fila){
        int ini = 0, fin = -1;
        boolean cumple = false;
        while(ini<MAXC && !cumple){
            ini = buscarInicio(fila, fin+1);
            if(ini <MAXC){
                fin=buscarFin(fila, ini);
                /*Acá la logica*/
                int intencidades = buscarIntencidades(ini, fin, fila);
                if(intencidades>= K){
                    cumple = true; 
                }
            }

            
        }
        return cumple;
    }

    public static int buscarIntencidades(int ini, int fin, char[] fila){
        int cantidad = 0;
        while(ini<=fin){
            if(fila[ini]>L){
                cantidad++;
            }
            ini++;
        }
        return cantidad;
    }

    public static int buscarInicio(char[]fila, int pos){
        while(pos<MAXC && fila[pos]==SEPARADOR){
            pos++;
        }
        return pos;
    }

    public static int buscarFin(char[]fila, int pos){
        while(pos<MAXC && fila[pos]!=SEPARADOR){
            pos++;
        }
        return pos-1;
    }

}