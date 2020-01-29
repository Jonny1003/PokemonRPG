import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a GUI of buttons for controlling main player 
 * 
 * @Jonathan Ke
 * @9/13/2019
 */

public class ArrowKeys extends JPanel {

    private Player player;
    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;

    private Boolean[] isClicked = new Boolean[]{false,false,false,false};
    private static int UP = KeyEvent.VK_UP;
    private static int DOWN = KeyEvent.VK_DOWN;
    private static int RIGHT = KeyEvent.VK_RIGHT;
    private static int LEFT = KeyEvent.VK_LEFT;


    public ArrowKeys(Player p, MainScreen m){
        super();
        player = p;
        left = new JButton("LEFT");
        right = new JButton("RIGHT");
        up = new JButton("UP");
        down = new JButton("DOWN");

        ActionListener l = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (isClicked[0]){
                    isClicked[0] = false;
                    player.stop();
                } else{
                    for (int i = 0; i < isClicked.length; i++){
                        isClicked[i] = false;
                    }
                    player.stop();
                    isClicked[0] = true;
                    player.keyMove(LEFT);
                }
                m.getFrame().requestFocus();
            }
        };
        ActionListener r = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (isClicked[1]){
                    isClicked[1] = false;
                    player.stop();
                } else{
                    for (int i = 0; i < isClicked.length; i++){
                        isClicked[i] = false;
                    }
                    player.stop();
                    isClicked[1] = true;
                    player.keyMove(RIGHT);
                }
                m.getFrame().requestFocus();
            }
        };
        ActionListener u = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (isClicked[2]){
                    isClicked[2] = false;
                    player.stop();
                } else{
                    for (int i = 0; i < isClicked.length; i++){
                        isClicked[i] = false;
                    }
                    player.stop();
                    isClicked[2] = true;
                    player.keyMove(UP);
                }
                m.getFrame().requestFocus();
            }
        };
        ActionListener d = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (isClicked[3]){
                    isClicked[3] = false;
                    player.stop();
                } else{
                    for (int i = 0; i < isClicked.length; i++){
                        isClicked[i] = false;
                    }
                    player.stop();
                    isClicked[3] = true;
                    player.keyMove(DOWN);
                }
                m.getFrame().requestFocus();
            }
        };

        left.addActionListener(l);
        right.addActionListener(r);
        up.addActionListener(u);
        down.addActionListener(d);
        
        this.add(left);
        this.add(right);
        this.add(up);
        this.add(down);
    }
    public static void main(String[] args){
        JFrame f = new JFrame("POKEMON ADVENTURE");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);           
        f.pack();
        f.setFocusable(true);
        f.setVisible(true);
    }
}