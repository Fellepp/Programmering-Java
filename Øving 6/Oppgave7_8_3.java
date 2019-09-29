//Æ - 198, Ø - 216, Å = 197

import static javax.swing.JOptionPane.*;

class TekstAnalyse{

	String tekst = "";
	int[] antallTegn = new int[30];


	public TekstAnalyse(String innTekst){

		tekst = innTekst.toUpperCase();

		for (int i = 0; i<tekst.length(); i++){
			int verdi = tekst.charAt(i);

			if(verdi == 198)antallTegn[26]++;
			else if (verdi == 216)antallTegn[27]++;
			else if (verdi == 197)antallTegn[28]++;
			else if (verdi >= 65 && verdi <= 90)antallTegn[verdi-65]++;
			else antallTegn[29]++;
		}
	}

	public int forskjelligeBokstaver(){

		int unikeForekomster = 0;
		for(int i = 0; i<antallTegn.length-1; i++){
			if(antallTegn[i] != 0) unikeForekomster++;
		}
		return unikeForekomster;
	}

	public int antallBokstaver(){

		int antallBokstaver = 0;
		for(int i = 0; i<antallTegn.length-1; i++){
			antallBokstaver += antallTegn[i];
		}
		return antallBokstaver;
	}

	public double ikkeBokstaver(){
		double antallTegn = this.antallTegn[29];
		double antallBokstaver = antallBokstaver();
		return antallTegn/(antallBokstaver + antallTegn) * 100;
	}

	public int antallAv(String s){

		char c = s.toUpperCase().charAt(0);
		int verdi = c;

		if (verdi == 198)verdi = 26;
		else if (verdi == 216)verdi = 27;
		else if (verdi == 197)verdi = 28;
		else if (verdi >= 65 && verdi <= 90)verdi -= 65;
		else verdi = 29;

		return antallTegn[verdi];
	}

	public String flestForekomster(){
		String flestForekomster = "";
		int høyestForekomster = 0;

		for (int i = 0; i<antallTegn.length-1; i++){
			if(antallTegn[i] > høyestForekomster){
				if (i == 26)flestForekomster = "Æ";
				else if (i == 27)flestForekomster = "Ø";
				else if (i == 28)flestForekomster = "Å";
				else flestForekomster = ""+(char)(i+65);

				høyestForekomster = antallTegn[i];
			}
			else if(antallTegn[i] == høyestForekomster){
				if (i == 26)flestForekomster += "Æ";
				else if (i == 27)flestForekomster += "Ø";
				else if (i == 28)flestForekomster += "Å";
				else flestForekomster += ","+(char)(i+65);
			}
		}
		return flestForekomster;
	}
}

public class Oppgave7_8_3{
	public static void main (String[] args){

		while(true){
			String s = showInputDialog(null,"Skriv inn en tekst eller skriv  \" AVSLUTT \"  for å avslutte.");
			if (s.equals("AVSLUTT"))System.exit(0);
			String k = showInputDialog(null,"Skriv inn en bokstav du vil se antall forekomster av.");

			TekstAnalyse t = new TekstAnalyse(s);

			int a = t.forskjelligeBokstaver();
			int b = t.antallBokstaver();
			double c = t.ikkeBokstaver();
			int d = t.antallAv(k);
			String e = t.flestForekomster();

			String ut = "";

			ut += "\"" + s + "\"" + "\n\n\n";
			ut += "Det er tilsammen " + a + " forskjellige bokstaver i teksten.\n";
			ut += "Det er totalt " + b + " bokstaver i teksten.\n";
			ut += "Det er " + c + "% av teksten som består av ikke-bokstaver.\n";
			ut += "Det er totalt " + d + " forekomst(er) av " + k.toUpperCase().charAt(0) + ".\n";
			ut += "Det er flest forekomster av bokstaven(e) " + e + ".";

			showMessageDialog(null,ut);
		}
	}
}