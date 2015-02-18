package main;
import javax.swing.*;

import puzzle.PuzzleGameFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame{
    int WIDTH = 800;
    int HEIGHT = 600;
    
    public Main() {
        super("PBW");
        
        this.setLayout(new GridBagLayout());
        
        

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(50,50,50,50);
        constraints.ipadx = 10;
        constraints.ipady = 10;
        
        for (int i = 0; i < 4; i++) {
            constraints.gridx = i%2;
            constraints.gridy = i/2;
            this.add(new label(), constraints);

        }

        this.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private class label extends JLabel {
        //String path = "/home/j/workspace/java/pbw/includes/bird.jpg";
        String path = "includes/bird.jpg";

        public label() {
            ImageIcon imageIcon = new ImageIcon(path);
          //  thi
            Image image = Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(200,150, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(image));
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    //System.out.println("cos sie bedzie otwierac");
                    new PuzzleGameFrame();
                }
            });
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }
}


