/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste2;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
/**
 *
 * @author Nathália
 */
public class Histograma {
    public static int[] histogramafunc(int image[]){
        int histog[] = new int [256];
        for(int i=0; i<image.length;i++){
            int red = (image[i] >> 16) & 0xff;
            histog[red]= histog[red]+1;
        }
       return histog;
    }    
            
     
}
