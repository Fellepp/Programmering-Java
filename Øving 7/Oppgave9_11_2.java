import static javax.swing.JOptionPane.*;

class Temperatur{

	java.util.Random random = new java.util.Random();
	int[][] temperaturArray = new int[24][30];

	public Temperatur(){
		for (int i = 0; i<24; i++){
			for (int j = 0; j<30; j++){
				temperaturArray[i][j] = random.nextInt(20)-7;
			}
		}
	}
	public int gjennomsnittsTemperatur(){
		int sortertTabell
		for(int start = 0; start < 24; start++){
			int hittilStørst = start;
			for(int i = start + 1; i<30; i++){
				if (temperaturArray[0][i] < temperaturArray[0][hittilStørst]) hittilStørst = i;
			}
			int hjelp = temperaturArray[0][hittilStørst];
			temperaturArray[0][hittilStørst] = temperaturArray[0][start];
			temperaturArray[0][start] = hjelp;
		}
		return gjennomsnittsTemperatur();
	}
}

public class Oppgave9_11_2{
	public static void main (String[] args){

		Temperatur t = new Temperatur();

		for (int i = 0; i<24; i++){
			System.out.print("\n");
			for (int j = 0; j<30; j++){
				System.out.print(t.temperaturArray[i][j] + "	");
			}
		}
		System.out.println("_____________________________________________");
		t.gjennomsnittsTemperatur();

		for (int i = 0; i<24; i++){
					System.out.print("\n");
					for (int j = 0; j<30; j++){
						System.out.print(t.temperaturArray[i][j] + "	");
					}
		}
	}
}