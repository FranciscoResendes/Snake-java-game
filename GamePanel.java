import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class GamePanel extends JPanel implements Runnable{
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    boolean gameOver = false;
    int bodySize = 5;
    static int x = 0;
    static int y = 0;
    char direction = 'R';
    Thread gameThread;

    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        startGameThread();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void draw(Graphics g){
        for(int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++){
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        g.setColor(Color.green);
        g.fillRect(x, y, UNIT_SIZE, UNIT_SIZE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void move(){
        switch (direction) {
            case 'D':
                y = y + UNIT_SIZE;
                break;
            case 'U':
                y = y - UNIT_SIZE;
                break;
            case 'L':
                x = x - UNIT_SIZE;
                break;
            case 'R':
                x = x + UNIT_SIZE;
                break;
        }
    }

    @Override
    public void run() {
        while(!gameOver){
            move();
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
