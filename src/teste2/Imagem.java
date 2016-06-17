/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

import java.util.Random;

/**
 *
 * @author Nathália
 */
public class Imagem {
       public static BufferedImage loadImage(String ref) {  
        BufferedImage imagem = null;  
        try {  
  
            imagem = ImageIO.read(new File(ref));  
            
            int w = imagem.getWidth();
            int h = imagem.getHeight();
            int[] pixels = imagem.getRGB(0, 0, w, h, null, 0, w);
            Random r = new Random();
    
            for(int col = 0; col< w; col++){
                for (int lin = 0; lin < h; lin++) {
                    pixels[w * lin + col] = new Color(r.nextInt(255), col % 255, lin % 255).getRGB();
                }
            }
            //ImageIO.write(imagem, "png", new File("C:\\PID\\arteabstrata.png")); 
        } catch (Exception e) {  
            e.printStackTrace();
            
        }  
        return imagem;  
    }
    
    //BufferedImage imagem = ImageIO.read(new File("teste.jpg"));
    //imagem.setRGB(0, 0, w, h, pixels, 0, w);
   //File outputfile = new File("saved.png");
    //ImageIO.write(imagem, "png", outputfile);
}
