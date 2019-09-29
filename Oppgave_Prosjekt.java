import static javax.swing.JOptionPane.*;

class Prosjekt{

	private final String prosjektTittel;
	private final String ansvarsPerson;
	private double budsjett;

	public Prosjekt(String prosjektTittel, String ansvarsPerson, double budsjett){
		this.prosjektTittel = prosjektTittel;
		this.ansvarsPerson = ansvarsPerson;
		this.budsjett = budsjett;
	}
	public String getProsjektTittel(){
		return prosjektTittel;
	}
	public String getAnsvarsPerson(){
		return ansvarsPerson;
	}
	public double getBudsjett(){
		return budsjett;
	}

	public void setBudsjett(double budsjett){
		this.budsjett = budsjett;
	}
	public String toString(){
		return "Prosjekttittel: " + prosjektTittel + ", Navn på ansvarspersonen: " + ansvarsPerson + ", Budsjettet til gruppa: " + budsjett;
	}
}


class Oppgave_Prosjekt{
	public static void main (String[] args){

		String tittelLest = showInputDialog("Tittel på gruppa");
		String navnLest = showInputDialog("Navn på ansvarsperson");
		String beløpLest = showInputDialog("Gruppas budsjett");

		String tittel = tittelLest;
		String navn = navnLest;
		double beløp = Double.parseDouble(beløpLest);

		Prosjekt prosjekt1 = new Prosjekt(tittel, navn, beløp);

		System.out.println("Gruppe 1: \n" + prosjekt1.toString());


	}
}

