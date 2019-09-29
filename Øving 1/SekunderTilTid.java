/*Oppgave 2.13.3

Skriv et program som leser inn et antall sekunder og beregner hvor mange timer, minutter og sekunder dette er. (Hint: Bruk heltallsdivisjon.) Sett opp testdatasett og prøv ut programmet.*/

import static javax.swing.JOptionPane.*;

class SekunderTilTid {
	public static void main (String[] args) {
		/*String sekunderLest = showInputDialog("Skriv inn antall sekunder:");
		int sekunder = Integer.parseInt(sekunderLest);
		int totaleTimer = sekunder/3600;
		int totaleMinutter = (sekunder % 3600)/60;
		int totaleSekunder = sekunder%60;

		showMessageDialog(null, totaleTimer + "h " + totaleMinutter + "m " + totaleSekunder + "s ");*/
		for(int i = 0; i<5; i++){
			for(int j = 0; j<=i; j++){
		 		System.out.print("*");
		 	}
		 	System.out.println();
 		}
	}
}
