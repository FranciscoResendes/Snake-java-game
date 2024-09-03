public class Snake {
    private final  int[][] body;

    public Snake(int size) {
        this.body = new int[size][size];
        //thisbody[0][0] = ;
    }

    public int getHeadX() {
        return body[0][0];
    }

    public Integer getHeadY() {
        return body[0][1];
    }

    public void setHeadX(int x) {
        body[0][0] = x;
    }

    public void setHeadY(int y) {
        body[0][1] = y;
    }

    public int[][] getBody() {
        return body;
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
