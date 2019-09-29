public class Kunde{
	private String bilNr;
	private String navn;
	private int dato; //≈≈≈≈MMDD
	private Dekk dekk;

	public Kunde(String bilNr, String navn, int dato, Dekk dekk){
		this.bilNr = bilNr;
		this.navn = navn;
		this.dato = dato;
		this.dekk = new Dekk(dekk.getDekkNavn(), dekk.getDimensjon(), dekk.getDekktype(), dekk.getMonsterdybde()); //Komposisjon
	}

	public String toString(){
		return "Bilnummer: " + bilNr + ", navn: " + navn + ", siste skiftedato: " + dato + ", informasjon om dekk: " + dekk.toString() + "\n";
	}

	public String getBilNr(){
		return bilNr;
	}

	public String getNavn(){
		return navn;
	}

	public int getDato(){
		return dato;
	}

	public Dekk getDekk(){
		return dekk;
	}

	public void setBilNr(String bilNr){
		this.bilNr = bilNr;
	}

	public void setNavn(String navn){
		this.navn = navn;
	}

	public void setDato(int dato){
		this.dato = dato;
	}

	public void setDekk(Dekk dekk){
		if(dekk != null) this.dekk = new Dekk(dekk.getDekkNavn(), dekk.getDimensjon(), dekk.getDekktype(), dekk.getMonsterdybde());
		else dekk = null;
	}

	public boolean dekkSjekk(int monsterVerdi){
		if(dekk != null){
			for(int i = 0; i<getDekk().getMonsterdybde().length; i++){
				if(dekk.getMonsterdybde()[i] < monsterVerdi) return true;
			}
		}
		return false;
	}

	public int compareTo(Kunde k){
		return dekk.compareTo(k.getDekk());
	}
}