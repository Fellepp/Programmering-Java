import java.io.*;

public class By implements Serializable{
	private String byNavn;
	private int antInnbyggere;
	private int maksInnbyggere;
	private String ordf�rer;

	public By(){
	}

	public By(String byNavn, int antInnbyggere, int maksInnbyggere, String ordf�rer){
		if(maksInnbyggere < antInnbyggere){
			throw new IllegalArgumentException("Innbyggertall kan ikke overstige maks innbyggere");
		}
		this.byNavn = byNavn;
		this.antInnbyggere = antInnbyggere;
		this.maksInnbyggere = maksInnbyggere;
		this.ordf�rer = ordf�rer;
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
				throw new IllegalArgumentException("Maks innbyggere kan ikke v�re mindre enn innbyggertall");
			}
			this.maksInnbyggere = maksInnbyggere;
	}

		public void setOrdf�rer(String ordf�rer){
			this.ordf�rer = ordf�rer;
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

	public String getOrdf�rer(){
		return ordf�rer;
	}

	public boolean harPlassTil(int antall){
		return maksInnbyggere - antInnbyggere > antall;
	}

	public boolean equals(Object obj){
		if (obj == this) return true; //Hvis objektet er likt seg selv, true
		if (obj == null) return false; //Hvis objektet er null, tomt, false
		if (!(obj instanceof By)) return false; //Hvis objektet ikke er en klasse av By, false
		By objBy = (By)obj; //Vi vet at obj er By, caster den s� den blir By
		return this.byNavn.equals(objBy.byNavn); //returner true hvis like, false hvis ikke like
	}

	public String toString(){
		return "Navn p� by: " + byNavn + ", innbyggertall: " + antInnbyggere + ", maks innbyggere: " + maksInnbyggere + ", Ordf�rer: " + ordf�rer + ".\n";
	}
}