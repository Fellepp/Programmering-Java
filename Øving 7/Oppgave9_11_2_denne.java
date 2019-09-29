import static javax.swing.JOptionPane.*;

class Temperatur{

	java.util.Random random = new java.util.Random();
	int dager = 6;
	int timer = 4;
	int[][] temperaturArray = new int[timer][dager];

	public Temperatur(){
		for (int i = 0; i<timer; i++){
			for (int j = 0; j<dager; j++){
				temperaturArray[i][j] = random.nextInt(20)-7;
			}
		}
	}

	public double[] medianTemperatur (){
		double[] sortertArray = new double[dager]; //oppretter en ny tabell til sortering for å ikke forandre den originale
		for(int dag = 0; dag < dager; dag++){
			int[] hjelpeArray = new int[timer]; //oppretter en hjelpearray som sjekkes opp mot sortertArray (ny hver dag)
			for(int time = 0; time<timer; time++){
				hjelpeArray[time] = temperaturArray[time][dag]; //Verdien på plass time-dag. Alle verdiene ligger nå i hjelpeArray
			}
			int kaldesteTemp = 100; //Setter en høy temp for å få det til å gå opp
			int kaldesteTempPlass = 0;
			for (int i = 0; i<hjelpeArray.length; i++){
				kaldesteTemp = 100; //Resetter
				kaldesteTempPlass = i; //Hvis den ikke finner noe, vil den første være den kaldeste
				for (int j = i; j<hjelpeArray.length; j++){
					if(hjelpeArray[j] < kaldesteTemp){
						kaldesteTemp = hjelpeArray[j];
						kaldesteTempPlass = j; //plassen til den kaldeste temperaturen
					}
				}
				int lagring = hjelpeArray[kaldesteTempPlass]; //Lagrer midlertidig verdien til den kaldeste temperaturen
				hjelpeArray[kaldesteTempPlass] = hjelpeArray[i];
				hjelpeArray[i] = lagring;
			}
			/*System.out.print("\n");
			for (int i = 0; i<timer; i++){
			System.out.print(hjelpeArray[i]+ "\n");
			}*/


			if(timer%2==0){
				sortertArray[dag] = (hjelpeArray[(timer)/2]+hjelpeArray[((timer)/2)-1])*1.0/2; //dersom partall, returnerer gjennomsnitt av talla i midten
			}else{
				sortertArray[dag] = hjelpeArray[((timer-1))/2]; //Dersom oddetall, returnerer tallet i midten
			}
		}
		return sortertArray;
	}

	public double[] medianTemperaturTime(){
		double[] sortertArray = new double[timer];
		for (int time = 0; time < timer; time++){
			int[] hjelpeArray = new int[dager];
			for(int dag = 0; dag<dager; dag++){
				hjelpeArray[dag] = temperaturArray[time][dag];
			}
			int kaldesteTemp = 100;
			int kaldesteTempPlass = 0;
			for (int i = 0; i<hjelpeArray.length; i++){
				kaldesteTemp = 100;
				kaldesteTempPlass = i;
				for(int j = i; j<hjelpeArray.length; j++){
					if(hjelpeArray[j] < kaldesteTemp){
						kaldesteTemp = hjelpeArray[j];
						kaldesteTempPlass = j;
					}
				}
				int lagring = hjelpeArray[kaldesteTempPlass];
				hjelpeArray[kaldesteTempPlass] = hjelpeArray[i];
				hjelpeArray[i] = lagring;
			}

			/*System.out.print("\n");
			for (int i = 0; i<dager; i++){
				System.out.print(hjelpeArray[i]+ "\n");
			}*/

			if(timer%2==0){
					sortertArray[time] = (hjelpeArray[(dager)/2] + hjelpeArray[((dager)/2)-1])*1.0/2;
			}else{
				sortertArray[time] = hjelpeArray[(dager-1)/2];
			}
		}
		return sortertArray;
	}
}

public class Oppgave9_11_2_denne{
	public static void main (String[] args){

		Temperatur t = new Temperatur();

		System.out.println("Dager ---->");
		for (int i = 0; i<4; i++){
			System.out.print("\n");
			for (int j = 0; j<6; j++){
				System.out.print(t.temperaturArray[i][j] + "	");
			}
		}
		System.out.println("\n____________________________________________________________\n" + "Oppgave A)");

		double[] sortertArray = t.medianTemperatur();
		for (int i = 0; i<6; i++){
			System.out.print("Middeltemperaturen for dag " + (i+1) + " er: " +  sortertArray[i] + " grader Celsius" + "\n");
		}

		System.out.println("\n____________________________________________________________\n" + "Oppgave B)");

		double[] sortertArrayTime = t.medianTemperaturTime();
		for (int i = 0; i<4; i++){
			System.out.print("Middeltemperaturen for time " + (i+1) + " er: " +  sortertArrayTime[i] + " grader Celsius" + "\n");
		}
	}
}