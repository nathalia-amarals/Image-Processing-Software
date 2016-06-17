/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

/**
 *
 * @author Nathália
 */
public class IDFT {
    static int [] idftfunc(double real[][],double img[][],int w, int h){
        int [] idftvet = new int[w*h];
        double [][] idft = new double [w][h]; //MUDEI AQUI ************ PRA DOUBLE
        double soma,termo;
        
        for(int x=0;x<w;x++){
            for(int y=0;y<h;y++){
             soma=0;
                for(int u=0;u<w;u++){
                    for(int v=0; v<h; v++){
                        termo = (  ((2*Math.PI*u*x)/w )+((2*Math.PI*v*y)/h));
                        soma = (soma + ( (real[u][v] * Math.cos(termo))+ (img[u][v] *Math.sin(termo)) ) );
                        
                    }
                }
                idft[x][y] = soma;
            }
        }
        
        //DESCENTRALIZANDO
        for(int i=0;i<w;i++){
           for(int j=0;j<h;j++){
               idftvet[i*h+j]=(int)(idft[i][j] * (Math.pow(-1,i+j)));
           }
        }
        /*
        //COLOCANDO A MATRIZ NO VETOR
        for(int x=0;x<w;x++){
            for(int y=0;y<h;y++){
                idftvet[x*h+y] = (int) idft[x][y];
            }
        }*/
        
        //COLOCANDO OS CINZAS NOS LUGARES
        for(int i=0;i<idftvet.length;i++){
            idftvet[i] = ((255<< 24) & 0xFF000000) | ((idftvet[i] << 16) & 0x00FF0000) | ((idftvet[i] << 8) & 0x0000FF00) | (idftvet[i] & 0x000000FF);
        }
        
        return idftvet;
    }
}
