import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements Runnable{
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    private boolean gameOver;
    private Snake snake;
    private char direction;
    private Thread gameThread;

    GamePanel(){
        direction = 'R';
        gameOver = false;
        snake = new Snake(UNIT_SIZE);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new KeyHandler());
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
        g.fillRect(snake.getHeadX(), snake.getHeadY(), UNIT_SIZE, UNIT_SIZE);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void move(){
        snake.moveHead(direction, UNIT_SIZE);
    }

    public void chechCollisions(){

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

    public class KeyHandler extends KeyAdapter{

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
            
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
            }
        }
    }

}
