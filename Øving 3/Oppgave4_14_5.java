import static javax.swing.JOptionPane.*;

class Oppgave4_14_5{
	public static void main (String[] args){
		String tryAgain = "";
		do{
			String tallLest = showInputDialog("Skriv inn et tall!:");
			int tall = Integer.parseInt(tallLest);
			int result = 0;
			for (int i = 2; i<= tall/2 + 1; i++){
				if (tall % i == 0){
					result = 1;
				}
				if (tall ==2){
					result = 0;
				}

			}
			if (result == 1){
				showMessageDialog(null, tall + " er ikke et primtall.");
			}else{
				showMessageDialog(null, tall + " er et primtall.");
			}
			tryAgain = showInputDialog("Prøv igjen?");
		}while(tryAgain.equalsIgnoreCase("ja"));
	}
}




/*
class Oppgave4_14_5{
public static void main(String[] args){
	int tall = 21;
	int result = 0;
	for (int i = 2; i<= tall/2+1; i++){
		if (tall % i == 0) {
			result = 1;
		}
	}
	if (result == 1){
				System.out.println("Det er ikke et primtall.");
			}else{
			System.out.println("Det er et primtall.");
}
}
}


public class Primtall {

public static void main(String[] args)
{
    int j = 2;
    int result = 0;
    int number = 0;
    Scanner reader = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    number = reader.nextInt();
    while (j <= number / 2)
    {
        if (number % j == 0)
        {
           result = 1;
        }
        j++;
    }
    if (result == 1)
    {
        System.out.println("Number: " + number + " is Not Prime.");
    }
    else
    {
        System.out.println("Number: " + number + " is Prime. ");
    }
}
}
*/