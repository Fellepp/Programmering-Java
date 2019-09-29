import java.io.Serializable;

public class ContainerSkip implements Serializable{
	private String navn;
	private int vektMaks;
	private int antallMaks;
	private Container[] containere;
	private int antallContainere;

	public ContainerSkip(String navn, int vektMaks, int antallMaks){
		this.navn = navn;
		this.vektMaks = vektMaks;
		this.antallMaks = antallMaks;
		this.containere = new Container[antallMaks];
	}

	public String getNavn(){
		return navn;
	}

	public int getVektMaks(){
		return vektMaks;
	}

	public int getAntallMaks(){
		return antallMaks;
	}

	public Container[] getContainere(){
		return containere;
	}

	public int getAntallContainere(){
		return antallContainere;
	}

	public int totalVekt(){
		int totalVekt = 0;
		for(int i = 0; i<containere.length; i++){
			if(containere[i] == null) continue;
			totalVekt += containere[i].getVekt();
		}
		return totalVekt;
	}

	public int ledigePlasser(){
	return antallMaks-antallContainere;
	}

	public int ledigKapasitet(){
		return vektMaks-totalVekt();
	}

	public String toString(){
		String ut = navn + ", Lastekapasitet: " + vektMaks + " tonn. Ledig lastekapasitet: " + (ledigKapasitet() + " tonn\n");
		for(int i = 0; i<containere.length; i++){
			if(containere[i] == null) continue;
			ut += containere[i].toString() + "\n";
		}
		return ut;
	}

	public boolean finnes(Container container){
		if(container != null){
			for(int i = 0; i<containere.length; i++){
				if(containere[i] == null) continue;
				if(container.getID() == containere[i].getID()) return true;
			}
		}
		return false;
	}

	public boolean regContainer(Container container){
		if(container == null) return false; //Feil inndata
		if(antallContainere >= containere.length) return false; //Er for mange containere
		if(ledigKapasitet() < container.getVekt()) return false; //For tungt
		if(finnes(container)) return false; //Containeren finnes allerede. ID FUCKER OPP DENNE!!

		/* DERSOM KOMPOSISJON
		Container[] kopi = new Container(container.getID, getNavn, getVekt osv)
		containere[antallContainere] = kopi
		*/
		containere[antallContainere] = container;
		antallContainere++;
		return true;
	}

	public Container[] containerLoss(String destinasjon){
		Container[] losset = new Container[antallContainere];
		int plass = 0;
		if(destinasjon != ""){
			for(int i = 0; i<antallContainere; i++){
				if(containere[i] == null) continue;
				if(containere[i].getDestinasjon().equals(destinasjon)){ //Hvis den finner en som skal losse
					containere[i].setLosset(true);
					losset[plass] = containere[i];
					plass++;
				}
			}
		}
		return losset;
	}
}