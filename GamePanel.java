import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GamePanel extends JPanel implements Runnable{
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;
    private static final int UNIT_SIZE = 25;
    private static final int INITIAL_SIZE = 10;
    private static final char INITIAL_DIRECTION = 'R';
    private static final int GAME_UNITS = (SCREEN_WIDTH / UNIT_SIZE ) * (SCREEN_HEIGHT / UNIT_SIZE);
    private boolean gameOver;
    private Snake snake;
    private Apple apple;
    private int bodySize;
    private char direction;
    private Thread gameThread;

    GamePanel(){
        direction = INITIAL_DIRECTION;
        bodySize = INITIAL_SIZE;
        gameOver = false;
        snake = new Snake(GAME_UNITS);
        apple = new Apple(SCREEN_WIDTH, SCREEN_HEIGHT, UNIT_SIZE);
        apple.newApple(snake.getHeadX(), snake.getHeadY());

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

        for(int i = 1; i < bodySize; i++){
            g.fillRect(snake.getBody()[i][0], snake.getBody()[i][1], UNIT_SIZE, UNIT_SIZE);
        }

        g.setColor(Color.red);
        g.fillOval(apple.getX(), apple.getY(), UNIT_SIZE, UNIT_SIZE);
        g.dispose();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(!gameOver){
            draw(g);
        }else{
            gameOver(g);
        }
    }

    public void move(){
        for(int i = bodySize; i > 0; i--){
            snake.getBody()[i][0] = snake.getBody()[i - 1][0];
            snake.getBody()[i][1] = snake.getBody()[i - 1][1];
        }

        snake.moveHead(direction, UNIT_SIZE);
    }

    public void checkCollisions(){
        if(snake.getHeadX() == apple.getX() && snake.getHeadY() == apple.getY()){
            bodySize++;
            apple.newApple(snake.getHeadX(), snake.getHeadY());
        }
        for (int i = 1; i < bodySize; i++){
            if(snake.getHeadX() == snake.getBody()[i][0] && snake.getHeadY() == snake.getBody()[i][1]){
                gameOver = true;
            }
        }
        if(snake.getHeadX() < 0){
            snake.setHeadX(SCREEN_WIDTH);
        }
        else if(snake.getHeadX() > SCREEN_WIDTH){
            snake.setHeadX(0);
        }
        else if(snake.getHeadY() < 0){
            snake.setHeadY(SCREEN_HEIGHT);
        }
        else if(snake.getHeadY() > SCREEN_HEIGHT){
            snake.setHeadY(0);
        }
    }

    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Courier New", Font.PLAIN, 50));
        g.drawString("Game Over", (SCREEN_WIDTH - g.getFontMetrics().stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
        g.drawString(("Score: " + (bodySize - INITIAL_SIZE)), (SCREEN_WIDTH - g.getFontMetrics().stringWidth("Score: " + bodySize)) / 2, SCREEN_HEIGHT / 2 + 50);
        g.dispose();
    }

    @Override
    public void run() {
        while(!gameOver){
            move();
            checkCollisions();
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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

}
//Todo:
// Game Over check and panel
// Score during game
// Thread to sleep after switching direction with key press
// Fix bug where snake stays out of bounds if, after head is OfB but the neck isn't, you move the snake
// Fix size of snake body array
// Apple has to be generated in a position that is not occupied by the snake