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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 */
public class PuzzlePanel extends JPanel implements MouseListener,
		MouseMotionListener {
	protected static final int PAINT_EXTEND = 2;
	protected static final int PAINT_SHADOW = 10;
	protected static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
	protected static final Cursor CURSOR_DEFAULT = new Cursor(
			Cursor.DEFAULT_CURSOR);
	protected static final Color outlineColor = new Color(0, 0, 0, 128);
	protected static final Color shadowColor = new Color(0, 0, 0, 128);

	protected BufferedImage bimage = null;
	protected int x_parts = 0;
	protected int y_parts = 0;

	protected ControlPanel controlPanel = null;

	protected boolean dragModus1, dragModus2 = false;
	protected Point lastDragLocation = new Point();
	protected Rectangle repaintRect1 = new Rectangle();
	protected Rectangle repaintRect2 = new Rectangle();
	protected boolean endMessagePrinted = false;

	protected IPuzzlePartList puzzlePartList = null;

	protected boolean antialiasing = true;
	protected boolean outline = true;
	protected boolean shadow = true;

	/**
  *
  */
	public PuzzlePanel(ControlPanel controlPanel) {
		super(null);

		this.controlPanel = controlPanel;

		setOpaque(false);

		addMouseListener(this);
		addMouseMotionListener(this);

		// setPreferredSize(new Dimension(2000, 2000));

		emptyGame();
	}

	public void resetGame() {
		if (bimage != null) {
			emptyGame();
			puzzlePartList = new PuzzlePartList(bimage, x_parts, y_parts,
					getSize());

			controlPanel.printPieces("" + puzzlePartList.getPartsCount());
			controlPanel.printSolved("0");
			controlPanel.startCounter();
			repaint();
		}
	}

	public void emptyGame() {
		dragModus1 = dragModus2 = false;
		lastDragLocation = new Point();
		repaintRect1 = new Rectangle();
		repaintRect2 = new Rectangle();
		puzzlePartList = new DummyPuzzlePartList();
		endMessagePrinted = false;

		controlPanel.printPieces("");
		controlPanel.printSolved("");
		controlPanel.printTime("");

		repaint();
	}

	public void setGame(BufferedImage bimage, int x_parts, int y_parts) {
		emptyGame();

		this.bimage = bimage;
		this.x_parts = x_parts;
		this.y_parts = y_parts;

		puzzlePartList = new PuzzlePartList(bimage, x_parts, y_parts, getSize());
		controlPanel.printPieces("" + puzzlePartList.getPartsCount());
		controlPanel.printSolved("0");
		controlPanel.startCounter();

		repaint();
	}

	public void setAntialiasing(boolean b) {
		antialiasing = b;
		repaint();
	}

	public void setOutline(boolean b) {
		outline = b;
		repaint();
	}

	public void setShadow(boolean b) {
		shadow = b;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		if (antialiasing)
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

		PuzzlePartList.PuzzlePart part = puzzlePartList.getFirstNode();

		int tx, ty;

		g2.setStroke(new BasicStroke(3));

		while (part != null) {
			// g2.setColor(Color.black);
			// g2.fillOval(part.locationIn.x-5, part.locationIn.y-5, 10, 10);
			// g2.setColor(Color.black);
			// g2.drawOval(part.locationOut.x-5, part.locationOut.y-5, 10, 10);

			tx = part.locationIn.x - part.boundsIn.x;
			ty = part.locationIn.y - part.boundsIn.y;

			g2.translate(tx, ty);

			// PuzzlePaint pp = new PuzzlePaint(bimage, part.boundsImage);

			if (shadow && puzzlePartList.isSelectedPart(part)) {
				g2.translate(PAINT_SHADOW, PAINT_SHADOW);
				g2.setPaint(shadowColor);
				g2.fill(part.generalPath);
				g2.translate(-PAINT_SHADOW, -PAINT_SHADOW);
			}

			// g2.setPaint(pp);
			g2.setPaint(part.puzzlePaint);
			g2.fill(part.generalPath);

			if (outline) {
				g2.setColor(outlineColor);
				g2.draw(part.generalPath);
			}

			// g2.setStroke(new BasicStroke(1));
			// g2.setColor(Color.blue);
			// g2.draw(part.boundsIn);

			// g2.setStroke(new BasicStroke(1));
			// g2.setColor(Color.black);
			// g2.draw(s.getBounds());

			g2.translate(-tx, -ty);

			part = part.next;
		}

		if (((PuzzlePartList) puzzlePartList).microFlag == false) {
			drawBubble(g2, 2);
		}

		// g2.setStroke(new BasicStroke(1));
		// g2.setColor(Color.red);
		// g2.draw(repaintRect1);
		// g2.setColor(Color.green);
		// g2.draw(repaintRect2);
	}

	public void drawBubble(Graphics2D g2, int type) {
		int width = 250;
		int height = 350;
		int x0 = 0;
		int y0 = 0;
		GeneralPath path = new GeneralPath();
		if (type == 1) {
			x0 = 300;
			y0 = 300;
			g2.setColor(Color.YELLOW);
		} else if (type == 2) {
			x0 = 800;
			y0 = 400;
			g2.setColor(Color.CYAN);
		} else if (type == 3) {
			x0 = 700;
			y0 = 300;
			g2.setColor(Color.ORANGE);
		}
		path.moveTo(x0 + 5, y0 + 10);
		path.curveTo(x0 + 5, y0 + 10, x0 + 7, y0 + 5, x0 + 0, y0 + 0);
		path.curveTo(x0 + 0, y0 + 0, x0 + 12, y0 + 0, x0 + 12, y0 + 5);
		path.curveTo(x0 + 12, y0 + 5, x0 + 12, y0 + 0, x0 + 20, y0 + 0);
		path.lineTo(x0 + width - 10, y0 + 0);
		path.curveTo(x0 + width - 10, y0 + 0, x0 + width, y0 + 0, x0 + width,
				y0 + 10);
		path.lineTo(x0 + width, y0 + height - 10);
		path.curveTo(x0 + width, y0 + height - 10, x0 + width, y0 + height, x0
				+ width - 10, y0 + height);
		path.lineTo(x0 + 15, y0 + height);
		path.curveTo(x0 + 15, y0 + height, x0 + 5, y0 + height, x0 + 5, y0
				+ height - 10);
		path.lineTo(x0 + 5, y0 + 15);
		path.closePath();

		

		g2.fill(path);
		ImageIcon image = new ImageIcon(this.getClass()
				.getResource("brain.jpg"));
		image.paintIcon(this, g2, x0, y0);
	}

	protected void startDragging(MouseEvent e) {
		if (puzzlePartList.selectPart(e.getPoint())) {
			setCursor(CURSOR_HAND);
			lastDragLocation.setLocation(e.getPoint());
			dragModus1 = true;
			mouseMoved(e);
		}
	}

	protected void stopDragging(MouseEvent e) {
		puzzlePartList.setRedrawRect(repaintRect1);
		puzzlePartList.updatePart();
		puzzlePartList.setRedrawRect(repaintRect2);

		puzzlePartList.deselectPart();

		// repaint();

		if (repaintRect1.intersects(repaintRect2)) {
			repaintRect1.add(repaintRect2);
			repaint(repaintRect1.x - PAINT_EXTEND, repaintRect1.y
					- PAINT_EXTEND, repaintRect1.width + PAINT_SHADOW
					+ PAINT_EXTEND + PAINT_EXTEND, repaintRect1.height
					+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
		} else {
			repaint(repaintRect1.x - PAINT_EXTEND, repaintRect1.y
					- PAINT_EXTEND, repaintRect1.width + PAINT_SHADOW
					+ PAINT_EXTEND + PAINT_EXTEND, repaintRect1.height
					+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
			repaint(repaintRect2.x - PAINT_EXTEND, repaintRect2.y
					- PAINT_EXTEND, repaintRect2.width + PAINT_SHADOW
					+ PAINT_EXTEND + PAINT_EXTEND, repaintRect2.height
					+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
		}

		controlPanel.printSolved("" + puzzlePartList.getSolvedPartsCount());

		dragModus1 = false;
		setCursor(CURSOR_DEFAULT);

		if (!endMessagePrinted
				&& puzzlePartList.getSolvedPartsCount() >= puzzlePartList
						.getPartsCount()) {
			controlPanel.stopCounter();
			JOptionPane.showMessageDialog(
					this,
					"Congratulation! You solved the puzzle in "
							+ controlPanel.getGameTime() + ".");
			endMessagePrinted = true;
		}
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		if (dragModus1 == false) {
			startDragging(e);
		} else {
			stopDragging(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (!dragModus2 && !dragModus1) {
			dragModus2 = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (dragModus2 && !dragModus1) {
			dragModus2 = false;
		} else if (dragModus2 && dragModus1) {
			dragModus2 = false;
			stopDragging(e);
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (dragModus2 && !dragModus1) {
			dragModus1 = true;
			startDragging(e);
		}
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		if (dragModus1) {
			Point point = e.getPoint();

			int dx = point.x - lastDragLocation.x;
			int dy = point.y - lastDragLocation.y;

			puzzlePartList.setRedrawRect(repaintRect1);
			puzzlePartList.moveLocation(dx, dy);
			puzzlePartList.setRedrawRect(repaintRect2);

			// repaint();

			if (repaintRect1.intersects(repaintRect2)) {
				repaintRect1.add(repaintRect2);
				repaint(repaintRect1.x - PAINT_EXTEND, repaintRect1.y
						- PAINT_EXTEND, repaintRect1.width + PAINT_SHADOW
						+ PAINT_EXTEND + PAINT_EXTEND, repaintRect1.height
						+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
			} else {
				repaint(repaintRect1.x - PAINT_EXTEND, repaintRect1.y
						- PAINT_EXTEND, repaintRect1.width + PAINT_SHADOW
						+ PAINT_EXTEND + PAINT_EXTEND, repaintRect1.height
						+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
				repaint(repaintRect2.x - PAINT_EXTEND, repaintRect2.y
						- PAINT_EXTEND, repaintRect2.width + PAINT_SHADOW
						+ PAINT_EXTEND + PAINT_EXTEND, repaintRect2.height
						+ PAINT_SHADOW + PAINT_EXTEND + PAINT_EXTEND);
			}

			lastDragLocation.setLocation(point);
		}
	}
}
