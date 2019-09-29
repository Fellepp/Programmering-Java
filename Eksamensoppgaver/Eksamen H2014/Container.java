import java.io.Serializable;

public class Container implements Serializable{
	private int ID;
	private String innhold;
	private int vekt;
	private String destinasjon;
	private boolean losset = false;
	public static int IDteller = 1;

	public Container(int ID, String innhold, int vekt, String destinasjon){
		this.ID = ID;
		this.innhold = innhold;
		this.vekt = vekt;
		this.destinasjon = destinasjon;
		this.losset = losset;
	}

	public Container(String innhold, int vekt, String destinasjon){
		this.innhold = innhold;
		this.vekt = vekt;
		this.destinasjon = destinasjon;
		this.ID = IDteller;
		IDteller++;
	}

	public String toString(){
		String ikkeOmbord = "Container er ombord";
		if(losset) ikkeOmbord = "Container har ankommet destinasjon";
		return ID + ": " + innhold + ". " + vekt + " tonn. " + destinasjon + ". " + ikkeOmbord;
	}

	public int getID(){
		return ID;
	}

	public String getInnhold(){
		return innhold;
	}

	public int getVekt(){
		return vekt;
	}

	public String getDestinasjon(){
		return destinasjon;
	}

	public void setLosset(boolean losset){
		this.losset = losset;
	}

	public boolean equals(Object obj){
		if(obj == this) return true;
		if(obj == null) return false;
		if(!(obj instanceof Container)) return false;
		Container objContainer = (Container)obj;
		return(this.getID() == objContainer.getID()); //returner true hvis like
	}
}