import java.io.*;

public class By implements Serializable{
	private String byNavn;
	private int antInnbyggere;
	private int maksInnbyggere;
	private String ordfører;

	public By(){
	}

	public By(String byNavn, int antInnbyggere, int maksInnbyggere, String ordfører){
		if(maksInnbyggere < antInnbyggere){
			throw new IllegalArgumentException("Innbyggertall kan ikke overstige maks innbyggere");
		}
		this.byNavn = byNavn;
		this.antInnbyggere = antInnbyggere;
		this.maksInnbyggere = maksInnbyggere;
		this.ordfører = ordfører;
	}

	public void setNavn(String byNavn){
		this.byNavn = byNavn;
	}

		public void setAntInnbyggere(int antInnbyggere){
			if(maksInnbyggere > antInnbyggere){
				throw new IllegalArgumentException("Innbyggertall kan ikke overstige maks innbyggere");
			}

			this.antInnbyggere = antInnbyggere;
	}

		public void setMaksInnbyggere(int maksInnbyggere){
			if(maksInnbyggere < antInnbyggere){
				throw new IllegalArgumentException("Maks innbyggere kan ikke være mindre enn innbyggertall");
			}
			this.maksInnbyggere = maksInnbyggere;
	}

		public void setOrdfører(String ordfører){
			this.ordfører = ordfører;
	}

	public String getByNavn(){
		return byNavn;
	}

	public int getAntInnbyggere(){
		return antInnbyggere;
	}

	public int getMaksInnbyggere(){
		return maksInnbyggere;
	}

	public String getOrdfører(){
		return ordfører;
	}

	public boolean harPlassTil(int antall){
		return maksInnbyggere - antInnbyggere > antall;
	}

	public boolean equals(Object obj){
		if (obj == this) return true; //Hvis objektet er likt seg selv, true
		if (obj == null) return false; //Hvis objektet er null, tomt, false
		if (!(obj instanceof By)) return false; //Hvis objektet ikke er en klasse av By, false
		By objBy = (By)obj; //Vi vet at obj er By, caster den så den blir By
		return this.byNavn.equals(objBy.byNavn); //returner true hvis like, false hvis ikke like
	}

	public String toString(){
		return "Navn på by: " + byNavn + ", innbyggertall: " + antInnbyggere + ", maks innbyggere: " + maksInnbyggere + ", Ordfører: " + ordfører + ".\n";
	}
}