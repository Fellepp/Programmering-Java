//Bl� smily med gul bakgrunn
import java.lang.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Bl�Smiley extends Frame {

  public void paint(Graphics g) {
	 setBackground(Color.yellow);
     Graphics2D ga = (Graphics2D)g;
     ga.setPaint(Color.blue);
     ga.drawOval(150,150,100,100);
     ga.fillOval(150,150,100,100);
  }

  public static void main(String args[])
  {
      Bl�Smiley frame = new Bl�Smiley();
      frame.addWindowListener(
      new WindowAdapter()
      {
         public void windowClosing(WindowEvent we)
         {
            System.exit(0);
         }
      }
      );

      frame.setSize(400, 400);
      frame.setVisible(true);
   }
}