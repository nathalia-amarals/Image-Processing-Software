/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;
import java.lang.Object;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import static teste2.Imagem.loadImage;
/**
 *
 * @author Nathália
 */
public class Teste2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
          /*BufferedImage imagem = loadImage("C:\\PID\\teste.jpg");
          int w = imagem.getWidth();  
          int h = imagem.getHeight();  
          BufferedImage imagemaux = imagem;
          
          int rgba[] = new int[w * h];
          // obtem pixels do bufferedImage  
          imagem.getRGB(0, 0, w, h, rgba, 0, w);  
  
          // converte para tons de cinza  
          int gray[] = ConverteCinza.imageToGray(rgba);  
          // escreve no bufferedImage  
          imagem.setRGB(0, 0, w, h, gray, 0, w);   
          // escreve nova imagem no disco  
          
          try{  
                ImageIO.write(imagemaux, "JPG", new File("C:\\PID\\teste1.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }
          
          /*int negativo[]= Transforma.negativo(gray);
          imagem.setRGB(0, 0, w, h, negativo, 0, w);
          
          try{  
                ImageIO.write(imagem, "JPG", new File("C:\\PID\\teste2.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }
          
          int limiarizada[]= Transforma.limiar(gray,128);
          imagemaux.setRGB(0, 0, w, h, limiarizada, 0, w);
          
          try{  
                ImageIO.write(imagemaux, "JPG", new File("C:\\PID\\testelimiar.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }
          
          int potencial[]= Transforma.potencia(gray,(0.5));
          imagemaux.setRGB(0, 0, w, h,potencial, 0, w);
          try{  
                ImageIO.write(imagemaux, "JPG", new File("C:\\PID\\testepotencia.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }
          
          
          int equalizada[]= Transforma.equalizacao(gray);
          imagemaux.setRGB(0, 0, w, h,equalizada, 0, w);
          try{  
                ImageIO.write(imagemaux, "JPG", new File("C:\\PID\\testeequalizada.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }
          
          BufferedImage imagem2 = loadImage("C:\\PID\\Digital.jpg");
          int w2 = imagem2.getWidth();  
          int h2 = imagem2.getHeight();  
  
          int rgba2[] = new int[w2 * h2];
          // obtem pixels do bufferedImage  
          imagem.getRGB(0, 0, w, h, rgba2, 0, w); 
          int gray2[]=ConverteCinza.imageToGray(rgba2);
          int add[]= Transforma.adicao(gray,gray2);
          imagem.setRGB(0, 0, w, h,add, 0, w);
          try{  
                ImageIO.write(imagem, "JPG", new File("C:\\PID\\resultadosoma.jpg"));
          } catch(Exception e){
              e.printStackTrace();
          }*/
    
          //NewJFrame.main();
            //ExibeHistograma.main();
        //Trabalho2TelaInicial.main();
        IntegracaoT1T2.main();
    }
}
