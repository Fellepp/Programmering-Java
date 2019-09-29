import static javax.swing.JOptionPane.*;

class Ligningskontoret{
	private int fødselsdag;
	private int kontorNummer;

	public int kontorSøk(int fødselsdag){
		this.fødselsdag = fødselsdag;
		if(fødselsdag >= 1 && fødselsdag <= 8) kontorNummer = 113;
		else if(fødselsdag >= 9 && fødselsdag <= 14) kontorNummer = 120;
		else if(fødselsdag >= 15 && fødselsdag <= 25) kontorNummer = 125;
		else if(fødselsdag >= 26 && fødselsdag <= 31) kontorNummer = 134;
		return kontorNummer;
	}
	public String toString(){
		return "Fødselsdag " + fødselsdag + ". skal på kontor nr " + kontorNummer;
	}
}

public class Oppg3_12_1{
	public static void main(String[]args){
		int fortsett = YES_OPTION;
		while(fortsett == YES_OPTION){
			Ligningskontoret søk = new Ligningskontoret();
			int fødselsdag = Integer.parseInt(showInputDialog("Skriv inn din fødselsdag"));
			if (fødselsdag < 1 || fødselsdag > 31){
				showMessageDialog(null, "Denne dagen finnes ikke");
			}else{
				søk.kontorSøk(fødselsdag);
				showMessageDialog(null, søk.toString());
				fortsett = showConfirmDialog(null,"Søke på ny fødselsdag?", "Kontorsøk", YES_NO_OPTION);
			}
		}
	}
}