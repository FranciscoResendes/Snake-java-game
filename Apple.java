import java.util.Random;

public class Apple {
    private int x;
    private int y;
    private Random random;
    private final int gameUnitX;
    private final int gameUnitY;
    private final int movementUnit;

    public Apple(int unitX, int unitY, int movUnit) {
        gameUnitX = unitX / movUnit;
        gameUnitY = unitY / movUnit;
        movementUnit = movUnit;
        random = new Random();
    }

    public void newApple(int snakeX, int snakeY) {
        x = random.nextInt(gameUnitX) * movementUnit;
        y =  random.nextInt(gameUnitY) * movementUnit;
        while(x == snakeX && y == snakeY){
            x = random.nextInt(gameUnitX) * movementUnit;
            y =  random.nextInt(gameUnitY) * movementUnit;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
