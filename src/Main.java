import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    int WIDTH = 800;
    int HEIGHT = 600;
    
    public Main() {
        super("Zasrana PBW");
        this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new Main();
    }
}

