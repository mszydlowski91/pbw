package hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author PFE
 */
public class GameHangMan extends javax.swing.JFrame {

	public void window() {

	}

	String[] wordList = { "KEYBOARD", "MOUSE", "CAMERA", "CPU", "BATTERY",
			"FAN", "CABLES", "LED", "Mother Board", "RAM", "TRANSISTOR", "IC" };
	int[] wordLength = new int[12];
	int level = (int) (Math.random() * 12);// random word

	int j = 0;
	String line = "";
	static JFrame frame = new JFrame();
	static ImageIcon ic = new ImageIcon("hang0.png");
	int wrong = 0;
	int right = 0;

	// HashMap<String,String> table=new HashMap<String,String>();

	public GameHangMan() {
		initComponents();
		this.setTitle("Hang Man Game");
		this.setSize(750, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(GameHangMan.EXIT_ON_CLOSE);
		this.setVisible(true);

		level = (int) (Math.random() * 12);// random word
		for (j = 0; j <= 11; j++) {
			wordLength[j] = wordList[j].length();// gets length of words
		}// end for
		int m = 0;
		// creates line first then put into .setText
		while (m < wordLength[level]) {
			line += "_ ";
			m++;
		}
		jLabel2.setText(line);
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

		switch (level) {
		case 0:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"keyboard.png")));
			break;
		case 1:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"mouse.png")));
			break;
		case 2:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"cam.png")));
			break;
		case 3:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"cpu.png")));
			break;
		case 4:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"battery.png")));
			break;
		case 5:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"fan.png")));
			break;
		case 6:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"cables.png")));
			break;
		case 7:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"led.png")));
			break;
		case 8:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"motherboard.png")));
			break;
		case 9:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"ram.png")));
			break;
		case 10:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"transistor.png")));
			break;
		case 11:
			jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"circuit.png")));
			break;

		}

		jMenuBar1.remove(1);

		JMenuItem menuItem1 = new JMenuItem("Restart", KeyEvent.VK_T);
		jMenu1.add(menuItem1);
		menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// right click key
				GameHangMan restart = new GameHangMan();

				level = (int) (Math.random() * 12);// random word
				for (j = 0; j <= 11; j++) {
					wordLength[j] = wordList[j].length();// gets length of words
				}// end for
				int m = 0;
				// creates line first then put into .setText
				while (m < wordLength[level]) {
					line += "_ ";
					m++;
				}
				jLabel2.setText(line);

				restart.setVisible(true);

			}// end actionPerformed method
		});
		JMenuItem menuItem2 = new JMenuItem("Exit", KeyEvent.VK_T);
		jMenu1.add(menuItem2);
		menuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {// right click key
				System.exit(0);
			}// end actionPerformed method
		});

		//

		// GameHangMan game=new GameHangMan();

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jButton10 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jButton17 = new javax.swing.JButton();
		jButton18 = new javax.swing.JButton();
		jButton19 = new javax.swing.JButton();
		jButton20 = new javax.swing.JButton();
		jButton21 = new javax.swing.JButton();
		jButton22 = new javax.swing.JButton();
		jButton23 = new javax.swing.JButton();
		jButton24 = new javax.swing.JButton();
		jButton25 = new javax.swing.JButton();
		jButton26 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jButton1.setText("L");
		jButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton1);
		jButton1.setBounds(630, 270, 40, 30);

		jButton2.setText("I");
		jButton2.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton2);
		jButton2.setBounds(480, 270, 40, 30);

		jButton3.setText("C");
		jButton3.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton3);
		jButton3.setBounds(500, 230, 40, 30);

		jButton4.setText("D");
		jButton4.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton4);
		jButton4.setBounds(550, 230, 40, 30);

		jButton5.setText("E");
		jButton5.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton5);
		jButton5.setBounds(600, 230, 40, 30);

		jButton6.setText("F");
		jButton6.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton6);
		jButton6.setBounds(650, 230, 40, 30);

		jButton7.setText("G");
		jButton7.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton7);
		jButton7.setBounds(700, 230, 40, 30);

		jButton8.setText("H");
		jButton8.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton8);
		jButton8.setBounds(430, 270, 40, 30);

		jButton9.setText("J");
		jButton9.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton9);
		jButton9.setBounds(530, 270, 40, 30);

		jButton10.setText("A");
		jButton10.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton10);
		jButton10.setBounds(400, 230, 40, 30);

		jButton11.setText("B");
		jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jButton11.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton11);
		jButton11.setBounds(450, 230, 40, 30);

		jButton12.setText("M");
		jButton12.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton12);
		jButton12.setBounds(680, 270, 40, 30);

		jButton13.setText("O");
		jButton13.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton13);
		jButton13.setBounds(450, 310, 40, 30);

		jButton14.setText("P");
		jButton14.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton14.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton14ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton14);
		jButton14.setBounds(500, 310, 40, 30);

		jButton15.setText("Q");
		jButton15.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton15.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton15ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton15);
		jButton15.setBounds(550, 310, 40, 30);

		jButton16.setText("R");
		jButton16.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton16.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton16ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton16);
		jButton16.setBounds(600, 310, 40, 30);

		jButton17.setText("S");
		jButton17.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton17.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton17ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton17);
		jButton17.setBounds(650, 310, 40, 30);

		jButton18.setText("N");
		jButton18.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton18.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton18ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton18);
		jButton18.setBounds(400, 310, 40, 30);

		jButton19.setText("T");
		jButton19.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton19.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton19ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton19);
		jButton19.setBounds(700, 310, 40, 30);

		jButton20.setText("U");
		jButton20.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton20.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton20ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton20);
		jButton20.setBounds(430, 350, 40, 30);

		jButton21.setText("Z");
		jButton21.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton21.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton21ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton21);
		jButton21.setBounds(690, 350, 40, 30);

		jButton22.setText("X");
		jButton22.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton22.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton22ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton22);
		jButton22.setBounds(590, 350, 40, 30);

		jButton23.setText("Y");
		jButton23.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton23.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton23ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton23);
		jButton23.setBounds(640, 350, 40, 30);

		jButton24.setText("K");
		jButton24.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton24.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton24ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton24);
		jButton24.setBounds(580, 270, 40, 30);

		jButton25.setText("V");
		jButton25.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton25.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton25ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton25);
		jButton25.setBounds(480, 350, 40, 30);

		jButton26.setText("W");
		jButton26.setMargin(new java.awt.Insets(2, 2, 2, 2));
		jButton26.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton26ActionPerformed(evt);
			}
		});
		getContentPane().add(jButton26);
		jButton26.setBounds(530, 350, 50, 30);

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
		jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		getContentPane().add(jLabel2);
		jLabel2.setBounds(390, 160, 350, 50);
		getContentPane().add(jLabel3);
		jLabel3.setBounds(500, 20, 190, 130);

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"hang0.png"))); // NOI18N
		getContentPane().add(jLabel4);
		jLabel4.setBounds(50, 30, 300, 360);

		jLabel1.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\PFE\\Desktop\\Image1.png")); // NOI18N
		getContentPane().add(jLabel1);
		jLabel1.setBounds(0, 0, 750, 400);

		jMenu1.setText("File");
		jMenuBar1.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed

		char[] jlabelText = jLabel2.getText().toCharArray();
		if (!wordList[level].contains(jButton11.getText())) {
			wrong++;
			jButton11.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;

		}
		jButton11.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton11.getText().charAt(0)) {
				jlabelText[2 * i] = jButton11.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton11.getText().charAt(0)
				// );

				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

		// TODO add your handling code here:
	}// GEN-LAST:event_jButton11ActionPerformed

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton4.getText())) {
			wrong++;
			jButton4.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton4.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton4.getText().charAt(0)) {
				jlabelText[2 * i] = jButton4.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton4.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton4ActionPerformed

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton6.getText())) {
			wrong++;
			jButton6.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton6.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton6.getText().charAt(0)) {
				jlabelText[2 * i] = jButton6.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton6.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton6ActionPerformed

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton5.getText())) {
			wrong++;
			jButton5.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton5.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton5.getText().charAt(0)) {
				jlabelText[2 * i] = jButton5.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton5.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton5ActionPerformed

	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton10.getText())) {
			wrong++;
			jButton10.setEnabled(false);

			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton10.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton10.getText().charAt(0)) {
				jlabelText[2 * i] = jButton10.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton10.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();

		}

	}// GEN-LAST:event_jButton10ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton3.getText())) {
			wrong++;
			jButton3.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton3.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton3.getText().charAt(0)) {
				jlabelText[2 * i] = jButton3.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton3.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton3ActionPerformed

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton7.getText())) {
			wrong++;
			jButton7.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton7.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton7.getText().charAt(0)) {
				jlabelText[2 * i] = jButton7.getText().charAt(0);
				// String
				// h=jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton7.getText().charAt(0)
				// );
				// jLabel2.setText(h);
				right++;
			}// end if
		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton7ActionPerformed

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton8.getText())) {
			wrong++;
			jButton8.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton8.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton8.getText().charAt(0)) {
				jlabelText[2 * i] = jButton8.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton8ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton2.getText())) {
			wrong++;
			jButton2.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton2.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton2.getText().charAt(0)) {
				jlabelText[2 * i] = jButton2.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

		// TODO add your handling code here:
	}// GEN-LAST:event_jButton2ActionPerformed

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton9.getText())) {
			wrong++;
			jButton9.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton9.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton9.getText().charAt(0)) {
				jlabelText[2 * i] = jButton9.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton9ActionPerformed

	private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton24ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton24.getText())) {
			wrong++;
			jButton24.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton24.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton24.getText().charAt(0)) {
				jlabelText[2 * i] = jButton24.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton24ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton1.getText())) {
			wrong++;
			jButton1.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton1.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton1.getText().charAt(0)) {
				jlabelText[2 * i] = jButton1.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton12ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton12.getText())) {
			wrong++;
			jButton12.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton12.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton12.getText().charAt(0)) {
				jlabelText[2 * i] = jButton12.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();

		}
	}// GEN-LAST:event_jButton12ActionPerformed

	private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton18ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton18.getText())) {
			wrong++;
			jButton18.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton18.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton18.getText().charAt(0)) {
				jlabelText[2 * i] = jButton18.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton18ActionPerformed

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton13ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton13.getText())) {
			wrong++;
			jButton13.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton13.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton13.getText().charAt(0)) {
				jlabelText[2 * i] = jButton13.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton13ActionPerformed

	private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton14ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton14.getText())) {
			wrong++;
			jButton14.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton14.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton14.getText().charAt(0)) {
				jlabelText[2 * i] = jButton14.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton14ActionPerformed

	private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton15ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton15.getText())) {
			wrong++;
			jButton15.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);
			}
			return;
		}

		jButton15.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton15.getText().charAt(0)) {
				jlabelText[2 * i] = jButton15.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton15ActionPerformed

	private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton16ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton16.getText())) {
			wrong++;
			jButton16.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton16.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton16.getText().charAt(0)) {
				jlabelText[2 * i] = jButton16.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton16ActionPerformed

	private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton17ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton17.getText())) {
			wrong++;
			jButton17.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton17.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton17.getText().charAt(0)) {
				jlabelText[2 * i] = jButton17.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton17ActionPerformed

	private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton19ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton19.getText())) {
			wrong++;
			jButton19.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton19.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton19.getText().charAt(0)) {
				jlabelText[2 * i] = jButton19.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));
		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton19ActionPerformed

	private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton20ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton20.getText())) {
			wrong++;
			jButton20.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton20.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton20.getText().charAt(0)) {
				jlabelText[2 * i] = jButton20.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton20ActionPerformed

	private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton25ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton25.getText())) {
			wrong++;
			jButton25.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton25.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton25.getText().charAt(0)) {
				jlabelText[2 * i] = jButton25.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton25ActionPerformed

	private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton26ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton26.getText())) {
			wrong++;
			jButton26.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton26.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton26.getText().charAt(0)) {
				jlabelText[2 * i] = jButton26.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton26ActionPerformed

	private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton22ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton22.getText())) {
			wrong++;
			jButton22.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton22.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton22.getText().charAt(0)) {
				jlabelText[2 * i] = jButton22.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton22ActionPerformed

	private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton23ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton23.getText())) {
			wrong++;
			jButton23.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton23.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton23.getText().charAt(0)) {
				jlabelText[2 * i] = jButton23.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton23ActionPerformed

	private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton21ActionPerformed
		char[] jlabelText = jLabel2.getText().toCharArray();

		if (!wordList[level].contains(jButton21.getText())) {
			wrong++;
			jButton21.setEnabled(false);
			if (wrong == 1) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang1.png")));
			}
			if (wrong == 2) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang2.png")));
			}
			if (wrong == 3) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang3.png")));
			}
			if (wrong == 4) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang4.png")));
			}
			if (wrong == 5) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang5.png")));
			}
			if (wrong == 6) {

				jLabel4.setIcon(new javax.swing.ImageIcon(getClass()
						.getResource("hang6.png")));
			}
			if (wrong == 6) {
				JOptionPane.showMessageDialog(frame, "He's dead." + "\n"
						+ "Press 'OK' to restart." + "\n" + "The word was "
						+ wordList[level] + ".", "You Lost",
						JOptionPane.INFORMATION_MESSAGE);
				// GameStructure restart = new GameStructure();
				level = (int) (Math.random() * 12);// generate new
				GameHangMan restart = new GameHangMan();
				restart.setVisible(true);

			}
			return;
		}

		jButton21.setEnabled(false);
		for (int i = 0; i < wordList[level].length(); i++) {

			if (wordList[level].charAt(i) == jButton21.getText().charAt(0)) {
				jlabelText[2 * i] = jButton21.getText().charAt(0);
				// String h
				// =jLabel2.getText().replace(jLabel2.getText().charAt(2*i),jButton8.getText().charAt(0)
				// );
				// jLabel2.setText(h);

				right++;
				//
			}// end if

		}// end for
		jLabel2.setText(String.valueOf(jlabelText));

		if (jLabel2.getText().length() / 2 == right) {
			JOptionPane.showMessageDialog(frame, "You got the word!" + "\n"
					+ "Press 'OK' for new word", "Good Job",
					JOptionPane.INFORMATION_MESSAGE);
			// GameStructure restart = new GameStructure();
			level = (int) (Math.random() * 12);// generate new
			GameHangMan restart = new GameHangMan();
			restart.setVisible(true); // random word
			// restart.window();
		}

	}// GEN-LAST:event_jButton21ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GameHangMan.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GameHangMan.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GameHangMan.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GameHangMan.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GameHangMan().setVisible(true);

			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton17;
	private javax.swing.JButton jButton18;
	private javax.swing.JButton jButton19;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton20;
	private javax.swing.JButton jButton21;
	private javax.swing.JButton jButton22;
	private javax.swing.JButton jButton23;
	private javax.swing.JButton jButton24;
	private javax.swing.JButton jButton25;
	private javax.swing.JButton jButton26;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	// End of variables declaration//GEN-END:variables
}
