import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.pack();
        
        frame.setTitle("2d game");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}