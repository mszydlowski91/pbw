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
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import images.*;

/**
 *
 */
public class StartDialog
{
 protected JPanel panel = null;
 protected JList list = null;

 protected JTextField x_div = null;
 protected JTextField y_div = null;

 protected Vector imagesList = null;

 /**
  *
  */
 public StartDialog()
  {
  super();

  panel = new JPanel(new BorderLayout());
  panel.setBorder(new EtchedBorder());
  panel.setPreferredSize(new Dimension(400, 400));

  JLabel caption = new JLabel("Please select a image:");
  caption.setBorder(new EmptyBorder(2, 10, 2, 2));
  panel.add(BorderLayout.NORTH, caption);

  imagesList = JuzzleImages.getImages();

  list = new JList(imagesList);
  list.setCellRenderer(new ImageListRenderer());
  JScrollPane jsp_list = new JScrollPane(list);
  jsp_list.setBorder(new CompoundBorder(new EmptyBorder(2, 10, 2, 10), new BevelBorder(BevelBorder.LOWERED)));
  panel.add(BorderLayout.CENTER, jsp_list);
  list.setSelectedIndex(0);

  JPanel sizePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
  sizePanel.add(new JLabel("Divide:"));
  sizePanel.add(x_div = new JTextField("4"));
  sizePanel.add(new JLabel("x"));
  sizePanel.add(y_div = new JTextField("4"));

  x_div.setPreferredSize(new Dimension(50, 20));
  y_div.setPreferredSize(new Dimension(50, 20));

  panel.add(BorderLayout.SOUTH, sizePanel);
  }

 public void addToImageList(ImageDescription id)
  {
  imagesList.addElement(id);
  list.setListData(imagesList);
  }

 public boolean showDialog(Component parent)
  {
  int ret = JOptionPane.showOptionDialog(parent,
                                         panel,
                                         "Please select a image",
                                         JOptionPane.OK_CANCEL_OPTION,
                                         JOptionPane.QUESTION_MESSAGE,
                                         null,
                                         null,
                                         null);
  return (ret == JOptionPane.OK_OPTION);
  }

 public ImageDescription getSelectedImage()
  {
  return (ImageDescription)list.getSelectedValue();
  }

 public Dimension getSelectedDivision()
  {
  int dx = 2;
  int dy = 2;
  try
     {
     dx = Integer.parseInt(x_div.getText());
     dy = Integer.parseInt(x_div.getText());

     if(dx < 2) dx = 2;
     if(dy < 2) dy = 2;
     }
  catch(Exception e) {}

  return new Dimension(dx, dy);
  }

 private class ImageListRenderer implements ListCellRenderer
 {
  protected JLabel text  = null;
  protected JLabel image = null;
  protected JPanel jpanel = null;

  protected Border selBorder  = new LineBorder(new Color(128, 0, 0), 5);
  protected Border normBorder = new EmptyBorder(5, 5, 5, 5);

//  protected Color selColor  = new Color(204, 204, 255);
  protected Color selColor  = new Color(255, 255, 204);
  protected Color normColor = Color.white;

  public ImageListRenderer()
   {
   text = new JLabel();
   text.setOpaque(false);
   text.setBorder(new EmptyBorder(2, 10, 2, 2));
   image = new JLabel();
   image.setHorizontalAlignment(JLabel.CENTER);
   image.setOpaque(false);
   image.setBorder(new EmptyBorder(5, 5, 5, 5));
   image.setPreferredSize(new Dimension(100, 0));

   jpanel = new JPanel(new BorderLayout());
   jpanel.setBackground(normColor);
   jpanel.setBorder(normBorder);

   jpanel.add(BorderLayout.WEST, image);
   jpanel.add(BorderLayout.CENTER, text);
   jpanel.setPreferredSize(new Dimension(0, 100));
   }

  public Component getListCellRendererComponent(JList jlist,
                                                Object value,
                                                int index,
                                                boolean isSelected,
                                                boolean cellHasFocus)
   {
   if(isSelected)   jpanel.setBackground(selColor);
   else             jpanel.setBackground(normColor);
   if(cellHasFocus) jpanel.setBorder(selBorder);
   else             jpanel.setBorder(normBorder);
/*
   if(isSelected && cellHasFocus)
     jpanel.setPreferredSize(new Dimension(0, 120));
   else
     jpanel.setPreferredSize(new Dimension(0, 70));
*/
   ImageDescription id = (ImageDescription)value;
   image.setIcon(id.imageIcon_scaled);
   text.setText(id.name + " (" + id.imageIcon.getIconWidth() + "x" + id.imageIcon.getIconHeight() + " Pixel)");

   return jpanel;
   }
 }
}
