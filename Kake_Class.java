class Kake_Class{
	private final String kakeType;
	private double st�rrelse;
	private final double pris;

	public Kake_Class(String kakeType, double st�rrelse, double pris){
		this.kakeType = kakeType;
		this.st�rrelse = st�rrelse;
		this.pris = pris;
	}
	public String getKakeType(){
		return kakeType;
	}
	public double getPris(){
		return pris;

	}
	public double getSt�rrelse(){
			return st�rrelse;
	}
	public void utf�rSpising(double biter){
		st�rrelse -= biter;
	}
}


