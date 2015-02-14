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

/**
 *
 */
public interface IPuzzlePartList {
	public int getPartsCount();

	public int getSolvedPartsCount();

	public PuzzlePartList.PuzzlePart getFirstNode();

	public PuzzlePartList.PuzzlePart[] getPartArray();

	public boolean isSelectedPart(PuzzlePartList.PuzzlePart part);

	public boolean selectPart(Point point);

	public void deselectPart();

	public void setRedrawRect(Rectangle repaintRect);

	public void moveLocation(int dx, int dy);

	public void updatePart();
}
