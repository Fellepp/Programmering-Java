public class Dekkhotell{
	private String hotellnavn;
	private Kunde[] kunder;
	private int plass;
	private int antKunder;

	public Dekkhotell(String hotellnavn, int plass){
		this.hotellnavn = hotellnavn;
		this.kunder = new Kunde[plass];
		antKunder = 0;
	}

	public void setHotellNavn(String hotellnavn){
		this.hotellnavn = hotellnavn;
	}

	public int getPlass(){
		return plass;
	}

	public int getAntKunder(){
		return antKunder;
	}

	public String getHotellNavn(){
		return hotellnavn;
	}

	public Kunde[] getKunder(){
		return kunder;
	}

	public void setPlass(int plass){
		this.plass = plass;
		this.kunder = new Kunde[plass];
	}

	public String toString(){
		String ut = "Dekkhotellnavn: " + hotellnavn + ", kundeinformasjon: ";
		for(int i = 0; i<kunder.length; i++){
			ut += kunder[i].toString() + "\n";
		}
		return ut;
	}

	public boolean regKunde(Kunde kunde){
		if(kunde == null) return false; //Kunde er tom
		if(antKunder >= kunder.length) return false; //Plassen er full
		if(finnes(kunde)) return false; //Kunden finnes allerede

		Kunde kopi = new Kunde(kunde.getBilNr(), kunde.getNavn(), kunde.getDato(), kunde.getDekk());
		kunder[antKunder] = kopi;
		antKunder++;
		return true;
	}

	public boolean avsluttKunde1(String bilNr){
		int kundePlass = -1;
		if(bilNr == null) return false;
		for(int i = 0; i<antKunder; i++){
			if(kunder[i] == null) continue; //hvis tomt gå videre
			if(bilNr.equals(kunder[i].getBilNr())) kundePlass = i; //Hvis bilnr = kundens bilnr, kundeplass = plassen til personen
		}
		if(kundePlass == -1) return false; //hvis -1 fortsatt (fant ikke kunden), return false
		if(finnes(kunder[kundePlass])){ //hvis kunden finnes
			Kunde[] hjelp = new Kunde[antKunder]; //Hjelpearray[2] hvis 2 kunder (0,1)
			for(int i = 0; i<antKunder; i++){
				if(kunder[i] == null)continue;
				for(int j = i; j<antKunder; j++){
					if(!(kunder[i].getBilNr().equals(bilNr))){
							hjelp[i] = kunder[j];
						}
					}
			}
			for(int i = 0; i<antKunder; i++){
				kunder[i] = hjelp[i];
			}
			kunder[antKunder-1] = null;
			antKunder--;
			return true;
		}
		return false;
	}

		public boolean avsluttKundeTobias(String bilNr){
			int kundePlass = -1;
			if(bilNr == null) return false;
			for(int i = 0; i<antKunder; i++){
				if(kunder[i] == null) continue; //hvis tomt gå videre
				if(bilNr.equals(kunder[i].getBilNr())) kundePlass = i; //Hvis bilnr = kundens bilnr, kundeplass = plassen til personen
			}
			if(kundePlass == -1) return false; //hvis -1 fortsatt (fant ikke kunden), return false
			if(finnes(kunder[kundePlass])){ //hvis kunden finnes
				for(int i = kundePlass; i < antKunder-1; i++){
					kunder[i] = kunder[i+1];
				}
				kunder[antKunder-1] = null;
				antKunder--;
				return true;
			}
			return false;
	}

	public boolean slettKunde(String bilNr){
		for(int i = 0; i<kunder.length; i++){
			if(kunder[i].getBilNr().equals(bilNr)){
				kunder[i] = null;
				antKunder--;
				return true;
			}
		}
		return false;
	}

	public String kundeOversikt(String bilNr){
		int kundePlass = -1;
		String ut = "Kunden finnes ikke";
		if(bilNr != null){
			for(int i = 0; i<antKunder; i++){
				if (kunder[i] == null) continue;
				if(bilNr.equals(kunder[i].getBilNr())) kundePlass = i;
			}
			if(kundePlass == -1) return ut;
			if(finnes(kunder[kundePlass])){
				ut = kunder[kundePlass].toString();
			}
		}
		return ut;
	}

	public boolean finnes(Kunde kunde){
		if(kunde == null) return false;
		for(int i = 0; i<kunder.length; i++){
			if(kunder[i] == null) continue;

			if(kunder[i].getBilNr().equals(kunde.getBilNr())) return true;
		}
		return false;
	}

	public String dekkSkift(int Dato){
		String ikkeSkiftet = "";
		if(antKunder != 0){
			for(int i = 0; i<antKunder; i++){
				if(kunder[i].getDato() < Dato){
					if(kunder[i] == null) continue;

					ikkeSkiftet += kunder[i].getNavn() + "\n";
				}
			}
			return ikkeSkiftet;
		}
		else return "Kundetabellen er tom";
	}

	public Kunde[] sorter(){
		Kunde[] sortTab = new Kunde[antKunder];
		for(int i = 0; i<antKunder; i++){
			sortTab[i] = kunder[i];
		}
		for(int start = 0; start<antKunder; start++){
			int hittilMinst = start;
			for(int j = start+1; j<antKunder; j++){
				if(sortTab[j].compareTo(sortTab[start]) < 0) hittilMinst = j;
			}
			Kunde tmp = sortTab[hittilMinst]; //blir f.eks satt til sortTab[1]
			sortTab[hittilMinst] = sortTab[start]; //setter sortTab[1] = sortTab[0]
			sortTab[start] = tmp; // Setter sortTab[0] = sortTab[1]...
		}
		return sortTab;
	}

	public String godkjenteDekk(int monsterdybdeVerdi){
		String godkjenteDekk = "Liste over kunder uten godkjente dekk: \n";
		for (int i = 0; i<antKunder; i++){
			if(kunder[i].dekkSjekk(monsterdybdeVerdi)) godkjenteDekk += kunder[i].getNavn() + "\n";
		}
		return godkjenteDekk;
	}
}