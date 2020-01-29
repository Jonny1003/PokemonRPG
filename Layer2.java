import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.ArrayList;
/**
 * Layer for drawing collidable static objects on map
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class Layer2 
{
    //for generating images
    private StaticObject[][] grid;

    //for collision checking
    private ArrayList<StaticObject> obj;

    //Constructor
    public Layer2(){
        grid = new StaticObject[50][200];
        obj = new ArrayList<StaticObject>();

        //building pond1 and pond2
        //xD and yD indicate width and height of pond
        int xD = 544, yD = 128;

        //add pond1 to layer
        StaticObject pond = new StaticObject(800,736,808,738,xD-22,yD-28, getPondImage(xD, yD));
        pond.setEmpty(true);
        grid[800/32][736/16-1] = pond;
        obj.add(pond);

        //add pond2 to layer
        xD = 448;
        yD = 160;

        pond = new StaticObject(864,864,872,866, xD-22,yD-28, getPondImage(xD, yD));
        pond.setEmpty(true);
        grid[864/32][864/16-1] = pond;
        obj.add(pond);

        //add tree/jungle area
        for (int x = 224; x < 720; x+=32){
            StaticObject tree = getTree(x,1158);
            grid[x/32][1158/16+3] = tree;
            obj.add(tree);
        }
        
        for (int i = 0; i < 25; i++){
            //randomly generate tree locations in forest
            int x = (int) (Math.random()*(720-224))/32*32 + 224;
            int y = (int) (Math.random()*(192))/16*16 + 960+256;
            StaticObject tree = getTree(x,y);
            grid[x/32][y/16+2] = tree;
            obj.add(tree);
        }

    }

    //accesors
    private static StaticObject getTree(int x, int y){
        BufferedImage treeImg = SpriteSheetCutter.getImage("berrytree");
        return new StaticObject(x,y,x+5,y+40,24,12,treeImg);
    }

    //draws a pond image of specific size
    private static BufferedImage getPondImage(int xD, int yD){
        BufferedImage w = SpriteSheetCutter.getImage("water"),
        wCenter = w.getSubimage(16,16,32,32),
        up = w.getSubimage(16,0,32,32),
        l = w.getSubimage(0,16,32,32),
        r = w.getSubimage(32,16,32,32),
        low = w.getSubimage(16,32,32,32),
        uR = w.getSubimage(32,0,32,32),
        uL = w.getSubimage(0,0,32,32),
        lR = w.getSubimage(32,32,32,32),
        lL = w.getSubimage(0,32,32,32);

        BufferedImage pond = new BufferedImage(xD,yD,BufferedImage.TYPE_INT_ARGB);

        Graphics g = pond.getGraphics();        
        g.drawImage(uL,0,0,null);
        g.drawImage(uR,xD-32,0,null);
        g.drawImage(lL,0,yD-32,null);
        g.drawImage(lR,xD-32,yD-32,null);

        for (int i = 32; i < xD-32; i+=32){
            g.drawImage(up,i,0,null);
            for (int j = 32; j < yD-32;j+=32)
                g.drawImage(wCenter,i,j,null);
            g.drawImage(low,i,yD-32,null);
        }        
        for (int i = 32; i < yD-32; i+=32){
            g.drawImage(l,0,i,null);
            g.drawImage(r,xD-32,i,null);
        }

        g.dispose();
        return pond;
    }

    public StaticObject[][] getLayer(){
        return grid;
    }

    public ArrayList<StaticObject> getObjects(){
        return obj;
    }
}