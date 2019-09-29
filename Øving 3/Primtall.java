import static javax.swing.JOptionPane.*;
import java.util.*;

public class Primtall {

public static void main(String[] args)
{
    		 int n = JOptionPane.showConfirmDialog
    		 (null, "Would you like green eggs and ham?",
    		 "An Inane Question",
    		 JOptionPane.YES_NO_OPTION);
    		 if(n == JOptionPane.YES_OPTION)
			 {
			     JOptionPane.showMessageDialog(null, "HELLO");
			 }
			 else
			 {
			     JOptionPane.showMessageDialog(null, "GOODBYE");
}
}
}