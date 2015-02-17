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
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;

import images.*;

/**
 *
 */
public class JuzzlePanel extends JDesktopPane {
	public static final String version = "0.5";
	public static final String ABOUT_TEXT = "<html>"
			+ "Juzzle - a puzzle game powered by Java<br><br>"
			+ "Autor: Slawa Weis<br>"
			+ "Email: <u><font color=#0000FF>slawaweis@animatronik.net</font></u><br>"
			+ "Homepage: <u><font color=#0000FF>http://juzzle.sourceforge.net</font></u><br><br>"
			+ "the most images comes from:<br>"
			+ "<u><font color=#0000FF>http://www.freeimages.co.uk</font></u><br>"
			+ "<u><font color=#0000FF>http://www.freeimages.com</font></u>"
			+ "</html>";

	protected static int userImage = 1;

	protected JScrollPane pzp_jsp = null;
	protected PuzzlePanel pzp = null;
	protected JInternalFrame controlFrame = null;

	protected StartDialog startDialog = null;
	protected ControlPanel controlPanel = null;

	protected MenuListener menuListener = new MenuListener();

	protected JFileChooser jfc = null;

	/**
  *
  */
	public JuzzlePanel() {
		super();

		controlPanel = new ControlPanel();

		pzp = new PuzzlePanel(controlPanel);
		pzp_jsp = new JScrollPane(pzp);
		pzp_jsp.setBorder(new BevelBorder(BevelBorder.LOWERED));
		pzp_jsp.setOpaque(false);
		pzp_jsp.getViewport().setOpaque(false);

		add(pzp_jsp, JDesktopPane.DEFAULT_LAYER);
		addComponentListener(new JuzzlePanelResizer());

		controlFrame = new JInternalFrame("test", false, false, false, false);
		// controlFrame.setMinimumSize(new Dimension(200, 200));
		controlFrame
				.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		controlFrame.getContentPane().add(controlPanel);
		controlFrame.setLocation(10, 10);
		controlFrame.pack();
		add(controlFrame);
		controlFrame.setVisible(true);

		JMenuBar jmb = new JMenuBar();
		JMenu jm = null;

		jm = new JMenu("Gra");
		// jm.add(createMenuItem("New", "new.gif"));
		// jm.add(createMenuItem("Open", "open.gif"));
		// jm.add(createMenuItem("Reset", "reset.gif"));
		// jm.addSeparator();
		// jm.add(createMenuItem("About", "about.gif"));
		// jm.addSeparator();
		// jm.add(createMenuItem("Quit", "quit.gif"));
		jmb.add(jm);

		jm = new JMenu("Widok");
		jm.add(createMenuItem2("Antialiasing", true));
		jm.add(createMenuItem2("Kontury", true));
		jm.add(createMenuItem2("Cieñ", true));
		jmb.add(jm);

		controlFrame.setJMenuBar(jmb);

		startDialog = new StartDialog();
	}

	protected JMenuItem createMenuItem(String name, String icon) {
		JMenuItem jmi = new JMenuItem(name, JuzzleImages.getIcon(icon));
		jmi.addActionListener(menuListener);
		return jmi;
	}

	protected JCheckBoxMenuItem createMenuItem2(String name, boolean set) {
		JCheckBoxMenuItem jmi = new JCheckBoxMenuItem(name, set);
		jmi.addActionListener(menuListener);
		return jmi;
	}

	public void loadImageForGame() {
		if (jfc == null) {
			jfc = new JFileChooser();
			jfc.addChoosableFileFilter(new ImageFileFilter());
		}

		int state = jfc.showOpenDialog(this);
		File file = jfc.getSelectedFile();

		if (file != null && state == JFileChooser.APPROVE_OPTION) {
			ImageIcon ii = new ImageIcon(file.getPath());
			ImageIcon iis = JuzzleImages.scaleIcon(ii, 80);
			ImageDescription id = new ImageDescription(ii, iis, "User image "
					+ (userImage++));
			startDialog.addToImageList(id);
			startGame();
		}
	}

	public void startGame() {
		if (startDialog.showDialog(this)) {
			Dimension div = startDialog.getSelectedDivision();
			ImageIcon imageIcon = startDialog.getSelectedImage().imageIcon;
			Image image = imageIcon.getImage();
			BufferedImage bimage = new BufferedImage(imageIcon.getIconWidth(),
					imageIcon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			bimage.getGraphics().drawImage(image, 0, 0, null);
			// int pxc = 8, pyc = 10;
			// int pxc = 2, pyc = 3;
			pzp.setGame(bimage, div.width, div.height);
			controlPanel.setImage(image);
			// controlFrame.setVisible(true);
			pzp.repaint();
		}
	}

	public class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Nowa")) {
				startGame();
			} else if (e.getActionCommand().equals("Otwórz")) {
				loadImageForGame();
			} else if (e.getActionCommand().equals("Reset")) {
				pzp.resetGame();
			} else if (e.getActionCommand().equals("About")) {
				JOptionPane.showMessageDialog(JuzzlePanel.this, ABOUT_TEXT);
			} else if (e.getActionCommand().equals("WyjdŸ")) {
				System.exit(0);
			} else if (e.getActionCommand().equals("Antialiasing")) {
				pzp.setAntialiasing(((JCheckBoxMenuItem) e.getSource())
						.isSelected());
			} else if (e.getActionCommand().equals("Kontur")) {
				pzp.setOutline(((JCheckBoxMenuItem) e.getSource()).isSelected());
			} else if (e.getActionCommand().equals("Cieñ")) {
				pzp.setShadow(((JCheckBoxMenuItem) e.getSource()).isSelected());
			}
		}
	}

	public class JuzzlePanelResizer extends ComponentAdapter {
		public void componentShown(ComponentEvent e) {
			// System.out.println("!!!");
			pzp_jsp.setSize(getSize());
			pzp_jsp.revalidate();

			// Dimension cfsize = controlFrame.getSize();
			// controlFrame.setLocation(getSize().width - cfsize.width - 10,
			// 10);
		}

		public void componentResized(ComponentEvent e) {
			// System.out.println("???");
			pzp_jsp.setSize(getSize());
			pzp_jsp.revalidate();
		}
	}

	public class ImageFileFilter extends javax.swing.filechooser.FileFilter {
		public boolean accept(File f) {
			return (f.getName().endsWith(".jpg")
					|| f.getName().endsWith(".jpeg")
					|| f.getName().endsWith(".gif") || f.isDirectory());
		}

		public String getDescription() {
			return "Images (*.jpg;*.jpeg;*.gif)";
		}
	}
}
