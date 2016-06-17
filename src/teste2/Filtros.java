/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

/**
 *
 * @author Nathália
 */
public class Filtros {
    //passa baixa ideal
    public static double [][] passabaixaideal (double F[][], int D0,int w, int h)
    {   
        double [][] D = new double [w][h];
        int [][] H = new int [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                    if(D[u][v]<=D0){
                        H[u][v] = 1;
                        
                    }
                    else{
                        H[u][v] = 0;
                    }
                    G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    
    //passa baixa buttherworth
    public static double [][] passabaixabutterworth (double F[][],int D0,int n,int w, int h)
    {   double [][] D = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v]=(1/(1+Math.pow((D[u][v]/D0),(2*n))));
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    //passa baixa gaussiano
    public static double [][] passabaixagaussiano (double F[][],int D0,int w, int h)
    {   double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v]= Math.exp(-1*D2[u][v]/Math.pow(2*D0, 2));
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    //passa alta ideal
    public static double [][] passaaltaideal (double F[][], int D0,int w, int h)
    {   double [][] D = new double [w][h];
        int [][] H = new int [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                    if(D[u][v]<=D0){
                        H[u][v] = 0;
                        
                    }
                    else{
                        H[u][v] = 1;
                    }
                    G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    //passa alta butterworth
    public static double [][] passaaltabutterworth (double F[][],int D0,int n,int w, int h)
    {   double [][] D = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v]=(1- (1/(1+Math.pow((D[u][v]/D0),(2*n)))) );
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    //passa alta gaussiano
    public static double [][] passaaltagaussiano (double F[][],int D0,int w, int h)
    {   double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v]= (1- Math.exp(-1*D2[u][v]/Math.pow(2*D0, 2)) );
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
        
    }
    //filtro laplaciano de frequencia
    public static double [][] laplacianofrequencia (double F[][],int w,int h)
    {   double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        //calculando D2
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v] = (-4 *(Math.PI * Math.PI) * Math.pow(D2[u][v],2)); 
            G[u][v] = H[u][v] * F[u][v];
            }
        }    
        return G;
    }
    //filtro unsharpen de enfâse de altas-frequências
    public static double [][] unsharpenaltasfrequencias (double F[][],int k1,int k2,int w,int h)
    {   
        double [][] Hhp = new double [w][h];
        double [][] G = new double[w][h];
        
        Hhp=Filtros.passaaltaideal(F,10,h,w);
        
       for(int u=0;u<w;u++){
            for(int v=0;v<h;v++){
                G[u][v] =(k1+k2*Hhp[u][v])*F[u][v];
            }
       }
                
        //g = IDFT.idftfunc(aux);
                         
        return G;
    }
    //filtro band-reject ideal
    public static double [][] bandrejectideal (double F[][],int D0, int w, int h,int W)
    {   double [][] D = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                if(D[u][v]>=D0-W/2 && D[u][v]<=D0+W/2){
                    H[u][v]=0;
                }
                else
                    H[u][v]=1;
                
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
    }
    //filtro band-reject butterworth
    public static double [][] bandrejectbutterworth (double F[][],int D0, int w, int h,int W,int n)
    {   double [][] D = new double [w][h];
        double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        //calculando D
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        //calculando D2
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v] = (1/Math.pow( (1+((D[u][v]*W)/(D2[u][v]-Math.pow(D0,2)))) ,2*n));
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        
        return G;
    }
    //filtro band-reject gaussiano
    public static double [][] bandrejectgaussiano (double F[][],int D0, int w, int h,int W)
    {   double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double aux,aux2,aux3;
        double M=w, N=h;
        double termou,termov ;
       
        //calculando D2
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                aux = D2[u][v] - Math.pow(D0, 2);
                aux2 = D2[u][v] * W;
                aux3 =(-1)*(Math.pow(aux/aux2,2));
                H[u][v]=(1- (Math.exp(aux3)) );
                G[u][v] = H[u][v]*F[u][v];
            }
        }
        
        return G;
    }
    //filtro band-pass ideal
    public static double [][] bandpassideal (double F[][],int D0, int w, int h,int W)
    {   double [][] D = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                if(D[u][v]>=D0-W/2 && D[u][v]<=D0+W/2){
                    H[u][v]=1;
                }
                else
                    H[u][v]=0;
                
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        return G;
        
    }
    //filtro band-pass butterworth
    public static double[][] bandpassbutterworth (double F[][],int D0, int w, int h,int W,int n)
    {   double [][] D = new double [w][h];
        double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double M=w, N=h;
        double termou,termov ;
        
        //calculando D
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D[u][v]= Math.sqrt(termou + termov);
            }
        }
        //calculando D2
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                H[u][v] = 1 - (1/Math.pow( (1+((D[u][v]*W)/(D2[u][v]-Math.pow(D0,2)))) ,2*n));
                G[u][v] = H[u][v] * F[u][v];
            }
        }
        
        return G;
    }
    //filtro band-pass gaussiano
    public static double[][] bandpassgaussiano (double F[][],int D0, int w, int h,int W)
    {   double [][] D2 = new double [w][h];
        double [][] H = new double [w][h];
        double [][] G = new double [w][h];
        double aux,aux2,aux3;
        double M=w, N=h;
        double termou,termov ;
       
        //calculando D2
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                termou = Math.pow((M/2.0)-u,2);
                termov = Math.pow((N/2.0)-v,2);
                D2[u][v]= termou + termov;
            }
        }
        for(int u=0;u<M;u++){
            for(int v=0;v<N;v++){
                aux = D2[u][v] - Math.pow(D0, 2);
                aux2 = D2[u][v] * W;
                aux3 =(-1)*(Math.pow(aux/aux2,2));
                H[u][v]= 1 -(1- (Math.exp(aux3)) );
                G[u][v] = H[u][v]*F[u][v];
            }
        }
        
        return G;
    }
}
