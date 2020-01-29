import java.awt.*;
import java.io.File;

class LoadFont {
    public static void main(String[] args) throws Exception {
        // This font is < 35Kb.
        File file = new File("/Users/jonathanke/Documents/JavaProjects/VSPokemon/joystix/joystix monospace.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, file);
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        //JList fonts = new JList( ge.getAvailableFontFamilyNames() );
        //JOptionPane.showMessageDialog(null, new JScrollPane(fonts));
    }
}