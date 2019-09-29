import static javax.swing.JOptionPane.*;

class NyString{

	String tekst;

	public NyString(String innTekst){
		this.tekst = innTekst;
	}

	public void forkort(){
		String[] ord = tekst.split(" ");
		String førsteTegn = "";
		for (int i=0; i<ord.length; i++){
			førsteTegn += ord[i].charAt(0);
		}
		tekst = førsteTegn;
	}

	public void fjernTegn(char tegn){
		String fjernTegn = tekst;
		int ferdig = tekst.indexOf(tegn);
		while (ferdig != -1){
			fjernTegn = fjernTegn.substring(0,ferdig) + fjernTegn.substring(ferdig+1);
			ferdig = fjernTegn.indexOf(tegn);
		}
		tekst = fjernTegn;
	}

	public String getTekst(){
		return tekst;
	}
}

public class Oppgave8_16_1{
	public static void main (String[] args){
		String s = "";
		NyString tekst = new NyString(s);
		int valg = Integer.parseInt(showInputDialog("Velg operasjon: \n1 - Skriv inn tekst \n2 - Forkorte teksten din til første bokstav i hvert ord \n3 - Fjern alle instanser av et tegn i teksten"));

		while(true){
			System.out.println("Valgt tekst er : " + tekst.getTekst());
			switch(valg){
				case 1: s = showInputDialog(null, "Skriv inn din tekst her: ");
						tekst = new NyString(s);
						break;

				case 2: tekst.forkort();
						showMessageDialog(null,tekst.getTekst());
						break;

				case 3: String f = showInputDialog(null, "Velg hvilket tegn som skal fjernes: ");
						tekst.fjernTegn(f.charAt(0));
						showMessageDialog(null,tekst.getTekst());
						break;

				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Velg operasjon: \n1 - Skriv inn tekst \n2 - Forkorte teksten din til første bokstav i hvert ord \n3 - Fjern alle instanser av et tegn i teksten"));
		}
	}
}