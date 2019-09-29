/*Oppgave 2.13.2

Skriv et program som regner om timer, minutter og sekunder til totalt antall sekunder. Sett opp testdatasett og prøv ut programmet.*/

import java.util.*;

public class TidTilSekunder{
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);


		int timer;
		int minutter;
		int sekunder;

		System.out.println("Antall Timer: ");
		timer=console.nextInt();

		System.out.println("Antall Minutter: ");
		minutter=console.nextInt();

		System.out.println("Antall Sekunder: ");
		sekunder=console.nextInt();

		int TotaleSekunder = (timer * 3600) + (minutter * 60) + sekunder;

		System.out.println(timer + "t, " + minutter + " min og " + sekunder + " sek er det samme som " + TotaleSekunder + " sekunder.");

}
}



