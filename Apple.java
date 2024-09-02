import java.util.Random;

public class Apple {
    private int x;
    private int y;
    private Random random;
    private final int gameUnit;

    public Apple(int unit) {
        gameUnit = unit;
        random = new Random();
        x = random.nextInt(25) * gameUnit;
        y = random.nextInt(25) * gameUnit;
    }

    public void newApple() {
        Random random = new Random();
        x = random.nextInt(25) * gameUnit;
        y =  random.nextInt(25) * gameUnit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
}
