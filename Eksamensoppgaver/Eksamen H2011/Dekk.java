public class Dekk{
	private String dekknavn;
	private String dimensjon;
	private String dekktype;
	private int[] monsterdybde;

	public Dekk(String dekknavn, String dimensjon, String dekktype, int[] monsterdybde){
		this.dekknavn = dekknavn;
		this.dimensjon = dimensjon;
		this.dekktype = dekktype;
		this.monsterdybde = monsterdybde;
	}

	public String getDekkNavn(){
		return dekknavn;
	}

	public String getDimensjon(){
		return dimensjon;
	}

	public String getDekktype(){
		return dekktype;
	}

	public int[] getMonsterdybde(){
		return monsterdybde;
	}

	public void setMonsterdybde(int[] monsterdybde){
		this.monsterdybde = monsterdybde;
	}

	public String toString(){
		String ut = "Dekknavn: " + dekknavn + ", dimensjon: " + dimensjon + ", dekktype: " + dekktype + ", mønsterdybde: ";
		for(int i = 0; i<monsterdybde.length; i++){
			ut += monsterdybde[i] + ", ";
		}
		return ut;
	}

	public boolean equals(Object obj){
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof Dekk)) return false;
		Dekk objDekk = (Dekk)obj;
		if((dekknavn.equals(objDekk.getDekkNavn())) && (dimensjon.equals(objDekk.getDimensjon())) && (dekktype.equals(objDekk.getDekktype()))) return true;
		else return false;
	}

	public int compareTo(Dekk d){
		if(this == d) return 0; //hvis dette == d, return 0, samme objekt
		if(dekknavn.equals(d)) return 0; //hvis dekknavn == d, return 0
		return (dekknavn.compareTo(d.getDekkNavn())); //returner
	}

}