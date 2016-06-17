/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;
import java.lang.Math;
import java.io.*;
/**
 *
 * @author Nathália
 */
public class Transforma {
        //------------------------------------------------------------
        public static int[] negativo(int image[]){
            int negativeimage[] = new int[image.length];
            
            for (int i = 0; i < image.length; i++){
                negativeimage[i] =((268435455)- image[i]); 
            }
            return negativeimage;
            
        }
       
        //------------------------------------------------------------
        public static int[] limiar(int image[],int valor){
            int limiarizada[]= new int [image.length];
             
              int valorreg= ((0<<24) | (valor<<16) | (valor<<8)| valor);   
            for(int i = 0; i < image.length; i++){              
               
                if(image[i] > valorreg){
                    //System.out.printf(" " + image[i]+"valor "+ valorreg);
                    limiarizada[i]=0xffffffff;
                    
                }
                else{
                    limiarizada[i]=0x00000000;
                    //System.out.println("Chegou aqui2");
                }
            }
            //função irá receber a imagem e o valor do limiar
            return limiarizada;
        }
        
        //------------------------------------------------------------
        public static int[] potencia(int image[], double gama)
        {   int normal;
            int imagepotencia[]= new int [image.length];
            double c = 2.0; //= 255/ (int) Math.pow(256, gama);//?? Qual o valor desse C??
            double s=0;
            double L = (c*(Math.pow(255,gama)));
                      
            for (int i = 0; i < image.length; i++){
                //Aplicando a formula s=cr^gama
                int red = (image[i] >> 16) & 0xff; 
                double elevado = Math.pow( red,gama);
                s = (c * elevado);
                normal =(int)(( s/L )*255);
                int gray = ((0 << 24) & 0xFF000000) | ((normal << 16) & 0x00FF0000) | ((normal << 8) & 0x0000FF00) | (normal & 0x000000FF);  

                imagepotencia[i] = gray;          
            }
            
            //fazendo a correção para a escala de cinza de 256 tons de cinza
            //imagepotencia = ConverteCinza.imageToGray(imagepotencia);
            return imagepotencia;
        }
        
        //------------------------------------------------------------
        public static int[] equalizacao(int image[]){
                int tam = image.length;
                int equal[]= new int[tam];
                int histog[] = Histograma.histogramafunc(image);//para gerar o histograma
                int fda[] = new int[histog.length];
                int x=0,y=1,aux=0;
                double aux1,aux2,aux3,aux4;
                
                //calculando fda para o histograma
                fda[0]=histog[0];
                //para pegar o primeiro diferente de zero
                if(fda[0]>0){
                    x=0;
                    y=0;
                }
                   
                for(int j=1;j<histog.length;j++){
                    fda[j]=histog[j]+fda[j-1];
                    //---para pegar o primeiro diferente de 0
                    //System.out.printf("\n histog %d %d - ",j, histog[j]);
                    System.out.printf(" fda %d", (fda[j]));
                    if(((fda[j])>0) &&(y==1)){
                        x=j;
                        y=0;
                        System.out.printf("---Entrou no IF");
                    }
                }
                //System.out.printf("\n Ultimo fda %d", fda[(histog.length)-1]);
                equal[0]=0;
                
                //System.out.printf("\n tam %d fda[x] %d x = %d",tam, fda[x],x);
                
                //calculando T(r)
                for(int j=1;j<tam;j++){                    
                    if(j<=x)
                        equal[j]=0;
                    else if((fda[j])==(fda[x])){
                        equal[j]=0;
                    }
                    else {
                        System.out.printf("\n ! fda[%d] %d - ",j, fda[j]);
                        aux4 =(fda[j] - fda[x]) ;
                        System.out.printf(" aux4 %f - ",aux4);
                        aux3 = (tam - fda[x]);
                        System.out.printf(" aux3 %f - ",aux3);
                        aux2 = ( aux4/aux3 );
                        System.out.printf("aux2 %f - ",aux2);
                        aux1 = (aux2* 255);
                        System.out.printf("aux1 %f - ",aux1);
                        aux = (int)aux1;
                        System.out.printf("\n aux %d",aux);
                        equal[j] = ((0 << 24) | (aux << 16) | (aux << 8)  | aux);  
                    }
                 }
                System.out.println("\n Chegou aqui!");
                return equal;
        }         
        //------------------------------------------------------------
        public static int[] adicao(int image1[],int image2[]){
            int tam, aux;
            //Eu determino qual imagem é a maior, pois a resultante será do tamanho da maior
            if((image1.length)> (image2.length)){
                 tam = (image1.length);
                 aux=0; //imagem 1 é maior que imagem 2
            }               
            else{
                tam = (image2.length);
                aux=1; //imagem 2 é maior que imagem 1
            }
            int imageadd[] = new int[tam];
            System.out.printf("Tam %d", tam);
            int j;
              
               for (j=0;j<tam;j++){
                 
                  if((aux==0)&&(j<=image2.length))
                        imageadd[j] = ((image1[j] + image2[j])/2);
                  else if ((aux==0)&&(j>image2.length))
                        imageadd[j] = image1[j];
                  else if ((aux==1) && (j<=image1.length))
                        imageadd[j] = ((image1[j] + image2[j])/2);     
                  else
                        imageadd[j]=image2[j];
              //System.out.printf("\n j %d",j);
              }
              System.out.printf("\n J %d",j);
            return imageadd;
        }
        
        //------------------------------------------------------------
        public static int[] subtracao(int image1[],int image2[]){
            int imagesub[] = new int[image1.length];
            
              for (int i = 0; i < image1.length; i++){
                  if(i<image2.length)
                    imagesub[i] = image1[i] - image2[i];
                  else
                      imagesub[i] = image1[i];
                  
                  if(imagesub[i]<0)
                      imagesub[i]=(imagesub[i]+255)/2;
              }
            return imagesub;
        }
        //Aqui começa a sessão de filtros
        //------------------------------------------------
        public static int[] suavizacao(int image[], int masc[]){
            int suavizado[] = new int [image.length];
            
            return suavizado;
        }
        //------------------------------------------------
        public static int[] laplaciano(int image[]){
            int laplace[] = new int [image.length];
            
            return laplace;
        }
        //------------------------------------------------
        public static int[] mediana(int image[], int masc[]){
            int media[] = new int [image.length];
            
            return media;
        }
        //------------------------------------------------
        public static int[] moda(int image[],int masc[]){
            int moda[] = new int [image.length];
            
            return moda;
        }
        //------------------------------------------------
        public static int[] minimo(int image[],int masc[]){
            int min[] = new int [image.length];
            
            return min;
        }
        //------------------------------------------------
        public static int[] maximo(int image[],int masc[]){
            int max[] = new int [image.length];
            
            return max;
        }
        
}
