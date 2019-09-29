import static javax.swing.JOptionPane.*;

class Ligningskontoret{
	private int f�dselsdag;
	private int kontorNummer;

	public int kontorS�k(int f�dselsdag){
		this.f�dselsdag = f�dselsdag;
		if(f�dselsdag >= 1 && f�dselsdag <= 8) kontorNummer = 113;
		else if(f�dselsdag >= 9 && f�dselsdag <= 14) kontorNummer = 120;
		else if(f�dselsdag >= 15 && f�dselsdag <= 25) kontorNummer = 125;
		else if(f�dselsdag >= 26 && f�dselsdag <= 31) kontorNummer = 134;
		return kontorNummer;
	}
	public String toString(){
		return "F�dselsdag " + f�dselsdag + ". skal p� kontor nr " + kontorNummer;
	}
}

public class Oppg3_12_1{
	public static void main(String[]args){
		int fortsett = YES_OPTION;
		while(fortsett == YES_OPTION){
			Ligningskontoret s�k = new Ligningskontoret();
			int f�dselsdag = Integer.parseInt(showInputDialog("Skriv inn din f�dselsdag"));
			if (f�dselsdag < 1 || f�dselsdag > 31){
				showMessageDialog(null, "Denne dagen finnes ikke");
			}else{
				s�k.kontorS�k(f�dselsdag);
				showMessageDialog(null, s�k.toString());
				fortsett = showConfirmDialog(null,"S�ke p� ny f�dselsdag?", "Kontors�k", YES_NO_OPTION);
			}
		}
	}
}