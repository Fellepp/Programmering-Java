class Kake_Class{
	private final String kakeType;
	private double størrelse;
	private final double pris;

	public Kake_Class(String kakeType, double størrelse, double pris){
		this.kakeType = kakeType;
		this.størrelse = størrelse;
		this.pris = pris;
	}
	public String getKakeType(){
		return kakeType;
	}
	public double getPris(){
		return pris;

	}
	public double getStørrelse(){
			return størrelse;
	}
	public void utførSpising(double biter){
		størrelse -= biter;
	}
}


