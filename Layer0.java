import java.awt.image.BufferedImage;
import java.awt.*;
/**
 * Creates the background image of game
 * 
 * @Jonathan Ke
 * @8/13/2019
 */

public class Layer0 extends BufferedImage
{
    public Layer0(){
        super(1600,1600,BufferedImage.TYPE_INT_RGB);
        
        //grass area
        BufferedImage grass = getImage("Grass");
        Graphics2D g = createGraphics();        
        for (int i = 0; i < 1600; i+=32){
            for (int j = 0; j < 1600; j+=32)
                g.drawImage(grass,null,i,j);
        }      

        //dirt area
        BufferedImage dirt = getImage("dirt");
        for (int i = 192; i < 600; i+=32){
            for (int j = 192; j < 600; j+=32){
                g.drawImage(dirt,null,i,j);
            }
        }

        //dirt edges
        BufferedImage rGrassEdge = getImage("rightedgegrass");
        for (int j = 192; j < 610; j+=32){
            g.drawImage(rGrassEdge,null,192,j);
        }
        BufferedImage dGrassEdge = getImage("downedgegrass");
        for (int i = 224; i < 610; i+=32){
            g.drawImage(dGrassEdge,null,i,160);
        }

        g.drawImage(getImage("upperleftdirt"),null,212,172);

        BufferedImage upedge = getImage("bottomdirt");
        BufferedImage leftedge = getImage("rightsidedirt");
        for (int i = 224; i < 600; i+=32){
            g.drawImage(upedge,null,i,608);
            g.drawImage(leftedge,null,608,i-32);
        }
        g.drawImage(leftedge,null,608,576);

        g.drawImage(getImage("rightcornerdirt"),null,608,608);
        g.drawImage(getImage("upperrightdirt"),null,608,170);
        g.drawImage(getImage("lowerleftdirt"),null,205,608);

        //details in dirt area
        BufferedImage b = getImage("largegrasspatch");
        g.drawImage(b,null,225,200);
        g.drawImage(b,null,300,210);

        //draw trees in background, this area is off limits to roaming     
        b = getImage("tree");
        
        for (int i = 0; i < 1600; i+=32){
            for (int j = 0; j < 110; j+=16){
                g.drawImage(b,null,i,j);
                g.drawImage(b,null,i,1456+j);
            }
        }
        
        for (int i = 0; i < 190; i+=32){
            for (int j = -32; j < 1600; j+=16){
                g.drawImage(b,null,i,j);
                g.drawImage(b,null,1408+i,j);
            }
        }

       
        g.dispose();
    }
    
    //shortened method for importing images
    private BufferedImage getImage(String s){
        return SpriteSheetCutter.getImage(s);
    }
}