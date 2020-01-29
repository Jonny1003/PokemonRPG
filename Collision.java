import java.awt.Rectangle;
import java.util.ArrayList;
/**
 * Checks all collision for the provided objects/classes
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class Collision
{
    Layer2 l2;
    Player p;

    private ArrayList<Actor> pokemon;

    public Collision(Layer2 l, ArrayList<Actor> a){
        l2 = l;
        pokemon = a;
    }

    //adds and removes players and actors as needed
    public void add(Player p){
        this.p = p;
    }

    public void add(Actor a){
        pokemon.add(a);
    }

    public void remove(Actor a){
        pokemon.remove(a);
    }

    //hitbox checkers
    public boolean checkPlayer(){
        Rectangle player = p.getHitBox();
        ArrayList<StaticObject> objects = l2.getObjects();
        for (StaticObject s: objects){
            if (s.intersects(player)){
                return true;
            }
        }   
        for (Actor a : pokemon){
            if (player.intersects(a.getHitBox())){
                return true;
            }
        }
        return false;
    }

    public boolean checkActor(Actor a){
        Rectangle actor = a.getHitBox();
        ArrayList<StaticObject> objects = l2.getObjects();
        if (actor.intersects(p.getHitBox())){
            return true;
        }
        for (StaticObject s: objects){
            if (s.intersects(actor)){
                return true;
            }
        }       
        for (Actor p : pokemon){
            if (!p.equals(a) && p.getHitBox().intersects(actor)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkRectangle(Rectangle r){
        ArrayList<StaticObject> objects = l2.getObjects();
        if (r.intersects(p.getHitBox())){
            return true;
        }
        for (StaticObject s: objects){
            if (s.intersects(r)){
                return true;
            }
        }       
        for (Actor p : pokemon){
            if (p.getHitBox().intersects(r)){
                return true;
            }
        }
        return false;
    }

    public Actor checkPokeball(Pokeball ball){
        Rectangle r = ball.getHitBox();
        for (Actor a : pokemon){
            if (a.getHitBox().intersects(r)){
                return a;
            }
        }
        return null;
    }

}
