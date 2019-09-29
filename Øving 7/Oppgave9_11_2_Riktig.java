import static javax.swing.JOptionPane.*;

class Temperatur{

	java.util.Random random = new java.util.Random();
	int dager = 6;
	int timer = 4;
	int[][] temperaturArray = new int[timer][dager];

	public Temperatur(){
		for (int i = 0; i<timer; i++){
			for (int j = 0; j<dager; j++){
				temperaturArray[i][j] = random.nextInt(25)-10;
			}
		}
	}
	public double[] gjennomsnittsTemperaturDag(){
		double gjennomsnittsArray[] = new double[dager];
		for(int dag = 0; dag < dager; dag++){
			for(int time = 0; time<timer; time++){
				gjennomsnittsArray[dag] += temperaturArray[time][dag];
			}
			gjennomsnittsArray[dag] = (gjennomsnittsArray[dag])/timer;
		}
		return gjennomsnittsArray;
	}
	public double[] gjennomsnittsTemperaturTime(){
		double gjennomsnittsArrayTime[] = new double[timer];
		for(int time = 0; time<timer; time++){
			for(int dag = 0; dag<dager; dag++){
				gjennomsnittsArrayTime[time] += temperaturArray[time][dag];
			}
			gjennomsnittsArrayTime[time] = gjennomsnittsArrayTime[time]/dager;
		}
		return gjennomsnittsArrayTime;
	}
	public double gjennomsnittsTemperaturTotalt(){
		double totaltGjennomsnitt = 0;
		for (int dag = 0; dag<dager; dag++){
			for (int time = 0; time<timer; time++){
				totaltGjennomsnitt += temperaturArray[time][dag];
			}
		}
		totaltGjennomsnitt /= (timer * dager);
		return totaltGjennomsnitt;
	}
	public int[] oversiktTemperatur(){
		double gjennomsnittsArray[] = new double[dager];
		int oversiktsArray[] = new int [5]; //Oppgave d)
		for(int dag = 0; dag < dager; dag++){
			for(int time = 0; time<timer; time++){
				gjennomsnittsArray[dag] += temperaturArray[time][dag];
			}
			gjennomsnittsArray[dag] = (gjennomsnittsArray[dag])/timer;
			if(gjennomsnittsArray[dag] < -5) (oversiktsArray[0])++;
			else if (gjennomsnittsArray[dag] < 0 && gjennomsnittsArray[dag] > -5) (oversiktsArray[1])++;
			else if (gjennomsnittsArray[dag] < 5 && gjennomsnittsArray[dag] > 0) (oversiktsArray[2])++;
			else if (gjennomsnittsArray[dag] > 5 && gjennomsnittsArray[dag] < 10) (oversiktsArray[3])++;
			else if (gjennomsnittsArray[dag] > 10) (oversiktsArray[4])++;
		}
		return oversiktsArray;
	}
	public int[][] getArray(){
		return temperaturArray;
	}
}

public class Oppgave9_11_2_Riktig{
	public static void main (String[] args){

		Temperatur t = new Temperatur();
		int[][] temp = t.getArray();

		System.out.println("Dager ---->");
		for (int i = 0; i<t.timer; i++){
			System.out.println();
			for (int j = 0; j<t.dager; j++){
				System.out.print(temp[i][j] + "	");
			}
		}
		System.out.println("\n__________________________________________________________________\n" + "Oppgave A)");
		double[] gjennomsnittsArrayDag = t.gjennomsnittsTemperaturDag();
		for (int i = 0; i<t.dager; i++){
			System.out.print("Middeltemperaturen for dag " + (i+1) + " er: " +  gjennomsnittsArrayDag[i] + " grader Celsius" + "\n");
		}

		System.out.println("\n__________________________________________________________________\n" + "Oppgave B)");
		double[] gjennomsnittsArrayTime = t.gjennomsnittsTemperaturTime();
		for (int i = 0; i<t.timer; i++){
			System.out.print("Middeltemperaturen for time " + (i+1) + " er: " +  gjennomsnittsArrayTime[i] + " grader Celsius" + "\n");
		}

		System.out.println("\n__________________________________________________________________\n" + "Oppgave C)");
		double totaltGjennomsnitt = t.gjennomsnittsTemperaturTotalt();
		System.out.print("Middeltemperaturen for hele måneden er: " + totaltGjennomsnitt + " grader Celsius" + "\n");

		System.out.println("\n__________________________________________________________________\n" + "Oppgave D)");
		int[] oversiktArray = t.oversiktTemperatur();
		System.out.println("Antall døgn med middeltemperatur lavere enn -5 grader Celsius: " + oversiktArray[0]);
		System.out.println("Antall døgn med middeltemperatur mellom -5 og 0 grader Celsius: " + oversiktArray[1]);
		System.out.println("Antall døgn med middeltemperatur mellom 0 og 5 grader Celsius: " + oversiktArray[2]);
		System.out.println("Antall døgn med middeltemperatur mellom 5 og 10 grader Celsius: " + oversiktArray[3]);
		System.out.println("Antall døgn med middeltemperatur høyere enn 10 grader Celsius: " + oversiktArray[4]);
	}
}