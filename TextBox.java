import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Updates GUI on Pokemon catches
 *
 * @Jonathan Ke
 * @8/27/2019
 */
public class TextBox extends JLabel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private String text;
    private int index = 0;
    
    Player p;
    public TextBox(){
        super("Use the arrow keys to move. Press the spacebar to throw pokeballs.");
        setBackground(Color.BLACK);
        setIcon(new ImageIcon(SpriteSheetCutter.getImage("textbox")));
        //font control and text control
        Font f = new Font("Joystix",Font.BOLD,12);
        setFont(f);
        setForeground(Color.WHITE);
        setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public void setText(String txtString){
        text = txtString;
        index = 0;
        Timer t = new Timer(50,this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        super.setText(text.substring(0,index));
        if (index == text.length()){
            ((Timer)e.getSource()).stop();
        }
        index++;
    }
}
