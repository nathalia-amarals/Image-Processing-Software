/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

/**
 *
 * @author Nathália
 */
public class ConverteCinza {
    public static int [] imageToGray(int image[]) {  
        int grayimage[] = new int[image.length];  
        for (int i = 0; i < image.length; i++) {  
                // extrai a informação RGBA do valor inteiro
                //desloca os valores pro final e faz um and com 255 para zerar os "quadrantes" que não interessam
               int alpha = (image[i] >> 24) & 0xff;  
               int red = (image[i] >> 16) & 0xff;  
               int green = (image[i] >> 8) & 0xff;  
               int blue = (image[i]) & 0xff;  
                
                
                // média dos valores RGB para tranformar para  
                // escala de cinza  
                int mean = (int) ((0.3 * red) + (0.59 * green) + (0.11* blue));  
  
                // converte a informação de rgb para inteiro  
                int gray = ((255 << 24) & 0xFF000000) | ((mean << 16) & 0x00FF0000) | ((mean << 8) & 0x0000FF00) | (mean & 0x000000FF);  
                
                // seta o pixel modificado na imagem  
                grayimage[i] = gray;  
                }   
                     //JOptionPane.showMessageDialog(null, "ConverteuCinza");
          return grayimage;  
    }            
}
