import java.util.ArrayList;
import java.awt.Rectangle;
/**
 * Object overseeing actor spawn, despawn, movement coordination
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class ActorMovementControl {

    //import all necessary variables from pokedex(this is a little tedious)
    private Pokedex pokedex = new Pokedex();
    private ArrayList<Actor> actors;
    private Collision collision;

    //net time of game
    private int time = 0;

    private ArrayList<Pokemon> d1 = pokedex.getDirtPokemon1();
    private ArrayList<Pokemon> d2 = pokedex.getDirtPokemon2();

    private ArrayList<Pokemon> g1 = pokedex.getGrassPokemon1();
    private ArrayList<Pokemon> g2 = pokedex.getGrassPokemon2();
    private ArrayList<Pokemon> w1 = pokedex.getWaterPokemon1();
    private ArrayList<Pokemon> w2 = pokedex.getWaterPokemon2();
    private ArrayList<Pokemon> wH2O = pokedex.getH2OPokemon();
    private ArrayList<Pokemon> f1 = pokedex.getForestPokemon1();
    private ArrayList<Pokemon> f2 = pokedex.getForestPokemon2();
    private ArrayList<Pokemon> wh1 = pokedex.getWheatPokemon1();
    private ArrayList<Pokemon> wh2 = pokedex.getWheatPokemon2();
    private ArrayList<Pokemon> whi1 = pokedex.getWhitePokemon1();
    private ArrayList<Pokemon> whi2 = pokedex.getWhitePokemon2();
    private ArrayList<Pokemon> unk = pokedex.getUnkown();
    private ArrayList<Pokemon> leg = pokedex.getLegendary();

    private TextBox tBox;

    public ActorMovementControl(ArrayList<Actor> a, Pokedex pokedex, Collision c, TextBox tBox){
        actors = a;
        this.pokedex = pokedex;
        collision = c;
        this.tBox = tBox;

        //initial spawn
        //generate initial pokemon
        for (int i = 0; i < 5; i++){
            spawn(d1,280,210,300,300);
            spawn(g1,800,170,300,300);
            spawn(w1,800,600,300,300);
            spawn(f1,210, 1200, 500, 180);
            spawn(wh1,700, 1100, 490, 180);
            spawn(whi1,200, 600, 500, 600);
        }
    }

    //net update for all Actors
    public void update(){ 
        //move current actors or terminate them if needed
        for (int i = 0; i < actors.size();){
            Actor a = actors.get(i);
            if (a.timeUp() || a.isCaught()){
                System.out.println("HERE");
                if (a.isCaught()){            
                    tBox.setText("You caught "+a.getPokemon().getName().toUpperCase()+"!");
                }
                a.terminate();
            } else{
                a.move(); 
                i++;
            }    

        }

        //overall time
        time++;

        //spawn new actors
        //dirt area
        if (time%100 == 0){
            spawn(d1,210,210,400,400);
        }

        if (time%700 == 0){
            spawn(d2,210,210,350,400);
        }

        //grass area
        if (time%101 == 0){
            spawn(g1,800,150,380,500);
        }

        if (time%800 == 0){
            spawn(g2,800,150,380,500);
        }

        //water area
        if (time%150 == 0){
            spawn(w1,800,700,350,400);
        }

        if (time%750 == 0){
            spawn(w2,800,700,350,400);
        }

        //water only pokemon
        if (time%700 == 0){
            //hitboxes of water ponds
            spawn(wH2O,872,866,448-20, 160-20);
            spawn(wH2O,800,736,544-20, 128-20);
        }

        //forest area
        if (time%100 == 0){
            spawn(f1,195, 1200, 450, 180);
        }

        if (time%750 == 0){
            spawn(f2,195, 1200, 450, 180);
        }

        //wheat area
        if (time%75 == 0){
            spawn(wh1,700, 1100, 670, 295);
        }

        if (time%750 == 0){
            spawn(wh2,700, 1100, 670, 295);
        }

        //white grass area
        if (time%60 == 0){
            spawn(whi1,200, 700, 500, 500);
        }

        if (time%750 == 0){
            spawn(whi2,200, 700, 500, 500);
        }

        if (time%600 == 0){
            spawn(unk,200,150,1100,1100);
        }

        if (time%100 == 6 && Math.random() > .99){
            System.out.println("A LEGENDARY IS HERE!!!!!");
            spawn(leg,200,150,1100,1100);
        }
    }
    
    //spawns all pokemon with equal probability per spawn
    public void updateSpec(){
        //move current actors or terminate them if needed

        for (int i = 0; i < actors.size();){
            Actor a = actors.get(i);
            if (a.timeUp() || a.isCaught()){
                if (a.isCaught()){            
                    tBox.setText("You caught "+a.getPokemon().getName().toUpperCase()+"!");
                }
                a.terminate();
            } else if (!a.isCaught()){
                a.move(); 
                i++;
            }    

        }
        
        if (time%20 == 0){
            spawn(pokedex.getPokedex(),200,150,1000,1000);
        }
        
        time++;
    }

    //spawning method
    public void spawn(ArrayList<Pokemon> pok, int x, int y, int w, int l){
        //choose spawn point
        int xSpawn, ySpawn;
        do {
            xSpawn = x+(int)(Math.random()*w);
            ySpawn = y+(int)(Math.random()*l);
        } while (collision.checkRectangle(new Rectangle(xSpawn,ySpawn,32,32)));

        //create actor
        Actor actor = 
            new Actor(pok.get((int)(Math.random()*pok.size())), xSpawn, ySpawn,collision);

        //choose actor action
        if (Math.random() > .80){
            actor.random(600);
        } else {
            if (Math.random() > .5)
            actor.circle((int)(2000*Math.random())+1000);
            else actor.circleOpp((int)(2000*Math.random())+1000);
        }
    }
}
