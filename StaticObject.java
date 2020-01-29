import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 * Creates a static object with collidable properties.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class StaticObject 
{
    private BufferedImage b;

    //area where object will be drawn
    private int x;
    private int y;
    //used to generate hit boxes
    private Rectangle r;
    //determines if inside of object is moveable (like a pool)
    private boolean isEmpty = false;

    //Constructors(wide variety of constructors so hitboxes can be edited with detail)
    public StaticObject(int x, int y, int w, int h, BufferedImage b){
        this.x = x;
        this.y = y;
        this.b = b;      
        r = new Rectangle(x,y,w,h);
    }

    //hitbox is dtermined as crop of input coordinates
    public StaticObject(int x, int y, int w, int h, int crop, BufferedImage b){
        this.x = x;
        this.y = y;
        this.b = b;      
        r = new Rectangle(x+crop,y+crop,w-2*crop,h-2*crop);
    }

    //define both the hitbox and actual coordinates
    public StaticObject(int x, int y, int xHit, int yHit, int wHit, int hHit, BufferedImage b){
        this(x,y,b);
        r = new Rectangle(xHit,yHit,wHit,hHit);        
    }

    //shortened version of earlier constructor
    public StaticObject(int x, int y,BufferedImage b){
        this(x,y,b.getWidth(),b.getHeight(),b);
    }

    //crop will decrease every edge by that many pixels
    public StaticObject(int x, int y, int crop, BufferedImage b){
        this(x,y,b.getWidth(),b.getHeight(),crop,b);
    }

    //accessors
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Rectangle getHitBox(){
        return r;
    }

    public BufferedImage getImage(){
        return b;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    //mutators
    public void setEmpty(boolean b){
        isEmpty = b;
    }

    //checks if there is collision
    public boolean intersects(Rectangle r){
        if (isEmpty){
            if (this.r.contains(r)){
                return false;
            }
        } 
        return r.intersects(this.r);
    }
}
