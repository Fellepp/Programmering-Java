import static java.lang.Integer.*;
import static java.lang.System.*;
import static javax.swing.JOptionPane.*;

public class Gangetabell {

  public static void main ( String [] args ) {

    for(int x=1; x <=10; x++) {
      for (int y=1; y <=10; y++) {
        out.print(x*y + " ");
      }
      out.println();
    }
  }

}