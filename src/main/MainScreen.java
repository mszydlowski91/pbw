package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by j on 23.02.15.
 */
public class MainScreen extends JFrame {
    int WIDTH = 800;
    int HEIGHT = 600;
    int highlighted;
    CanvasPanel canvas;

    public MainScreen(String name) {
        super("PBW");

        this.setLayout(new GridBagLayout());

        //this.setContentPane(new JLabel(new ImageIcon(image)));

        canvas = new CanvasPanel();
        canvas.setSize(WIDTH,HEIGHT);


        ContentPanel content = new ContentPanel();
        content.setOpaque(false);
        content.setBounds(0, 0, WIDTH, HEIGHT);


        

        JLayeredPane layers = getLayeredPane();
        layers.add(canvas, new Integer(1));
        layers.add(content, new Integer(2));
        
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void openPresentation() {
        try {
            // Desktop
            // Runtime.getRuntime().exec("include/14-ajp_ife_lecture02-en.pptx");
            //Runtime.getRuntime().exec("cmd /c start \"%programfiles%\\Windows Media Player\\wmplayer.exe\" \"e:\\2.mp3\"");
            String line;
            Process p = Runtime.getRuntime().exec("includes/14-ajp_ife_lecture02-en.pptx");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //-- Parse data here.
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class ContentPanel extends JPanel {
        public ContentPanel() {
            this.setLayout(null);

            this.add(new Button(1));
            this.add(new Button(2));
            this.add(new Button(3));

        }
        
    }
    
    private class Button extends JButton {
        int[][] dimButtons = new int[][]{
                {370, 70, 140, 80},
                {150, 210, 190, 70},
                {570, 170, 170, 110}
        };
        public Button(final int id) {

            this.setText("Button"+id);
            this.setBounds(dimButtons[id - 1][0], dimButtons[id - 1][1], dimButtons[id - 1][2], dimButtons[id - 1][3]);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    highlighted = id;
                    canvas.repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    highlighted = 0;
                    canvas.repaint();
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    switch (id) {
                        case 1:
                            //
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                }

            });
        }
        
    }

    private class CanvasPanel extends JLabel {//mplements MouseListener {
        int[] dimCloud1 = {300, 0, 300, 300};
        int[] dimCloud2 = {100, 150, 300, 200};
        int[] dimCloud3 = {450, 100, 400, 300};

        Image cloud1;
        Image cloud1highlighted;
        Image cloud2;
        Image cloud2highlighted;
        Image cloud3;
        Image cloud3highlighted;

        public CanvasPanel() {
            highlighted = 0;
            cloud1 = new ImageIcon("includes/cloud1.png").getImage();
            cloud2 = new ImageIcon("includes/cloud2.png").getImage();
            cloud3 = new ImageIcon("includes/cloud3.png").getImage();
            cloud1highlighted = new ImageIcon("includes/cloud1highlighted.png").getImage();
            cloud2highlighted = new ImageIcon("includes/cloud2highlighted.png").getImage();
            cloud3highlighted = new ImageIcon("includes/cloud3highlighted.png").getImage();
            Image image = Toolkit.getDefaultToolkit().getImage("includes/background.png");

            this.setIcon(new ImageIcon(image));
            //this.addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (highlighted == 1) g.drawImage(cloud1highlighted, dimCloud1[0], dimCloud1[1], dimCloud1[2], dimCloud1[3], this);
            else g.drawImage(cloud1, dimCloud1[0], dimCloud1[1], dimCloud1[2], dimCloud1[3], this);
            if (highlighted == 2) g.drawImage(cloud2highlighted, dimCloud2[0], dimCloud2[1], dimCloud2[2], dimCloud2[3], this);
            else g.drawImage(cloud2, dimCloud2[0], dimCloud2[1], dimCloud2[2], dimCloud2[3], this);
            if (highlighted == 3) g.drawImage(cloud3highlighted, dimCloud3[0], dimCloud3[1], dimCloud3[2], dimCloud3[3], this);
            else g.drawImage(cloud3, dimCloud3[0], dimCloud3[1], dimCloud3[2], dimCloud3[3], this);

        }
    }
}
