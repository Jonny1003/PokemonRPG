import java.awt.image.BufferedImage;

/**
 * Layer for noncollidable static objects, includes all Plant objects
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class Layer1{
    
    //import downloaded plant sheet
    private BufferedImage plants = SpriteSheetCutter.getSheet("plants");

    //grid for storing plant locations
    private Plant[][] grid;

    //static plant variables
    public static final int W = GameFrame.W;
    public static final int H = GameFrame.H;


    //constructor for drawing layer 1, can edit this constructor 
    //with appropriate images to create new maps.
    //Each image must be a plant object and assigned a location on grid
    public Layer1(){       

        //quadruple height for more accurately located objects
        grid = new Plant[1600/W][1600/H];

        //draw wheat patches
        BufferedImage wheat = SpriteSheetCutter.getImage("wheat"),
        wheat2 = SpriteSheetCutter.getImage("wheatWhite");

        for (int i = 0; i < 500; i++){
            int rX = 224+(int)(Math.random()*500)/W*W, rY = 704+(int)(Math.random()*(400))/H*H;
            if (Math.random() > .3){
                grid[rX/W][rY/H] = new Plant(rX,rY+3,wheat2,true);
            } else {
                grid[rX/W][rY/H] = new Plant(rX,rY+3,wheat,true); 
                grid[rX/W][rY/H+1] = new Plant(rX,rY+H+3,wheat,true);
            }
        }

        //draw wheat farm
        BufferedImage grass = SpriteSheetCutter.getSubimage(11,3,plants);
        for (int i = 800; i < 1300; i += W){
            for (int j = 1056; j < 1410; j += 2*H){
                //adjust the wheat image to align base with bottom of hitbox
                Plant p = new Plant(i,j+H+2,grass,true);
                grid[i/W][j/H+1] = p;
                
            }
        }

        //draw carrot farm
        for (int i = 224; i < 400; i += H){
            for (int j = 256; j < 500; j += W){
                int r1 = (int) (Math.random()*3), r2 = (int) (Math.random()*4);
                Plant p = new Plant(i,j+H,SpriteSheetCutter.getSubimage(r1,r2,plants));
                grid[i/W][j/H] = p;
            }
        }

        //draw bananas
        for (int i = 418; i < 608; i += W){
            for (int j = 160; j < 600; j += H*2){
                int r = (int) (Math.random()*2)+10;
                grid[i/W][j/H] = new Plant(i,j+3,SpriteSheetCutter.getSubimage(r,4,plants),true);             
            }
        }
        for (int j = 160; j < 600; j += H*2){
            int r = (int) (Math.random()*2)+10;
            grid[608/W][j/H] = new Plant(608,j+3,SpriteSheetCutter.getSubimage(r,4,plants));             
        }


        //draw tall grass
        BufferedImage tGrass = SpriteSheetCutter.getImage("tallgrass");
        for (int i = 0; i < 500; i++){
            int x = 800+(int)(Math.random()*500)/W*W, y = 144+(int)(Math.random()*500)/H*H;
            if (Math.random() > .3) grid[x/W][y/H] = new Plant(x,y+2,tGrass,true); 
            else grid[x/W][y/H] = new Plant(x,y+3,tGrass); 
        }
        //for (int i = 0; i < 50; i++){
            //addGrassPatch(800+(int)(Math.random()*500)/64*64,192+(int)(Math.random()*500)/64*64);
        //}  

        //draw weeds for tree/jungle area
        for (int x = 224; x < 700; x += W){
            for (int y = 960+256; y < 1450; y += W){
                if (Math.random() > .4){
                    int r1 = (int) (Math.random()*9), r2 = (int) (Math.random()*2);
                    Plant p = new Plant(x,y+10,SpriteSheetCutter.getSubimage(3+r1,6+r2,plants));
                    grid[x/W][y/H] = p;
                }
            }
        }
        
    }

    //draws a 4x4 grass patch
    private void addGrassPatch(int x, int y){
        BufferedImage g = SpriteSheetCutter.getImage("largegrass");

        for (int i = 0; i < 2; i++){
            grid[x/W+i][y/H] = new Plant(x+i*W,y+H,g.getSubimage(i*W,0,W,H));
            grid[x/W+i][y/H+1] = new Plant(x+i*W,y+H+H,g.getSubimage(i*W,H,W,H));
            grid[x/W+i][y/H+2] = new Plant(x+i*W,y+W+H,g.getSubimage(i*W,W,W,H));
            grid[x/W+i][y/H+3] = new Plant(x+i*W,y+48+H,g.getSubimage(i*W,48,W,H));
        }

    }

    //accesors
    public Plant[][] getLayer(){
        return grid;
    }

}