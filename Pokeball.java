import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;

/**
 * Pokeball object that player uses to catch pokemon.
 * 
 * @Jonathan ke
 * @8/13/2019
 */

public class Pokeball implements ActionListener{

    //location fields
    private final int yFin;
    private int x;
    private int y;

    //animation fields
    private int initVal;
    private int time = 1;
    private int direction;
    private Timer t;

    //accessor fields
    private boolean ballStopped = false;

    //image 
    private BufferedImage img = SpriteSheetCutter.getImage("pokeball");
    
    //collision class
    private Collision collision;

    public Pokeball(int initX, int initY, int direction, Collision c){
        this.direction = direction;
        collision = c;
        
        //check for direction of throw to set pokeball fields
        if (direction == Player.NORTH){
            yFin = initY-44;
            x = initX+9;
            initVal = initY+8;
        } else if (direction == Player.SOUTH){
            yFin = initY+32;
            x = initX + 9;
            initVal = initY + 20;
        } else if (direction == Player.EAST){
            yFin = initY;
            x = initX;
            initVal = initY + 16;
        } else {
            //ball thrown west
            yFin = initY;
            x = initX + 20;
            initVal = initY + 16;
        }

        t = new Timer(100, this);
        t.start();
    }

    //animation of pokeball, used parabolic arcs to best approximate a throw
    @Override
    public void actionPerformed(ActionEvent e){
        if (direction == Player.WEST){
            x += 4;
            y = initVal - (int)(time*15.5) + 2*time*time;                           
        } else if (direction == Player.EAST){
            x -= 4;
            y = initVal - (int)(time*15.5) + 2*time*time;  
        } else if (direction == Player.NORTH){
            y = initVal - time*20 + 2*time*time;
        } else {
            y = initVal - time*12 + 2*time*time;
        }

        time += 1; 
        if (time == 9){
            t.stop();
            ballStopped = true;
            
            Actor pok = collision.checkPokeball(this);
            if (pok != null){
                pok.flash();
            }           
        }
    }

    //graphics accessor methods
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public BufferedImage getBall(){
        return img;
    }

    //accessor to check whether ball is still moving
    public boolean stopped(){
        return ballStopped;
    }

    //hitbox accessor methods
    public Rectangle getHitBox(){
        return new Rectangle(x+1, y, 12, 12);
    }
    
    public int getHitBoxY(){
        return yFin;
    }    
}
