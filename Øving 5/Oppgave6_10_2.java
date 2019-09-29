import static javax.swing.JOptionPane.*;

class Br�k{

	private int teller;
	private int nevner;

	int i = 1;

	public Br�k(int teller, int nevner){

		if (nevner == 0) {
			throw new IllegalArgumentException("Nevner kan ikke v�re 0");
		}

		this.teller = teller;
		this.nevner = nevner;
	}

	public Br�k(int teller){

		this.teller = teller;
		this.nevner = 1;
	}

	public int getNevner(){
		return nevner;
	}

	public int getTeller(){
		return teller;
	}

	public void multiplisereBr�k(Br�k br�k){
		this.teller *= br�k.getTeller();
		this.nevner *= br�k.getNevner();
		forkorting();
	}

	public void dividereBr�k(Br�k br�k){
		this.teller *= br�k.getNevner();
		this.nevner *= br�k.getTeller();
		forkorting();
	}

	public void addereBr�k(Br�k br�k){
		this.teller = this.teller * br�k.getNevner() + this.nevner*br�k.getTeller();
		this.nevner *= br�k.getNevner();
		forkorting();
	}

	public void subtrahereBr�k(Br�k br�k){
		this.teller = this.teller * br�k.getNevner() - this.nevner*br�k.getTeller();
		this.nevner *= br�k.getNevner();
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

		int teller1 = Integer.parseInt(showInputDialog("Skriv inn teller til den f�rste br�ken"));
		int nevner1 = Integer.parseInt(showInputDialog("Skriv inn nevner til den f�rste br�ken"));
		int teller2 = Integer.parseInt(showInputDialog("Skriv inn teller til den andre br�ken"));
		int nevner2 = Integer.parseInt(showInputDialog("Skriv inn nevner til den andre br�ken"));

		Br�k br�k1 = new Br�k(teller1, nevner1);
		Br�k br�k2 = new Br�k(teller2, nevner2);
		String ut = "";

		br�k1.multiplisereBr�k(br�k2);
		ut += teller1 + "/" + nevner1 + " * " + teller2 + "/" + nevner2 + " = " + br�k1.getTeller() + "/" + br�k1.getNevner() + "\n";

		br�k1 = new Br�k(teller1, nevner1);
		br�k1.dividereBr�k(br�k2);
		ut += teller1 + "/" + nevner1 + " : " + teller2 + "/" + nevner2 + " = " + br�k1.getTeller() + "/" + br�k1.getNevner() + "\n";

		br�k1 = new Br�k(teller1, nevner1);
		br�k1.addereBr�k(br�k2);
		ut += teller1 + "/" + nevner1 + " + " + teller2 + "/" + nevner2 + " = " + br�k1.getTeller() + "/" + br�k1.getNevner() + "\n";

		br�k1 = new Br�k(teller1, nevner1);
		br�k1.subtrahereBr�k(br�k2);
		ut += teller1 + "/" + nevner1 + " - " + teller2 + "/" + nevner2 + " = " + br�k1.getTeller() + "/" + br�k1.getNevner() + "\n";

		showMessageDialog(null,ut);

	}
}


