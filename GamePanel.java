import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel{
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;

    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        //startGame();
    }

    public void startGame(){

    }
}
