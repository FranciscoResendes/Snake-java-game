public class Snake {
    private final  int[][] body;

    public Snake(int size) {
        this.body = new int[size][size];
    }

    public int getHeadX() {
        return body[0][0];
    }

    public Integer getHeadY() {
        return body[0][1];
    }

    public void moveHead(char direction, int distance) {
        switch (direction) {
            
            case 'D':
                body[0][1] += distance;
                break;
            case 'U':
                body[0][1] -= distance;
                break;
            case 'L':
                body[0][0] -= distance;
                break;
            case 'R':
                body[0][0] += distance;
                break;
        }

    }
}
