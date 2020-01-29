import java.awt.image.BufferedImage;

/**
 * builds a pokemon object, future edits to program should add more fields 
 * to pokemon object that can be implemented in game
 */
public class Pokemon
{
    // instance variables - replace the example below with your own
    private String name;

    private BufferedImage[] animations;
    
    private int spawnTime;

    /**
     * Constructor for objects of class Pokemon, used for all pokemon except heart/gold pack
     */
    public Pokemon(String name, String loc, boolean b, int x, int y)
    {
        this.name = name;
        if (b){
            animations = SpriteSheetCutter.createAnimationBlocks(SpriteSheetCutter.getSheet(loc),4,4);
        } else {
            animations = SpriteSheetCutter.createAnimationBlocks(SpriteSheetCutter.getSheet(x,y,loc),4,3);
        }
        spawnTime = 1000;
    }
    
    //constructor for heartgold pokemon
    public Pokemon(String name, String loc, int x, int y){
        this.name = name;
        spawnTime = 1000;
        animations = SpriteSheetCutter.createAnimationBlocks(SpriteSheetCutter.getHeartGold(x,y,loc));
    }
    
    //accessor methods
    public String getName(){
        return name;
    }

    public BufferedImage[] getAnimations(){
        return animations;
    }
    
    public int getSpawnTime(){
        return spawnTime;
    }
    
    //spawn time is set at default to 1000, 
    //use mutator to set specialized spawn time
    public void setSpawnTime(int time){
        spawnTime = time;
    }
}
