import static javax.swing.JOptionPane.*;

public class Oppgave4_14_1 {
public static void main (String[] args){

	String startLest = showInputDialog("Hvor skal tabellen starte?");
	String sluttLest = showInputDialog("Hvor skal tabellen slutte?");
	int start = Integer.parseInt(startLest);
	int slutt = Integer.parseInt(sluttLest);

	for (int i = start; i <= slutt; i++) {
			System.out.println("\n" + i + "-gangen: \n");
			for (int j = 1; j <= 10; j++) {
				System.out.println( i + " x " + j + " = " + i*j + "\n");
			}
		}
	}
}

/*import static javax.swing.JOptionPane.*;

public class Oppgave4_14_1 {
public static void main (String[] args){

	String startLest = showInputDialog("Hvor skal tabellen starte?");
	String sluttLest = showInputDialog("Hvor skal tabellen slutte?");
	int start = Integer.parseInt(startLest);
	int slutt = Integer.parseInt(sluttLest);

	String ut = "";

	for (int i = start; i <= slutt; i++) {
			ut += "\n" + i + "-gangen: \n";
			for (int j = 1; j <= 10; j++) {
				ut += i + " x " + j + " = " + i*j + "\n";
			}
		}
		showMessageDialog(null, ut);
	}
}
*/
