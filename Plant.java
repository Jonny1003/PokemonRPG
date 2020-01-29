import java.awt.image.BufferedImage;
import java.awt.Graphics;
/**
 * Creates a plant object. All plant objects are noncollidable
 * 
 * @Jonathan Ke
 * @ 8/13/2019
 */
public class Plant
{
    //x and y are coordinates of where object is drawn NOT where it will be located
    //as an object
    private int x;
    private int y;
    private BufferedImage b;
    
    //Constructors
    public Plant(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        b = img;
    }
    
    //Constructor for doubling input image onto final plant object
    public Plant(int x, int y, BufferedImage img, boolean bool){
        this.x = x;
        this.y = y;
        b = new BufferedImage(64,32,BufferedImage.TYPE_INT_ARGB);
        Graphics g = b.getGraphics();
        if (bool){
          g.drawImage(img,0,0,null);
        }
        g.drawImage(img,16,0,null);
        g.dispose();
    }
    
    //accesors
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public BufferedImage getImage(){
        return b;
    }
}
