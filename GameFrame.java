import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Primary controller of all elements of game. Updates display image appropriately.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class GameFrame extends BufferedImage implements ActionListener {

    //set up control and libraries
    private Pokedex pokedex = new Pokedex();
    private ArrayList<Actor> actors = new ArrayList<Actor>();
    private ActorMovementControl actorControl;
    private Player p;  

    //set up drawing panel
    private Graphics g = this.getGraphics();
    
    //set up setting images
    private BufferedImage bg = new Layer0();
    private Layer1 l1 = new Layer1();
    private Layer2 l2 = new Layer2();
    private Collision collision = new Collision(l2,actors);

    private MainScreen screen; 

    //setup constant variables
    public static final int W = 32;
    public static final int H = 8;

    public GameFrame(){
        super(1600,1600,BufferedImage.TYPE_INT_RGB);

        //setup player object
        p = new Player(collision);
        collision.add(p);

        
        
        //setup player tracker
        screen = new MainScreen(p);
        TextBox textBox = (TextBox) screen.getTextBox();

        //setup pokemon movement
        actorControl = new ActorMovementControl(actors, pokedex, collision, textBox);
        
        //frame rate/actor speed
        Timer t = new Timer(40,this);

        //begin game
        t.start();
    }

    //net updater for all elements of game
    @Override
    public void actionPerformed(ActionEvent e){
        actorControl.updateSpec();

        update();
  
        screen.updateDisplay(this);   
    }   

    public void update(){
        //to shorten frame generation time, only seen frame is updated with image
        int startX = p.getX()-190;
        int startY = p.getY()-140; 

        //draw layer 0
        drawBackground(startX,startY);

        //draw layer 1 and 2, draw player and pokeball in perspective to objects in layer 1
        Plant[][] layer1 = l1.getLayer();

        StaticObject[][] layer2 = l2.getLayer();
        
        //draws all objects near player 
        int maxY = Math.min(layer1[0].length,(startY+300)/H+10);
        int maxX = Math.min(layer1.length,(startX+400)/W+10);
        int minY = Math.max(0,startY/H-300);
        int minX = Math.max(0,startX/W-400);



        for (int y = minY; y < maxY; y++){           
            for (int x = minX; x < maxX; x++){
                drawPlant(layer1[x][y]);
                drawStaticObject(layer2[x][y/2]);
            }
            drawActors(y);       
        }
    }

    //drawing methods used for each object in game
    private void drawActors(int y){
        //check to draw player
        if (y*H <= p.getY() && y*H+H > p.getY()){
            drawActor(p);  
            if (p.getXVel() != 0 && p.getYVel() != 0){
                System.out.println(true);
                drawShakingPlant(l1.getLayer()[p.getX()/W][y]);  
            }          
        }

        for (Actor actor : actors){
            //check to draw actors
            if (y*H <= actor.getY() && y*H+H > actor.getY() 
            && actor.getX() > p.getX()-232 && actor.getX() < p.getX()+232){
                drawActor(actor);     
                drawShakingPlant(l1.getLayer()[actor.getX()/W][y]);          
            }
        }

        //check if pokeball has been thrown(must draw last!)
        if (p.hasThrownBall() 
        && y*H <= p.getPokeball().getHitBoxY() 
        && y*H+H > p.getPokeball().getHitBoxY()){
            drawBall(p.getPokeball());
        } 
    }

    public void drawBackground(int x, int y){
        g.drawImage(bg.getSubimage(x,y,400,300),x,y,null);
    }

    public void drawActor(IActor a){        
        g.drawImage(a.getState(),a.getX(),a.getY(),null);
    }

    public void drawBall(Pokeball b){
        g.drawImage(b.getBall(),b.getX(),b.getY(),null);     
    }

    public void drawPlant(Plant p){
        if (p != null){
            g.drawImage(p.getImage(),p.getX(),p.getY(),null);
        }
    }

    public void drawShakingPlant(Plant p){
        if (p != null){
            if (Math.random() < 0.5){
                g.drawImage(p.getImage(),p.getX()-1,p.getY(),null);
            } else{
                g.drawImage(p.getImage(),p.getX()+1,p.getY(),null);
            }
        }
    }

    public void drawStaticObject(StaticObject s){
        if (s != null){
            g.drawImage(s.getImage(),s.getX(),s.getY(),null);
        }
    }

    public static void main(String[] args){
        new GameFrame();
    }
}