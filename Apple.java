import java.util.Random;

public class Apple {
    private int x;
    private int y;
    private Random random;
    private final int gameUnitX;
    private final int gameUnitY;
    private final int movementUnit;

    public Apple(int unitX, int unitY, int movUnit) {
        this.gameUnitX = unitX / movUnit;
        this.gameUnitY = unitY / movUnit;
        this.movementUnit = movUnit;
        this.random = new Random();
    }

    public void newApple(int[][] snakeBody){
        this.x = random.nextInt(gameUnitX) * movementUnit;
        this.y =  (random.nextInt(gameUnitY -1 ) + 1) * movementUnit;
        while(!isValidPosition(snakeBody)){
            this.x = random.nextInt(gameUnitX) * movementUnit;
            this.y =  (random.nextInt(gameUnitY -1 ) + 1) * movementUnit;
        }
    }

    public boolean isValidPosition(int[][] snakeBody){
        for(int i = 0; i < snakeBody.length; i++){
            if(this.x == snakeBody[i][0] && this.y == snakeBody[i][1]){
                return false;
            }
        }
        return true;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
}
