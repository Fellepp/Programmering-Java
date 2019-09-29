import static javax.swing.JOptionPane.*;

class Student{
	private final String NAVN;
	private int antOppg;

	public Student(String navn, int antOppg){
		NAVN = navn;
		this.antOppg = antOppg;
	}

	public String getNavn(){
		return NAVN;
	}

	public int getAntOppg(){
		return antOppg;
	}

	public void økAntOppg(int økning){
		antOppg += økning;
	}

	public String toString(){
		return "Studenten " + NAVN + " har " + antOppg + " godkjente leveringer";
	}

}


class Oppgaveoversikt{
	private int antStud = 0;
	private Student[] studenter = new Student[antStud];

	public int getAntallStudenter(){
		return antStud;
	}

	public int getAntallOppgaver(String navn){
		for (int i = 0; i < antStud; i++){
			if (navn.equals(studenter[i].getNavn())) return studenter[i].getAntOppg(); //Kun hvis studenten finnes
		}
		return -1;
	}

	public boolean registrerNyStudent(String navn, int antOppg){
		for (int i = 0; i<antStud; i++){
			if (navn.equals(studenter[i].getNavn())) return false; //Hvis studenten allerede er registrert
		}
		antStud++;
		Student[] hjelp = studenter; //Lager hjelpearray for å lagre verdiene til studenter
		studenter = new Student[antStud];
		for (int i = 0; i<hjelp.length; i++){
			studenter[i] = hjelp[i]; //Kopierer elementene tilbake til studenter igjen. Vil ha en ledig plass
		}
		Student s = new Student(navn, antOppg);
		studenter[antStud-1] = s; //Fyller den ledige plassen på slutten
		return true;
	}

	public boolean økAntOppgStud(String navn, int økning){
		for (int i = 0; i<antStud; i++){
			if (navn.equals(studenter[i].getNavn())){ //Kun hvis studenten finnes
				studenter[i].økAntOppg(økning);
				return true;
			}
		}
		return false;
	}

	public String toString(){
		String ut = "";
		for (int i = 0; i<antStud; i++){
			ut += studenter[i].toString() + "\n";
		}
		return ut;
	}

}

public class Oppgave12_10_1{
	public static void main (String[] args){
		String s = "";
		Oppgaveoversikt o = new Oppgaveoversikt();
		int valg = Integer.parseInt(showInputDialog("Velg mellom følgende operasjoner: \n1 - Registrer ny student \n2 - Øk antall godkjente leveringer for en bestemt student \n3 - Finn antall godkjente leveringer for en bestemt student \n4 - Finn antall registrerte studenter \n5 - Liste over registrerte studenter og godkjente leveringer"));

		while(true){
			switch(valg){
				case 1:	String n = showInputDialog("Skriv inn navn på ny student");
						int a = Integer.parseInt(showInputDialog("Skriv inn antall godkjente leveringer"));
						if (o.registrerNyStudent(n,a) == false) showMessageDialog(null,"Studenten " + n + " er allerede registrert");
						else showMessageDialog(null,"Studenten " + n + " er registrert med " + a + " godkjente leveringer");
						break;

				case 2: n = showInputDialog("Skriv inn navnet på studenten du vil øke godkjente leveringer for");
						int ø = Integer.parseInt(showInputDialog("Skriv inn økningen i antall godkjente leveringer"));
						if (o.økAntOppgStud(n,ø) == false) showMessageDialog(null, "Studenten " + n + " finnes ikke");
						else showMessageDialog(null, "Studenten " + n + " har økt sine godkjente leveringer med " + ø);
						break;

				case 3:	n = showInputDialog("Skriv inn navnet på studenten du vil se godkjente leveringer for");
						if (o.getAntallOppgaver(n) == -1) showMessageDialog(null, "Studenten " + n + " finnes ikke");
						else showMessageDialog(null, "Studenten " + n + " har antall godkjente leveringer: " + o.getAntallOppgaver(n));
						break;

				case 4: showMessageDialog(null, "Antall registrerte studenter: " + o.getAntallStudenter());
						break;

				case 5: showMessageDialog(null, o.toString());
						break;


				default: System.exit(0);
			}
			valg = Integer.parseInt(showInputDialog("Velg mellom følgende operasjoner: \n1 - Registrer ny student \n2 - Øk antall godkjente leveringer for en bestemt student \n3 - Finn antall godkjente leveringer for en bestemt student \n4 - Finn antall registrerte studenter \n5 - Liste over registrerte studenter og godkjente leveringer"));
		}

	}
}