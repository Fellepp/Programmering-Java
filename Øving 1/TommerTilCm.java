/*Oppgave 2.13.1

Skriv et program som regner om fra tommer til centimeter. En tomme er 2,54 centimeter.

Sett opp testdatasett og prøv ut programmet.
*/

import static javax.swing.JOptionPane.*;
class TommerTilCm{
	public static void main (String[] args) {
		String tommerLest = showInputDialog("Antall tommer:");
		double tommer = Double.parseDouble(tommerLest);
		double cm = 2.54 * tommer;
		showMessageDialog(null, tommer + " tomme(r) er det samme som " + cm + " cm.");
}
}