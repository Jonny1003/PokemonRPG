import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Class is composed of number of cutting methods and image loading method.
 * All images converted to buffered image for future usage.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class SpriteSheetCutter
{

    // Returns null if no image found
    public static BufferedImage getImage(String file){
        BufferedImage b = null;
        try{
            File f = new File(file+".png");
            b = ImageIO.read(f);
        } catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }

    // Gets rectangular subimage at designated location of input sheet
    public static BufferedImage getSheet(int x, int y, String sheet){
        BufferedImage s = getImage(sheet);
        return s.getSubimage(x*s.getWidth()/4,y*s.getHeight()/2,s.getWidth()/4,s.getHeight()/2);       
    }

    //reiteration of getImage method, meant to be concurrent with other methods
    public static BufferedImage getSheet(String sheet){
        return getImage(sheet);
    }

    //creates BufferedImage array for animating over
    public static BufferedImage[] createAnimationBlocks(BufferedImage sheet, int rows, int columns){
        BufferedImage[] b = new BufferedImage[16];
        int w = sheet.getWidth()/columns;
        int h = sheet.getHeight()/rows;
        //will order images in array dependent on column input
        if (columns == 3){
            for (int i = 0; i < 4; i++){
                b[i*4] = sheet.getSubimage(1*w,i*h,w,h); 
                b[i*4+1] = sheet.getSubimage(0*w,i*h,w,h); 
                b[i*4+2] = sheet.getSubimage(1*w,i*h,w,h); 
                b[i*4+3] = sheet.getSubimage(2*w,i*h,w,h); 
            }
        } else if (columns == 4){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    b[i*4+j] = sheet.getSubimage(j*w,i*h,w,h);
                }
            }
        }
        return b;
    }

    //creates BufferedImage array for animating over, used for heart/gold sprite pack
    public static BufferedImage[] createAnimationBlocks(BufferedImage sheet){
        BufferedImage[] b = new BufferedImage[16];

        int index = 0;
        int[] dirY = new int[]{64,0,64,0};
        int[] dirX = new int[]{0,32,32,0};
        for (int x = 0; x < 4; x++){
            for (int i = 0; i < 33; i+=32){
                b[index] = sheet.getSubimage(dirX[x],dirY[x],32,32);
                index++;
                b[index] = sheet.getSubimage(dirX[x],dirY[x]+32,32,32);
                index++;
            }
        }

        return b;
    }

    //used for cutting subimages from plant image pack
    public static BufferedImage getSubimage(int x, int y, BufferedImage sheet){
        int w = sheet.getWidth()/12;
        int h = sheet.getHeight()/8;
        return sheet.getSubimage(w*x,h*y,w,h);
    }
    
    private static final BufferedImage heartGold = getImage("hg2");

    //used for cutting sprites from heart/gold sprite pack
    public static BufferedImage getHeartGold(int x, int y, String sheet){
        int extraX = 2*x/3;
        int extraY = 9*y/11;
        return heartGold.getSubimage(x*64+extraX,y*128+extraY,64,128);          
    }
}
