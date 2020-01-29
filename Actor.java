import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;
/**
 * Pokemon moving object with collision enabled and animation for being caight.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class Actor implements ActionListener, IActor
{
    //object properties
    private Collision collision;
    private Pokemon pok;

    //location/speed tracking
    private int x;
    private int y;
    private int xVel;
    private int yVel;

    //animation tracking
    private int direction;
    private BufferedImage display;
    private int displayVal;

    //state and movement updating
    private Timer tState;
    private Timer tMovement;
    private Timer tEnd;

    //spawn time tracking
    private int timeAlive = 0;


    public Actor(Pokemon p, int x, int y, Collision c){
        collision = c;
        pok = p;

        //initialize actor states
        this.x = x;
        this.y = y;      
        xVel = 0;
        yVel = 0;
        direction = Player.SOUTH; 
        display = pok.getAnimations()[0];

        //tracks displayed direction
        displayVal = Player.SOUTH;
        
        collision.add(this);

        //changes display image
        tState = new Timer(100,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    if (xVel != 0 || yVel != 0){
                        display = pok.getAnimations()[displayVal];
                        displayVal = direction+(displayVal+1)%4;
                    }
                }         
            });
            
        tState.setInitialDelay(1);            
    }

    //controls movement of actor
    @Override
    public void actionPerformed(ActionEvent e){                   
        move();
    }   

    public void move(){
        x+= xVel;
        y+= yVel;
        if (x > 1364 || y > 1436 || x < 192 || y < 150 || collision.checkActor(this)){
            x -= xVel;
            y -= yVel;
        }
        //update the time alive
        timeAlive++;      
    }

    //checks if the actor has finished time
    public boolean timeUp(){
        return timeAlive == pok.getSpawnTime();      
    }

    //accesors 
    public BufferedImage getState(){
        return display;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //actor moves in a circle
    public void circle(int time){
        int[][] ordinance = {{0,-1},{1,0},{0,1},{-1,0}};        
        tMovement = new Timer(time,new ActionListener(){
                private int ordinanceInd = 0;
                private int distance = 1;
                private int[][] moveOrdinance = ordinance; 

                @Override                   
                public void actionPerformed(ActionEvent e){
                    //update velocity values
                    xVel = distance*moveOrdinance[ordinanceInd][0];
                    yVel = distance*moveOrdinance[ordinanceInd][1]; 

                    //update image display fields
                    if (ordinanceInd == 2){
                        direction = Player.SOUTH;
                    } else if (ordinanceInd == 1){
                        direction = Player.WEST;                           
                    } else if (ordinanceInd == 3){
                        direction = Player.EAST;                           
                    } else{
                        direction = Player.NORTH;                           
                    }
                    displayVal = direction;

                    //change direction
                    ordinanceInd = (ordinanceInd+1)%4;
                }

            });
            
        tMovement.setInitialDelay(1);
        tMovement.start();
        tState.start();
    }
    
     //actor moves in a circle
    public void circleOpp(int time){
        int[][] ordinance = {{0,1},{-1,0},{0,-1},{1,0}}; 
        
        tMovement = new Timer(time,new ActionListener(){
                private int ordinanceInd = 0;
                private int distance = 1;
                private int[][] moveOrdinance = ordinance; 

                @Override                   
                public void actionPerformed(ActionEvent e){
                    //update velocity values
                    xVel = distance*moveOrdinance[ordinanceInd][0];
                    yVel = distance*moveOrdinance[ordinanceInd][1]; 

                    //update image display fields
                    if (ordinanceInd == 0){
                        direction = Player.SOUTH;
                    } else if (ordinanceInd == 3){
                        direction = Player.WEST;                           
                    } else if (ordinanceInd == 1){
                        direction = Player.EAST;                           
                    } else{
                        direction = Player.NORTH;                           
                    }
                    displayVal = direction;

                    //change direction
                    ordinanceInd = (ordinanceInd+1)%4;
                }

            });
            
        tMovement.setInitialDelay(1);
        tMovement.start();
        tState.start();
    }

    //actor moves randomly
    public void random(int time){
        tMovement = new Timer(time,new ActionListener(){

                int[][] moveOrdinance = {{0,-1},{1,0},{0,1},{-1,0}};
                int ordinanceInd = 0;
                int distance = 1;

                @Override                   
                public void actionPerformed(ActionEvent e){
                    //update velocity values
                    xVel = distance*moveOrdinance[ordinanceInd][0];
                    yVel = distance*moveOrdinance[ordinanceInd][1]; 

                    //update image display fields
                    if (ordinanceInd == 2){
                        direction = Player.SOUTH;
                    } else if (ordinanceInd == 1){
                        direction = Player.WEST;                           
                    } else if (ordinanceInd == 3){
                        direction = Player.EAST;                           
                    } else{
                        direction = Player.NORTH;                           
                    }
                    displayVal = direction;

                    //change direction
                    ordinanceInd = (int) (4*Math.random());
                }

            });
            
        tMovement.setInitialDelay(1);
        tMovement.start();
        tState.start();
    }

    //flash animation creation, flash boolean indicator
    BufferedImage[] flash = flashAnimation();
    boolean caught = false;

    private BufferedImage[] flashAnimation(){
        BufferedImage[] f = new BufferedImage[10];
        for (int i = 1; i <= 10; i++){
            f[i-1] = SpriteSheetCutter.getImage("flash"+i);
        }
        return f;
    }

    public boolean isCaught(){
        return caught;
    }

    //actor disappears in flash, terminates object movement
    public void flash(){
        //stop movement
        tState.stop();
        tMovement.stop();

        //store final image
        BufferedImage finalState = display; 

        //update position for "flash" animation
        int xFin = x - 9;
        int yFin = y - 9; 

        tEnd = new Timer(40,new ActionListener(){

                private int i = 0;

                @Override
                public void actionPerformed(ActionEvent e){
                    x = xFin;
                    y = yFin;
                    
                    BufferedImage b = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
                    Graphics g = b.getGraphics();
                    if (i < 10){                          
                        BufferedImage img = flash[i];
                        g.drawImage(img,25-img.getWidth()/2,25-img.getHeight()/2,null);                       
                        g.drawImage(finalState,9,9,null);
                    } else if (i == 20){
                        tEnd.stop();
                        caught = true;
                        System.out.println("You caught "+pok.getName().toUpperCase()+"!");
                    } else {
                        BufferedImage img = flash[19-i];
                        g.drawImage(img,25-img.getWidth()/2,25-img.getHeight()/2,null);                                                                                
                    }
                    g.dispose(); 
                    display = b;
                    i++;
                }         
            });
        tEnd.start();
    }

    //accessors
    public Rectangle getHitBox(){
        //special hitboxes for legendaries
        if (pok.getName().equalsIgnoreCase("kyogre")){
            new Rectangle(x+16,y+16,32,32);
        } else if (pok.getName().equalsIgnoreCase("exeggutor")){
            new Rectangle(x,y+32,64,32);
        }
        return new Rectangle(x+8,y+8,18,18);
    }

    public Pokemon getPokemon(){
        return pok;
    }

    //equals method to check identity of actors
    public boolean equals(Actor a){
        return (x == a.getX() && y == a.getY() && pok.getName().equalsIgnoreCase(a.getPokemon().getName()));
    }   

    //removes this object from GameFrame queue and collision queue
    public void terminate(){
        tState.stop();
        tMovement.stop();
        collision.remove(this);       
    }
}