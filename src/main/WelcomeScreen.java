package main;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

/**
 * Created by j on 23.02.15.
 */
public class WelcomeScreen extends JFrame{
    String name;
    public WelcomeScreen() {
        final JList jList = new JList(getNames().toArray());
        jList.setSelectedIndex(0);
        final JPanel jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        jPanel.add(jList);
        jPanel.add(new JLabel("Choose your name"));
        final JButton newNameButton = new JButton("New name");
        newNameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String name = JOptionPane.showInputDialog(
                        getContentPane(),
                        "Write your name",
                        "Your name",
                        JOptionPane.OK_CANCEL_OPTION
                );
                if (name != null) newName(name);
                jList.setListData(getNames().toArray());
                jList.setSelectedIndex(0);
            }
        });
        jPanel.add(newNameButton);
        JButton playbutton = new JButton("Play");
        final JFrame current = this;
        playbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                name = (String) jList.getSelectedValue();
                new MainScreen(name);
               // this.setVisible
               // return;//System.exit(1);
            }
        });
        jPanel.add(playbutton);

        this.add(jPanel, BorderLayout.CENTER);

        this.setMinimumSize(new Dimension(300, 300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private java.util.List<String> getNames() {
        java.util.List<String> names = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("includes/names.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                names.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    private void newName(String name) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("includes/names.txt", true));
            bw.append("\n" + name);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
