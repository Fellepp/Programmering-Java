import static javax.swing.JOptionPane.*;

class Brøk{

	private int teller;
	private int nevner;

	int i = 1;

	public Brøk(int teller, int nevner){

		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner kan ikke være 0");
		}

		this.teller = teller;
		this.nevner = nevner;
	}

	public Brøk(int teller){

		this.teller = teller;
		this.nevner = 1;
	}

	public int getNevner(){
		return nevner;
	}

	public int getTeller(){
		return teller;
	}

	public void multiplisereBrøk(Brøk brøk){
		this.teller *= brøk.getTeller();
		this.nevner *= brøk.getNevner();
		forkorting();
	}

	public void dividereBrøk(Brøk brøk){
		this.teller *= brøk.getNevner();
		this.nevner *= brøk.getTeller();
		forkorting();
	}

	public void addereBrøk(Brøk brøk){
		this.teller = this.teller * brøk.getNevner() + this.nevner*brøk.getTeller();
		this.nevner *= brøk.getNevner();
		forkorting();
	}

	public void subtrahereBrøk(Brøk brøk){
		this.teller = this.teller * brøk.getNevner() - this.nevner*brøk.getTeller();
		this.nevner *= brøk.getNevner();
		forkorting();
	}

	public void forkorting(){
		i = this.nevner;
		while(this.nevner % i != 0 || this.teller % i != 0){
			i--;
		}
		this.teller /= i;
		this.nevner /= i;
	}
}

public class Oppgave6_10_2{
	public static void main (String[] args){

		int teller1 = Integer.parseInt(showInputDialog("Skriv inn teller til den første brøken"));
		int nevner1 = Integer.parseInt(showInputDialog("Skriv inn nevner til den første brøken"));
		int teller2 = Integer.parseInt(showInputDialog("Skriv inn teller til den andre brøken"));
		int nevner2 = Integer.parseInt(showInputDialog("Skriv inn nevner til den andre brøken"));

		Brøk brøk1 = new Brøk(teller1, nevner1);
		Brøk brøk2 = new Brøk(teller2, nevner2);
		String ut = "";

		brøk1.multiplisereBrøk(brøk2);
		ut += teller1 + "/" + nevner1 + " * " + teller2 + "/" + nevner2 + " = " + brøk1.getTeller() + "/" + brøk1.getNevner() + "\n";

		brøk1 = new Brøk(teller1, nevner1);
		brøk1.dividereBrøk(brøk2);
		ut += teller1 + "/" + nevner1 + " : " + teller2 + "/" + nevner2 + " = " + brøk1.getTeller() + "/" + brøk1.getNevner() + "\n";

		brøk1 = new Brøk(teller1, nevner1);
		brøk1.addereBrøk(brøk2);
		ut += teller1 + "/" + nevner1 + " + " + teller2 + "/" + nevner2 + " = " + brøk1.getTeller() + "/" + brøk1.getNevner() + "\n";

		brøk1 = new Brøk(teller1, nevner1);
		brøk1.subtrahereBrøk(brøk2);
		ut += teller1 + "/" + nevner1 + " - " + teller2 + "/" + nevner2 + " = " + brøk1.getTeller() + "/" + brøk1.getNevner() + "\n";

		showMessageDialog(null,ut);

	}
}


