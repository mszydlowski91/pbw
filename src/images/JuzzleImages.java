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
package images;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Vector;

import javax.swing.ImageIcon;

import puzzle.ImageDescription;

/**
 *
 */
public class JuzzleImages {
	public static Image loadImage(String name) {
		Class thisClass = JuzzleImages.class;
		return new ImageIcon(thisClass.getResource(name)).getImage();
	}

	public static Vector getImages() {
		Vector vector = new Vector();
		try {
			Class thisClass = JuzzleImages.class;
			ImageIcon ii = null;
			ImageIcon iis = null;
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(
					thisClass.getResourceAsStream("puzzleImages.txt")));
			String line = null;
			String file = null;
			String name = null;
			int sep = -1;
			while ((line = lnr.readLine()) != null) {
				sep = line.indexOf(' ');
				if (sep < 0) {
					file = line;
					name = "";
				} else {
					file = line.substring(0, sep);
					name = line.substring(sep + 1, line.length());
				}
				System.out.println(file);
				ii = new ImageIcon(thisClass.getResource(file));
				iis = scaleIcon(ii, 80);
				vector.addElement(new ImageDescription(ii, iis, name));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vector;
	}

	public static ImageIcon scaleIcon(ImageIcon ii, int imageSize) {
		int iw = ii.getIconWidth();
		int ih = ii.getIconHeight();

		int niw = 0;
		int nih = 0;

		if (iw >= ih) {
			niw = imageSize;
			nih = (int) ((double) ih * ((double) imageSize / (double) iw));
		} else {
			niw = (int) ((double) iw * ((double) imageSize / (double) ih));
			nih = imageSize;
		}

		Image image_scaled = ii.getImage().getScaledInstance(niw, nih,
				Image.SCALE_FAST);
		return new ImageIcon(image_scaled);
	}

	public static ImageIcon getIcon(String name) {
		Class thisClass = JuzzleImages.class;
		return new ImageIcon(thisClass.getResource(name));
	}
}
