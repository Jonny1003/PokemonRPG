import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.image.BufferedImage;
import java.awt.*;

/**
 * GUI interface for user. Put game inside a DS as a joke. I don't know what
 * sort of interface will make the game look best to user.
 * 
 * @Jonathan Ke
 * @8/13/2019
 */
public class MainScreen
{
    Player player;
    //display cut from GameFrame
    JLabel display;
    JLabel textBox = new TextBox();
    JFrame f;

    public MainScreen(Player player){
        this.player = player;

        //create display object
        display = new JLabel();
        display.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        display.setBorder(new LineBorder(Color.BLACK));

        
        //group display and right side of DS together
        JPanel pMain = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        pMain.add(display);

        JLabel rightSide = new JLabel(new ImageIcon(SpriteSheetCutter.getImage("dsRightSide")));
        rightSide.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pMain.add(BorderLayout.LINE_END,rightSide);

        //add in other sides of DS
        JPanel pTop = new JPanel(new BorderLayout(0,0));    
        pTop.setBackground(Color.BLACK);  

        pTop.add(BorderLayout.CENTER,pMain);
        pTop.add(BorderLayout.PAGE_START,new JLabel(new ImageIcon(SpriteSheetCutter.getImage("dsTop"))));
        pTop.add(BorderLayout.LINE_START,new JLabel(new ImageIcon(SpriteSheetCutter.getImage("dsLeftSide"))));        
        pTop.add(BorderLayout.PAGE_END,new JLabel(new ImageIcon(SpriteSheetCutter.getImage("dsBottom"))));

        //testing ArrowKeys
        ArrowKeys arrowKeys = new ArrowKeys(player, this);

        JPanel pBottom = new JPanel(new BorderLayout());
        pBottom.setBackground(Color.BLACK);
        pBottom.add(BorderLayout.CENTER,textBox);
        pBottom.add(BorderLayout.SOUTH,arrowKeys);

        JPanel pFinal = new JPanel(new BorderLayout());

        pFinal.add(BorderLayout.CENTER, pTop);
        pFinal.add(BorderLayout.PAGE_END, pBottom);

        //udpate variables in frame
        f = new JFrame("POKEMON ADVENTURE");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.addKeyListener(player);        

        f.add(pFinal);       
        f.pack();
        f.setMaximumSize(new Dimension(f.getWidth(),f.getHeight()));
        f.setMinimumSize(new Dimension(f.getWidth(),f.getHeight()));
        f.setFocusable(true);
        f.setVisible(true);
        f.requestFocus();

    }
    
    //updates viewable display
    public void updateDisplay(BufferedImage b){
        display.setIcon(new ImageIcon(b.getSubimage(player.getX()-190,player.getY()-140,400,300)));
    }
    
    public JLabel getTextBox(){
        return textBox;
    }

    public JFrame getFrame(){
        return f;
    }

}
