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
public class MainFrame extends JFrame {
	protected JuzzlePanel juzzlePanel = null;

	/**
  *
  */
	public MainFrame() {
		super("Juzzle [version " + JuzzlePanel.version + "]");

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int w = screen.width - 50;
		int h = screen.height - 50;

		setSize(w, h);
		setLocation((screen.width - w) / 2, (screen.height - h) / 2);

		juzzlePanel = new JuzzlePanel();

		Container contentPane = getContentPane();
		contentPane.add(juzzlePanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		juzzlePanel.revalidate();
		juzzlePanel.startGame();
	}
}
