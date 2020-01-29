import javax.swing.SwingUtilities;

/**
 * STARTS THE ENTIRE GAME!!!!!!!
 *
 * @Jonathan Ke
 * @8/13/2019
 */

public class RunGame implements Runnable
{  
    @Override
    public void run(){
        new GameFrame();
    }
    
    public static void main(String[] args){
        RunGame g = new RunGame();
        SwingUtilities.invokeLater(g);
    }   
}
