/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Nathália
 */
public class EspectroF {
        void geraEspectroF(BufferedImage img,int dft[],int w,int h){
        
            img.setRGB(0, 0, w, h,dft , 0, w);
            Graphics2D g2;  
            // Now draw the image  
            //g2 = (Graphics2D)Trabalho2TelaInicial.Espectro.getRootPane().getGraphics();
        
            //g2.drawImage(img, null, 0, 0);
        
    }
}
