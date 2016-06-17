/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
/**
 *
 * @author Nathália
 */
public class DFT2 {
     static int [] dftespectro;    
     public int [] retornaespectro (){
         return dftespectro;
     }
     
     public static int[] DFTfunc(int [] imagem, int w, int h,int cod,int D0, int W, int n,int k1, int k2){
       
       int [] dft = new int [imagem.length];
       double [][] real = new double [w][h]; //parte real do numero
       double [][] img = new double [w][h];  //parte imaginaria do numero
       double [][] mataux= new double [w][h];
       double M=w;
       double N=h;
       JOptionPane.showMessageDialog(null, "Realizando a transformada, pressione OK e aguarde o próximo POP-UP");
        
    
       //transformar o vetor em matriz
       for(int i=0;i<w;i++){
           for(int j=0;j<h;j++){
               mataux[i][j]= imagem[j+(i*h)];
           }
       }
       
       //centralizando o ponto [0,0]
       for(int i=0;i<w;i++){
           for(int j=0;j<h;j++){
               mataux[i][j]=(int)(mataux[i][j] * (Math.pow(-1,i+j)));
           }
       }
       double termo;
       
       //Realizando a transformada
       for(int u=0; u<w; u++){
            for(int v=0;v<h;v++){
                for(int x=0; x<w;x++){
                    for(int y=0; y<h; y++){
              
                        termo = (-2.0*Math.PI*(((x*u)/N)+((y*v)/M)));                                    
                        img[u][v] = (int) ( img[u][v] + ( mataux[x][y]*  Math.cos(termo) + mataux[x][y] * (-1*Math.sin(termo)) )  ); 
                        real[u][v] = (int)(real[u][v] + ( mataux[x][y] * Math.cos(termo)+ mataux[x][y] * Math.sin(termo) ) );
                                      
               }
              } 
           real[u][v] = (real[u][v] / (M*N));
           img[u][v] = (img[u][v] / (M*N));
           }
       }
     
      
     //voltando tudo para o vetor
      for(int i=0;i<w;i++){
           for(int j=0;j<h;j++){
               termo = (Math.log(img[i][j]+real[i][j]+1));
               dft[j+(i*h)]= (int)termo;
               
           }
           
       } 
      int max=0;
      for(int i=0;i<dft.length;i++){
          if(dft[i]>max)
              max=dft[i];
      }
     for(int i=0;i<dft.length;i++){
         dft[i]=(dft[i]/max)*255;
         dft[i] = ((255<< 24) & 0xFF000000) | ((dft[i] << 16) & 0x00FF0000) | ((dft[i] << 8) & 0x0000FF00) | (dft[i] & 0x000000FF);  
     }
     
     //EspectroF.geraEspectroF(image, dft, w, h);
     
     switch(cod){
          case(0): real = Filtros.passabaixaideal(real, h, w, h);
                   img =  Filtros.passabaixaideal(img, h, w, h);
                   break;
          case(1): real = Filtros.passabaixabutterworth(real, D0, n, w, h);
                   img = Filtros.passabaixabutterworth(img, D0, n, w, h);
                   break;
          case(2):  real = Filtros.passabaixagaussiano(real, D0, w, h);
                    img = Filtros.passabaixagaussiano(img, D0, w, h);
                    break;
          case(3):  real = Filtros.passaaltaideal(real, D0, w, h);
                    img = Filtros.passaaltaideal(img, D0, w, h);
                    break;
          case(4): real = Filtros.passaaltabutterworth(real, D0, n, w, h);
                   img = Filtros.passaaltabutterworth(img, D0, n, w, h);
                   break;
          case(5): real = Filtros.passaaltagaussiano(real, D0, w, h);
                   img = Filtros.passaaltagaussiano(img, D0, w, h);
                   break;
          case(6): real = Filtros.laplacianofrequencia(real, w, h);
                   img = Filtros.laplacianofrequencia(img, w, h);
                   break;
          case(7): real = Filtros.unsharpenaltasfrequencias(real, k1, k2, w, h);
                   img = Filtros.unsharpenaltasfrequencias(img, k1, k2, w, h);
                   break;
          case(8): real = Filtros.bandrejectideal(real, D0, w, h, W);
                   img = Filtros.bandrejectideal(img, D0, w, h, W);
                   break;
          case(9): real = Filtros.bandrejectbutterworth(real, D0, w, h, W, n);
                   img = Filtros.bandrejectbutterworth(img, D0, w, h, W, n);
                   break;
          case(10): real = Filtros.bandrejectgaussiano(real, D0, w, h, W);
                    img = Filtros.bandrejectgaussiano(img, D0, w, h, W);
                    break;
          case(11): real = Filtros.bandpassideal(real, D0, w, h, W);
                    img = Filtros.bandpassideal(img, D0, w, h, W);
                    break;
          case(12): real = Filtros.bandpassbutterworth(real, D0, w, h, W, n);
                    img = Filtros.bandpassbutterworth(img, D0, w, h, W, n);
                    break;
          case(13): real = Filtros.bandpassgaussiano(real, D0, w, h, W);
                    img = Filtros.bandpassgaussiano(img, D0, w, h, W);
                    break;
     }
     dftespectro = dft;
     dft = IDFT.idftfunc(real,img, w, h);
     
     
     JOptionPane.showMessageDialog(null, "Acabou a transformada"); 
     return dft;
     }  
}      

