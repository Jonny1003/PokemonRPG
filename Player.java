import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;

/**
 * Creates a moveable and collidable player object. Use arrow keys to move player. 
 * Use spacebar to throw pokeball.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class Player implements KeyListener, ActionListener, IActor
{    
    //location and display fields
    private BufferedImage[] animations = SpriteSheetCutter.createAnimationBlocks(SpriteSheetCutter.getSheet("ash"),4,4);

    private int x;
    private int y;
    private int xVel;
    private int yVel;
    private int direction;  

    private BufferedImage display;
    private int displayVal;

    //state and movement updating fields
    private Timer tPos;
    private Timer tState;

    //pokeball instance variables
    private Pokeball pokeball = null;
    private boolean threwBall = false;

    //boolean for movement consistency
    private boolean isMoving;

    //collision class
    private Collision collision;

    //static direction variables
    public static int SOUTH = 0;
    public static int EAST = 4;
    public static int WEST = 8;
    public static int NORTH = 12;

    public Player(Collision c){
        /*
         * sprite testing/mod, change string name to another pokemon to 
         * mod main player image.
         */
        //Pokedex pokedex = new Pokedex();
        //String pokemon = "espurr";
        //animations = pokedex.getPokemon(pokemon).getAnimations();

        //update collision field
        collision = c;

        //initialize player states
        x = 700;
        y = 700;      
        xVel = 0;
        yVel = 0;
        direction = SOUTH; 
        display = animations[0];

        //tracks displayed direction 
        displayVal = 0;

        //timer for movement tracking
        tPos = new Timer(30, this);

        //timer for image display
        tState = new Timer(80,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (xVel != 0 || yVel != 0){
                        display = animations[displayVal];
                        displayVal = direction+(displayVal+1)%4;
                    }
                }         
            });
        tState.setInitialDelay(1);

        tPos.start();        
    }

    //movement tracking
    @Override
    public void actionPerformed(ActionEvent e){                   
        x+= xVel;
        y+= yVel;
        if (x > 1370 || y > 1440 || x < 192 || y < 150 || collision.checkPlayer()){
            x -= xVel;
            y -= yVel;
        }
    }

    //accessors
    public BufferedImage getState(){
        return display;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Rectangle getHitBox(){
        return new Rectangle(x+6,y+6,20,20);
    }

    //pokeball access methods
    public boolean hasThrownBall(){
        return threwBall;
    }

    public Pokeball getPokeball(){
        return pokeball;
    }

    //player controls 
    @Override
    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        keyMove(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e){
        stop();
    }

    @Override
    public void keyTyped(KeyEvent e){
    }

    public void stop(){
        xVel = 0;
        yVel = 0;
        isMoving = false;
        tState.stop();
    }

    public void keyMove(int keyCode){
        if (pokeball == null || pokeball.stopped()){

            //movement keylistener
            if (!isMoving){
                isMoving = true;
                if (keyCode == KeyEvent.VK_UP){
                    yVel = -2;
                    direction = NORTH;
                } else if (keyCode == KeyEvent.VK_DOWN){
                    yVel = 2;
                    direction = SOUTH;
                } else if (keyCode == KeyEvent.VK_RIGHT){
                    xVel = 2;
                    direction = WEST;
                } else if (keyCode== KeyEvent.VK_LEFT){
                    xVel = -2;
                    direction = EAST;
                } 
                tState.start();
            }

            //pokeball keylistener
            threwBall = false;
            if (keyCode == KeyEvent.VK_SPACE){
                pokeball = new Pokeball(getX(), getY(), direction, collision);
                threwBall = true;
            }

            if (displayVal/4 != direction/4){
                displayVal = direction;
            }
        }
    }

    public int getXVel(){
        return xVel;
    }

    public int getYVel(){
        return yVel;
    }
}
