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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 */
public class PuzzlePartList implements IPuzzlePartList {
	protected BufferedImage bimage = null;

	protected int imageWidth = -1;
	protected int imageHeight = -1;

	// list
	protected PuzzlePartList.PuzzlePart first, last = null;

	// arrray
	protected PuzzlePartList.PuzzlePart pz_array[] = null;

	protected int puzzleCount = 1;

	protected PuzzlePartList.PuzzlePart dragPart = null;
	protected PuzzlePartList.PuzzlePart dragGroup = null;
	static int id = 1;
	
	public int[] diodeArray = {1, 2, 5, 6, 9, 10, 13, 14}; 
	public int[] microProcArray = {7, 11};
	public int[] powerArray = {8, 12};
	public int diodeCount = 0;
	public int microCount = 0;
	public int powerCount = 0;
	public boolean diodeFlag = true;
	public boolean microFlag = true;
	public boolean powerFlag = true;
	
	
	/**
  *
  */
	public PuzzlePartList(BufferedImage bimage, int x_parts, int y_parts,
			Dimension random_size) {
		super();

		this.bimage = bimage;

		imageWidth = bimage.getWidth();
		imageHeight = bimage.getHeight();

		Random random = new Random();

		int partWidth = imageWidth / x_parts;
		int partHeight = imageHeight / y_parts;
		int lastPartWidth = imageWidth - partWidth * (x_parts - 1);
		int lastPartHeight = imageHeight - partHeight * (y_parts - 1);
		int currentImageWidth = 0;
		int currentImageHeight = 0;
		int i, j, k;

		int random_max_x = random_size.width - partWidth - 60;
		int random_max_y = random_size.height - partHeight - 60;

		pz_array = new PuzzlePartList.PuzzlePart[x_parts * y_parts];

		PuzzlePartList.PuzzlePart node = null;
		PuzzlePartList.PuzzlePart node_prev = null;
		for (j = k = 0; j < y_parts; j++) {
			if (j == y_parts - 1)
				currentImageHeight = lastPartHeight;
			else
				currentImageHeight = partHeight;

			for (i = 0; i < x_parts; i++, k++) {
				if (i == x_parts - 1)
					currentImageWidth = lastPartWidth;
				else
					currentImageWidth = partWidth;

				// node = new PuzzlePart(i*iw + /*i*10 +*/ 10, j*ih + /*j*10 +*/
				// 10, i*iw, j*ih, iw, ih);
				// node = new PuzzlePart(random.nextInt(780)+10,
				// random.nextInt(780)+10, 0, 0, iw, ih);
				node = new PuzzlePartList.PuzzlePart(id, bimage,
						random.nextInt(random_max_x) + 30,
						random.nextInt(random_max_y) + 30, i * partWidth, j
								* partHeight, currentImageWidth,
						currentImageHeight);
				id++;
				pz_array[k] = node;

				if (j > 0) {
					node.north = pz_array[k - x_parts];
					pz_array[k - x_parts].south = node;
				}

				if (i > 0) {
					node.west = pz_array[k - 1];
					pz_array[k - 1].east = node;
				}

				if (node_prev == null) {
					first = node;
				} else {
					node_prev.next = node;
					node.prev = node_prev;
				}

				node_prev = node;
			}
		}

		last = node;

		Rectangle destDraw = null;
		Shape drawShape = null;
		AffineTransform at = null;
		for (i = 0; i < pz_array.length; i++) {
			node = pz_array[i];

			destDraw = new Rectangle(node.boundsIn.x, node.boundsIn.y,
					node.boundsIn.width, node.boundsIn.height);
			drawShape = destDraw;

			at = new AffineTransform();
			at.translate(node.boundsIn.x, node.boundsIn.y);

			if (node.west != null) {
				Area area = new Area(drawShape);
				GeneralPath gp = new GeneralPath();

				float ys = (float) (destDraw.height / 2.0 - 5.0);
				float ys2 = ys - 5;
				float center = ys + 5;
				float yf = (float) (destDraw.height / 2.0 + 5.0);
				float yf2 = yf + 5;

				gp.moveTo(0, ys);
				gp.curveTo(-6, ys, -6, ys2, -13, ys2);
				gp.curveTo(-16, ys2, -20, ys, -20, center);
				gp.curveTo(-20, yf, -16, yf2, -13, yf2);
				gp.curveTo(-6, yf2, -6, yf, 0, yf);

				gp.transform(at);

				area.add(new Area(gp));
				drawShape = area;

				node.boundsImage.translate(-20, 0);
				node.boundsImage.width += 20;
			}

			if (node.east != null) {
				Area area = new Area(drawShape);
				GeneralPath gp = new GeneralPath();

				float ys = (float) (destDraw.height / 2.0 - 5.0);
				float ys2 = ys - 5;
				float center = ys + 5;
				float yf = (float) (destDraw.height / 2.0 + 5.0);
				float yf2 = yf + 5;

				float x = destDraw.width;

				gp.moveTo(x, ys);
				gp.curveTo(x - 6, ys, x - 6, ys2, x - 13, ys2);
				gp.curveTo(x - 16, ys2, x - 20, ys, x - 20, center);
				gp.curveTo(x - 20, yf, x - 16, yf2, x - 13, yf2);
				gp.curveTo(x - 6, yf2, x - 6, yf, x, yf);

				gp.transform(at);

				area.subtract(new Area(gp));
				drawShape = area;
			}

			if (node.north != null) {
				Area area = new Area(drawShape);
				GeneralPath gp = new GeneralPath();

				float xs = (float) (destDraw.width / 2.0 - 5.0);
				float xs2 = xs - 5;
				float center = xs + 5;
				float xf = (float) (destDraw.width / 2.0 + 5.0);
				float xf2 = xf + 5;

				gp.moveTo(xs, 0);
				gp.curveTo(xs, -6, xs2, -6, xs2, -13);
				gp.curveTo(xs2, -16, xs, -20, center, -20);
				gp.curveTo(xf, -20, xf2, -16, xf2, -13);
				gp.curveTo(xf2, -6, xf, -6, xf, 0);

				gp.transform(at);

				area.add(new Area(gp));
				drawShape = area;

				node.boundsImage.translate(0, -20);
				node.boundsImage.height += 20;
			}

			if (node.south != null) {
				Area area = new Area(drawShape);
				GeneralPath gp = new GeneralPath();

				float xs = (float) (destDraw.width / 2.0 - 5.0);
				float xs2 = xs - 5;
				float center = xs + 5;
				float xf = (float) (destDraw.width / 2.0 + 5.0);
				float xf2 = xf + 5;

				float y = destDraw.height;

				gp.moveTo(xs, y);
				gp.curveTo(xs, y - 6, xs2, y - 6, xs2, y - 13);
				gp.curveTo(xs2, y - 16, xs, y - 20, center, y - 20);
				gp.curveTo(xf, y - 20, xf2, y - 16, xf2, y - 13);
				gp.curveTo(xf2, y - 6, xf, y - 6, xf, y);

				gp.transform(at);

				area.subtract(new Area(gp));
				drawShape = area;
			}

			node.generalPath = new GeneralPath(drawShape);
			node.boundsOut = new Rectangle(node.generalPath.getBounds());
			node.shapeBounds = new Rectangle(node.generalPath.getBounds());
			// System.out.println(node.boundsIn);
			// System.out.println(node.shapeBounds);
			node.updateLocationOut();
			node.puzzlePaint.setViewRect(node.boundsImage);
			// System.out.println(node.locationIn);
			// System.out.println(node.locationOut);
			// czyli to idzie rzedami i kolumnami normalnie
			for(int d = 0; d < pz_array.length; d++) System.out.println(pz_array[d]);
		}
	}

	public int getPartsCount() {
		return pz_array.length;
	}

	public int getSolvedPartsCount() {
		return puzzleCount;
	}

	public PuzzlePartList.PuzzlePart getFirstNode() {
		return first;
	}

	public PuzzlePartList.PuzzlePart[] getPartArray() {
		return pz_array;
	}

	public boolean isSelectedPart(PuzzlePartList.PuzzlePart part) {
		return (dragGroup == part);
	}

	public boolean selectPart(Point point) {
		Rectangle target = new Rectangle();

		PuzzlePartList.PuzzlePart nodeGroup = null, nodeGroupPrev = null;
		PuzzlePartList.PuzzlePart bestHitGroup = null, bestHitGroupPrev = null;

		PuzzlePartList.PuzzlePart node = null, nodePrev = null;
		PuzzlePartList.PuzzlePart bestHit = null, bestHitPrev = null;

		nodeGroup = first;
		while (nodeGroup != null) {
			nodePrev = null;
			node = nodeGroup;
			while (node != null) {
				target.setFrame(node.locationIn, node.boundsIn.getSize());
				if (target.contains(point)) {
					bestHitPrev = nodePrev;
					bestHit = node;

					bestHitGroupPrev = nodeGroupPrev;
					bestHitGroup = nodeGroup;
				}

				nodePrev = node;
				node = node.nextInGroup;
			}

			nodeGroupPrev = nodeGroup;
			nodeGroup = nodeGroup.next;
		}

		if (bestHitGroup != null) {
			nodeGroup = bestHitGroup;

			if (nodeGroup != last) {
				if (nodeGroup.prev != null) {
					nodeGroup.prev.next = nodeGroup.next;
					nodeGroup.next.prev = nodeGroup.prev;
				} else {
					first = nodeGroup.next;
					nodeGroup.next.prev = null;
				}
				nodeGroup.next = null;
				nodeGroup.prev = last;
				last.next = nodeGroup;
				last = nodeGroup;
			}

			dragPart = bestHit;
			dragGroup = nodeGroup;

			return true;
		}

		return false;
	}

	public boolean selectPart__(Point point) {
		Rectangle target = new Rectangle();
		PuzzlePartList.PuzzlePart node = null, prevNode = null, bestHit = null, bestHitPrev = null;

		for (int i = 0; i < pz_array.length; i++) {
			node = pz_array[i];
			target.setFrame(node.locationIn, node.boundsIn.getSize());
			if (target.contains(point)) {
				bestHitPrev = prevNode;
				bestHit = node;
			}
		}

		if (bestHit != null) {
			node = bestHit;

			if (node != last) {
				if (bestHitPrev != null) {
					bestHitPrev.next = node.next;
					node.next = null;
					last.next = node;
					last = node;
				} else {
					first = node.next;
					node.next = null;
					last.next = node;
					last = node;
				}
			}

			dragPart = node;
			return true;
		}

		return false;
	}

	public void deselectPart() {
		dragPart = null;
		dragGroup = null;
	}

	public void setRedrawRect(Rectangle repaintRect) {
		if (dragGroup == null)
			repaintRect.setRect(0, 0, 0, 0);
		else
			repaintRect
					.setRect(
							dragGroup.locationOut.x
									- (dragGroup.boundsOut.x - dragGroup.shapeBounds.x),
							dragGroup.locationOut.y
									- (dragGroup.boundsOut.y - dragGroup.shapeBounds.y),
							dragGroup.shapeBounds.width,
							dragGroup.shapeBounds.height);
		// System.out.println(repaintRect);
		// System.out.println(dragGroup.locationIn.x + ":" +
		// dragGroup.locationOut.x + ":" + dragGroup.boundsOut.x + ":" +
		// dragGroup.shapeBounds.x);
	}

	public void moveLocation(int dx, int dy) {
		moveLocationGroup(dragGroup, dx, dy);
	}

	protected void moveLocationGroup(PuzzlePartList.PuzzlePart group, int dx,
			int dy) {
		PuzzlePartList.PuzzlePart node = group;
		while (node != null) {
			node.locationIn.setLocation(node.locationIn.x + dx,
					node.locationIn.y + dy);
			node.updateLocationOut();
			node = node.nextInGroup;
		}
	}

	public void updatePart() {
		PuzzlePartList.PuzzlePart node = dragGroup;
		while (node != null) {
			if (((node.lock & PuzzlePartList.PuzzlePart.WEST) != PuzzlePartList.PuzzlePart.WEST)
					&& node.west != null) {
				if ((node.locationIn.x >= (node.west.locationIn.x
						+ node.west.boundsIn.width - 5) && node.locationIn.x <= (node.west.locationIn.x
						+ node.west.boundsIn.width + 5))
						&& (node.locationIn.y >= (node.west.locationIn.y - 5) && node.locationIn.y <= (node.west.locationIn.y + 5))) {
					moveLocationGroup(
							dragGroup,
							-(node.locationIn.x - (node.west.locationIn.x + node.west.boundsIn.width)),
							-(node.locationIn.y - node.west.locationIn.y));

					node.lock |= PuzzlePartList.PuzzlePart.WEST;
					node.west.lock |= PuzzlePartList.PuzzlePart.EAST;

					updateGroup(dragGroup, node, node.west);
				}
			}

			if (((node.lock & PuzzlePartList.PuzzlePart.EAST) != PuzzlePartList.PuzzlePart.EAST)
					&& node.east != null) {
				if ((node.locationIn.x + node.boundsIn.width >= (node.east.locationIn.x - 5) && node.locationIn.x
						+ node.boundsIn.width <= (node.east.locationIn.x + 5))
						&& (node.locationIn.y >= (node.east.locationIn.y - 5) && node.locationIn.y <= (node.east.locationIn.y + 5))) {
					moveLocationGroup(
							dragGroup,
							-(node.locationIn.x - (node.east.locationIn.x - node.boundsIn.width)),
							-(node.locationIn.y - node.east.locationIn.y));

					node.lock |= PuzzlePartList.PuzzlePart.EAST;
					node.east.lock |= PuzzlePartList.PuzzlePart.WEST;

					updateGroup(dragGroup, node, node.east);
				}
			}

			if (((node.lock & PuzzlePartList.PuzzlePart.NORTH) != PuzzlePartList.PuzzlePart.NORTH)
					&& node.north != null) {
				if ((node.locationIn.y >= (node.north.locationIn.y
						+ node.north.boundsIn.height - 5) && node.locationIn.y <= (node.north.locationIn.y
						+ node.north.boundsIn.height + 5))
						&& (node.locationIn.x >= (node.north.locationIn.x - 5) && node.locationIn.x <= (node.north.locationIn.x + 5))) {
					moveLocationGroup(
							dragGroup,
							-(node.locationIn.x - node.north.locationIn.x),
							-(node.locationIn.y - (node.north.locationIn.y + node.north.boundsIn.height)));

					node.lock |= PuzzlePartList.PuzzlePart.NORTH;
					node.north.lock |= PuzzlePartList.PuzzlePart.SOUTH;

					updateGroup(dragGroup, node, node.north);
				}
			}

			if (((node.lock & PuzzlePartList.PuzzlePart.SOUTH) != PuzzlePartList.PuzzlePart.SOUTH)
					&& node.south != null) {
				if ((node.locationIn.y + node.boundsIn.height >= (node.south.locationIn.y - 5) && node.locationIn.y
						+ node.boundsIn.height <= (node.south.locationIn.y + 5))
						&& (node.locationIn.x >= (node.south.locationIn.x - 5) && node.locationIn.x <= (node.south.locationIn.x + 5))) {
					moveLocationGroup(
							dragGroup,
							-(node.locationIn.x - node.south.locationIn.x),
							-(node.locationIn.y - (node.south.locationIn.y - node.boundsIn.height)));

					node.lock |= PuzzlePartList.PuzzlePart.SOUTH;
					node.south.lock |= PuzzlePartList.PuzzlePart.NORTH;

					updateGroup(dragGroup, node, node.south);
				}
			}
			node = node.nextInGroup;
		}
	}

	protected void updateGroup(PuzzlePartList.PuzzlePart dragGroup,
			PuzzlePartList.PuzzlePart node, PuzzlePartList.PuzzlePart node2) {
		PuzzlePartList.PuzzlePart lastNodeOfGroup = null;
		PuzzlePartList.PuzzlePart firstNodeOfOtherGroup = null;

		firstNodeOfOtherGroup = node2;
		while (firstNodeOfOtherGroup.prevInGroup != null)
			firstNodeOfOtherGroup = firstNodeOfOtherGroup.prevInGroup;

		if (dragGroup == firstNodeOfOtherGroup)
			return;

		lastNodeOfGroup = dragGroup;
		while (lastNodeOfGroup.nextInGroup != null)
			lastNodeOfGroup = lastNodeOfGroup.nextInGroup;

		lastNodeOfGroup.nextInGroup = firstNodeOfOtherGroup;
		firstNodeOfOtherGroup.prevInGroup = lastNodeOfGroup;

		if (firstNodeOfOtherGroup.prev != null)
			firstNodeOfOtherGroup.prev.next = firstNodeOfOtherGroup.next;
		else
			first = firstNodeOfOtherGroup.next;

		if (firstNodeOfOtherGroup.next != null)
			firstNodeOfOtherGroup.next.prev = firstNodeOfOtherGroup.prev;
		else
			last = firstNodeOfOtherGroup.prev;

		firstNodeOfOtherGroup.prev = firstNodeOfOtherGroup.next = null;

		dragGroup.generalPath.append(firstNodeOfOtherGroup.generalPath, false);
		dragGroup.shapeBounds = new Rectangle(dragGroup.generalPath.getBounds());
		dragGroup.boundsImage.add(firstNodeOfOtherGroup.boundsImage);
		dragGroup.puzzlePaint.setViewRect(dragGroup.boundsImage);

		// dragGroup.partsInGroup += firstNodeOfOtherGroup.partsInGroup;
		if (puzzleCount == 0)
			puzzleCount += 1;
		puzzleCount += 1;
		
		
		if(ArrayUtils.contains(diodeArray, node.id) && diodeFlag){
			diodeCount++;			
		}
		else if(ArrayUtils.contains(microProcArray, node.id) && microFlag){
			microCount++;
		}
		else if(ArrayUtils.contains(powerArray, node.id) && powerFlag){
			powerCount++;
		}
		if(diodeCount == 7)
		{	
			System.out.println("Diodes joined");
			diodeCount = 0;						
			diodeFlag = false;			
		}
		if(microCount == 1)
		{	
			System.out.println("Micro joined");
			microCount = 0;						
			microFlag = false;			
		}
		if(powerCount == 1)
		{	
			System.out.println("Power joined");
			powerCount = 0;						
			powerFlag = false;			
		}
		
		System.out.println("diode parts:" + diodeCount);
		System.out.println("micro parts:" + microCount);
		System.out.println("power parts:" + powerCount);
	
		System.out.println("Node:"+node.id);
		
		
	}
	
	public boolean contains(final int[] array, final int key) {  
	     Arrays.sort(array);  
	     return Arrays.binarySearch(array, key) != -1;  
	}  

	public static class PuzzlePart {
		public static final int WEST = 0x01;
		public static final int EAST = 0x02;
		public static final int NORTH = 0x04;
		public static final int SOUTH = 0x08;
		
		public int id = 0;

		public Point locationIn = new Point();
		public Point locationOut = new Point();
		public Rectangle boundsIn = new Rectangle();
		public Rectangle boundsOut = new Rectangle();
		public Rectangle boundsImage = new Rectangle();
		public GeneralPath generalPath = null;
		public Rectangle shapeBounds = new Rectangle();
		public PuzzlePaint puzzlePaint = null;

		public PuzzlePart next = null;
		public PuzzlePart prev = null;
		public PuzzlePart nextInGroup = null;
		public PuzzlePart prevInGroup = null;

		public PuzzlePart north = null;
		public PuzzlePart south = null;
		public PuzzlePart west = null;
		public PuzzlePart east = null;

		public int lock = 0;

		// public int partsInGroup = 1;

		public PuzzlePart(int id, BufferedImage bimage, int lx, int ly, int pix,
				int piy, int width, int height) {
			locationIn.setLocation(lx, ly);
			boundsImage.setRect(pix, piy, width, height);
			boundsIn.setRect(pix, piy, width, height);
			puzzlePaint = new PuzzlePaint(bimage, boundsImage);
			this.id = id;
		}

		public void updateLocationOut() {
			locationOut.setLocation(locationIn.x - (boundsIn.x - boundsOut.x),
					locationIn.y - (boundsIn.y - boundsOut.y));
		}

		public String toString() {
			return "PuzzlePart[id: " + id + "; location: " + locationIn.x + ", " + locationIn.y
					+ "; rect: " + boundsIn.x + ", " + boundsIn.y + ", "
					+ boundsIn.width + ", " + boundsIn.height + "]";
		}
	}
}
