public class Snake {
    private final  int[][] body;

    public Snake(int size, int startPos) {
        this.body = new int[size][size];
        this.body[0][1] = startPos;
    }

    public int getHeadX() {
        return this.body[0][0];
    }

    public Integer getHeadY() {
        return this.body[0][1];
    }

    public void setHeadX(int x) {
        this.body[0][0] = x;
    }

    public void setHeadY(int y) {
        this.body[0][1] = y;
    }

    public int[][] getBody() {
        return this.body;
    }

    public void moveHead(char direction, int distance) {
        switch (direction) {
            
            case 'D':
                this.body[0][1] += distance;
                break;
            case 'U':
                this.body[0][1] -= distance;
                break;
            case 'L':
                this.body[0][0] -= distance;
                break;
            case 'R':
                this.body[0][0] += distance;
                break;
        }

    }
}
