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
import java.awt.geom.*;
import java.awt.image.*;

/**
 *
 */
public class PuzzlePaint implements Paint, PaintContext {
	protected BufferedImage bimage = null;
	protected Rectangle viewRect = new Rectangle();
	protected Rectangle userBounds = new Rectangle();

	/**
  *
  */
	public PuzzlePaint(BufferedImage textur, Rectangle viewRect) {
		this.bimage = textur;
		this.viewRect.setRect(viewRect);
	}

	public void setViewRect(Rectangle viewRect) {
		this.viewRect.setRect(viewRect);
	}

	public PaintContext createContext(ColorModel cm, Rectangle deviceBounds,
			Rectangle2D userBounds, AffineTransform xform, RenderingHints hints) {
		// if(deviceBounds.equals(userBounds))
		// {
		// System.out.println("deviceBounds: " + deviceBounds);
		// System.out.println("userBounds:   " + userBounds);
		// }
		this.userBounds.setRect(deviceBounds);
		return this;
	}

	public int getTransparency() {
		return OPAQUE;
	}

	public void dispose() {
	}

	public ColorModel getColorModel() {
		return bimage.getColorModel();
	}

	public Raster getRaster(int x, int y, int w, int h) {
		int x2 = x - userBounds.x + viewRect.x;
		int y2 = y - userBounds.y + viewRect.y;
		// if((x2) < 0) x2 = 0;
		// if((y2) < 0) y2 = 0;
		// if((x2 + w) > bimage.getWidth()) x2 = 0;
		// if((y2 + h) > bimage.getHeight()) y2 = 0;
		return bimage.getRaster().createChild(x2, y2, w, h, 0, 0, null);
	}
}
