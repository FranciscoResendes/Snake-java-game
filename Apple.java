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

    public void newApple(int[][] snakeBody){
        x = random.nextInt(gameUnitX) * movementUnit;
        y =  random.nextInt(gameUnitY) * movementUnit;
        while(!isValidPosition(snakeBody)){
            x = random.nextInt(gameUnitX) * movementUnit;
            y =  random.nextInt(gameUnitY) * movementUnit;
        }
    }

    public boolean isValidPosition(int[][] snakeBody){
        for(int i = 0; i < snakeBody.length; i++){
            if(x == snakeBody[i][0] && y == snakeBody[i][1]){
                return false;
            }
        }
        return true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
