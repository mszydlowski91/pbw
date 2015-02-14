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


import javax.swing.*;

/**
 *
 */
public class ImageDescription
{
 public ImageIcon imageIcon        = null;
 public ImageIcon imageIcon_scaled = null;
 public String name                = null;

 /**
  *
  */
 public ImageDescription(ImageIcon imageIcon, ImageIcon imageIcon_scaled, String name)
  {
  this.imageIcon        = imageIcon;
  this.imageIcon_scaled = imageIcon_scaled;
  this.name             = name;
  }

 public String toString()
  {
  return name;
  }
}
