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
public class DummyPuzzlePartList implements IPuzzlePartList
{
 /**
  *
  */
 public DummyPuzzlePartList()
  {
  }

 public int getPartsCount()
  {
  return -1;
  }
 public int getSolvedPartsCount()
  {
  return -1;
  }
 public PuzzlePartList.PuzzlePart getFirstNode()
  {
  return null;
  }
 public PuzzlePartList.PuzzlePart [] getPartArray()
  {
  return null;
  }
 public boolean isSelectedPart(PuzzlePartList.PuzzlePart part)
  {
  return false;
  }
 public boolean selectPart(Point point)
  {
  return false;
  }
 public void deselectPart() {}
 public void setRedrawRect(Rectangle repaintRect) {}
 public void moveLocation(int dx, int dy) {}
 public void updatePart() {}
}
