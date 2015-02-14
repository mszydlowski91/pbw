package puzzle;

/*
 * A puzzle game written in Java.
 *
 * Please read "http://juzzle.sourceforge.net/juzzle_licence.txt" for copyrights.
 * 
 * The sourcecode is designed and created with
 * Sun J2SDK 1.3 and Microsoft Visual J++ 6.0
 *
 * Juzzle homepage: http://juzzle.sourceforge.net
 *
 * autor: Slawa Weis
 * email: slawaweis@animatronik.net
 *
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 *
 */
public class ControlPanel extends JPanel {
	protected static final Color textBackground = new Color(128, 0, 0);
	protected static final Color textForeground = new Color(255, 255, 0);
	protected static final int imageSize = 200;

	protected JLabel imagePanel = null;
	protected JLabel piecesLabel = null;
	protected JLabel solvedLabel = null;
	protected JLabel timeLabel = null;

	protected int gameTime = 0;
	protected Timer gameTimeCounter = new Timer(1000, new TimeCounterListener());
	protected int sec, min, hour, time;
	protected String ssec, smin;

	/**
  *
  */
	public ControlPanel() {
		super(new BorderLayout());

		imagePanel = new JLabel();
		imagePanel.setHorizontalAlignment(JLabel.CENTER);

		// setImage(new ImageIcon("doco2-05.jpg").getImage());

		// JScrollPane imagePanel_jsp = new JScrollPane(imagePanel);
		// imagePanel_jsp.setPreferredSize(new Dimension(200, 200));

		JPanel center = new JPanel(new GridLayout(1, 1));
		center.setPreferredSize(new Dimension(220, 220));
		CompoundBorder border1 = new CompoundBorder(
				new EmptyBorder(5, 5, 5, 5), new EtchedBorder());
		center.setBorder(new CompoundBorder(border1,
				new EmptyBorder(5, 5, 5, 5)));
		center.add(imagePanel);

		JPanel statistic = new JPanel(new GridBagLayout());
		statistic.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10),
				new BevelBorder(BevelBorder.LOWERED)));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		statistic.add(createLabel("Pieces:", JLabel.RIGHT), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		statistic.add(createLabel("Solved:", JLabel.RIGHT), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		statistic.add(createLabel("Time:", JLabel.RIGHT), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		statistic.add(piecesLabel = createLabel("", JLabel.LEFT), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		statistic.add(solvedLabel = createLabel("", JLabel.LEFT), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		statistic.add(timeLabel = createLabel("", JLabel.LEFT), gbc);

		add(BorderLayout.CENTER, center);
		add(BorderLayout.SOUTH, statistic);
	}

	public void setImage(Image image) {
		int iw = image.getWidth(null);
		int ih = image.getHeight(null);

		int niw = 0;
		int nih = 0;

		if (iw >= ih) {
			niw = imageSize;
			nih = (int) ((double) ih * ((double) imageSize / (double) iw));
		} else {
			niw = (int) ((double) iw * ((double) imageSize / (double) ih));
			nih = imageSize;
		}

		Image image_scaled = image
				.getScaledInstance(niw, nih, Image.SCALE_FAST);
		imagePanel.setIcon(new ImageIcon(image_scaled));
	}

	protected JLabel createLabel(String text, int layout) {
		JLabel jl = new JLabel(text, layout);
		jl.setBorder(new EmptyBorder(0, 5, 0, 2));
		jl.setOpaque(true);
		jl.setBackground(textBackground);
		jl.setForeground(textForeground);
		jl.setFont(new Font("SansSerif", Font.PLAIN, 11));
		return jl;
	}

	public void startCounter() {
		gameTime = 0;
		printTime("00:00");
		if (gameTimeCounter.isRunning())
			gameTimeCounter.restart();
		else
			gameTimeCounter.start();
	}

	public void stopCounter() {
		gameTimeCounter.stop();
	}

	public String getGameTime() {
		time = gameTime;

		sec = time % 60;
		ssec = (sec < 10 ? "0" + sec : "" + sec);
		time = time / 60;
		if (time < 1)
			return "00:" + ssec;

		min = time % 60;
		smin = (min < 10 ? "0" + min : "" + min);
		time = time / 60;
		if (time < 1)
			return smin + ":" + ssec;

		hour = time;
		return hour + ":" + smin + ":" + ssec;
	}

	public void printPieces(String s) {
		if (piecesLabel != null)
			piecesLabel.setText(s);
	}

	public void printSolved(String s) {
		if (solvedLabel != null)
			solvedLabel.setText(s);
	}

	public void printTime(String s) {
		if (timeLabel != null)
			timeLabel.setText(s);
	}

	protected class TimeCounterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gameTime++;
			printTime(getGameTime());
		}
	}
}
