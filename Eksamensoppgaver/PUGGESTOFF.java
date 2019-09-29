/*
Ting jeg må pugge på:

SKRIV TIL FIL:

public static boolean skrivTilFil(Klasse klasse, String filnavn){
	if(klasse != null){
		FileOutputStream ut;
		ObjectOutputStream utstrøm;
		try{
			utstrøm = new FileOutputStream(filnavn);
			ut = new ObjectOutputStream(ut);
			ut.writeObject(klasse);
			ut.close();
			return true;
		}catch(FileNotFoundException e){
			System.out.println("Fil ikke funnet!");
		}catch(Exception e){
			System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
		}
	}
	return false;
}

LES FRA FIL:

public static Klasse lesFraFil(String filnavn){
	try{
		FileInputStream innstrøm = new FileInputStream(filnavn);
		ObjectInputStream inn = new ObjectInputStream(innstrøm);
		return (Klasse) inn.readObject();
	}catch(Exception e){
		System.out.println("Noe gikk galt ved lesing fra fil " + e.toString());
	}
	return null;
}

LES FRA FIL (MAIN METODEN)

public static void main (String[]args){
	...
	...
	...
	...
	final String filnavn = "pugging.ser"
	Klasse klasse = null

	try{
		klasse = lesFraFil(filnavn);
	}catch(Exception e){
		System.out.println("Noe gikk galt ved lesing av vil " + e.toString());
	}

	while(valg!=AVSLUTT){
		switch(valg){
		....

	SKRIVER TIL FIL VED AVSLUTT

	try{
		if (klasse != null) skrivTilFil(klasse, filnavn);
		System.out.println("Skriv til fil " + klasse);
	}catch(Exception e){
		System.out.println("Noe gikk galt ved skriving til fil " + e.toString());
	}
}


TESTING

import org.junit.*;

public class TestKlasse{
	Klasse instance;
	double delta = 0.0001;

	@Before
	public void setUp(){
		instance = new Klasse("Klasse", "10", "100");
		instance.regNy(new Ny(parameter, paramter, parameter, parameter));
		instance.regNy(new Ny(parameter, paramter, parameter, parameter));
		instance.regNy(new Ny(parameter, paramter, parameter, parameter));
	}

	@After
	public void tearDown(){
		instance = null;
	}

	@Test
	public void testGetNavn(){
		System.out.println("Navn");
		String forventetResultat = "Klasse";
		String resultat = instance.getNavn();
		Assert.assertEquals(forventetResultat, resultat);
	}

	@Test
	public void testGetVektMaks(){
		System.out.println("Vekt");
		int forventetResultat = 10;
		int resultat = instance.getVektMaks();
		Assert.assertEquals(forventetResultat, resultat);
	}

	EVT:
	@Test
	public void testRegNy(){
		result = instance.regNy(new Ny(parameter, parameter, parameter));
		Assert.assertTrue(result);


		try{
			By ugyldigBy = new By(ugyldig, parameter, parameter);
			Assert.fail();
		}catch(IllegalArgumentException e){
		}

		Assert.assertFalse(NOE SOM BLIR FALSE) - OK
		Assert.assertTrue(NOE SOM BLIR TRUE) - OK
		Assert.assertEQUALS (NOE SOM ER LIKT) - OK
	}
}

SORTER EN OBJEKTTABELL PÅ EN KOLONNE

public String getDyr(){
	Object[][] dyr = new Object[antDyr][2];
	for(int i = 0; i<antDyr; i++){
		if(dyrene[i] == null) continue;
		dyr[i][0] = dyrene[i].toString();
		dyr[i][1] = dyrene[i].getfAar();
	}
	Arrays.sort(dyr, new Comparator<Object[]>(){
		@Override
		public int compare(Object[] o1, Object[] o2){
			Integer alder1 = (Integer)(o1[1]); //Sorterer på kolonne 1
			Integer alder2 = (integer)(o2[1]);
			return -alder1.compareTo(alder2); Synkende rekkefølge
		}
	});
	String ut = "";
	for(int i = 0; i<Dyr; i++){
		ut += dyr[i][0] + "\n";
	}
	return ut;
}

GRUPPER MED COMPARETO

public int compareTo(Dekk d){
	if(this == d) return 0; //LIKE
	if(dekknavn.equals(d.getDekkNavn())) return 0; //LIKE
	return (dekknavn.compareTo(d.getDekkNavn())); //Returnerer -1 eller 1
}

public int compareTo(Kunde k){
	return dekk.compareTo(k.getDekk()); to kunders dekk
}

SORTER

public Kunde[] sorter(){
	Kunde[] sortTab = new Kunde[antKunder]; //Sorteringsarray
	for(int i = 0; i<antKunder; i++){
		sortTab[i] = kunder[i]; //Kopierer inn verdiene
	}
	for(int start = 0; i<antKunder; start++){
		int hittilMinst = start; //Starter på 0
		for(int j = start+1; j<antKunder; j++){
			if(sortTab[j].compareTo(sortTab[start]) < 0) hittilMinst = j; //hvis sortTab[j] er mindre enn sortTab[start]
		}
		Kunde lagring = sortTab[hittilMinst]; //lagring passer på verdien til den minste
		sortTab[hittilMinst] = sortTab[start]; //Setter den som VAR minst verdi på plassen til nye minst verdi
		sortTab[start] = lagring; //Setter minste verdi på plassen til minste
	}
	return sortTab;
}
*/