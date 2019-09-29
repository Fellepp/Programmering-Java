import java.util.Random;

class Spiller{

	private int sumPoeng = 0;

	public int kastTerning(){
		Random terning = new Random(); //Tilfeldig tall
		int terningKast = terning.nextInt(6)+1; //Får tall fra 1-6

		if(terningKast == 1){ //Dersom terningkast 1, blir poengsummen 0
			sumPoeng = 0;
			return 1;
		}if(sumPoeng > 100){ //Ta vekk if setningen + else setningen for å være førstemann over 100
			sumPoeng -= terningKast;
		}else{
			sumPoeng += terningKast;
		}
			return terningKast;

	}

	public int getSumPoeng(){
		return sumPoeng;
	}
	public boolean erFerdig(){ //Så lenge sumPoeng er under 100, vil den fortsette
		if(sumPoeng == 100){ //if(sumPoeng >= 100) -> Førstemann over 100
			return true;
		}
		return false;
	}
}

public class Oppgave5_9_3{
	public static void main(String[] args){

		Spiller a = new Spiller();
		Spiller b = new Spiller();
		int runde = 1;

		while(!a.erFerdig() && !b.erFerdig()){

			System.out.println("Runde " + runde + ": 	Spiller A slo " + a.kastTerning() + " og har totalt " + a.getSumPoeng() + " poeng."
			+ "    Spiller B slo " + b.kastTerning() + " og har totalt " + b.getSumPoeng() + " poeng.");
			System.out.println("------------------------------------------------------------------------------------------------------");

			runde++;
		}
	}
}
