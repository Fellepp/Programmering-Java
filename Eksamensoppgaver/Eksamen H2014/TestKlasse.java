import org.junit.*;

public class TestKlasse{
	ContainerSkip instance;
	double delta = 0.0001;

	@Before
	public void setUp(){
		instance = new ContainerSkip("Frakt AS", 15, 20000);
		instance.regContainer(new Container(1, "Bananer", 1, "Oslo"));
		instance.regContainer(new Container(2, "Epler", 2, "Oslo"));
		instance.regContainer(new Container(3, "Pærer", 5, "Oslo"));
		instance.regContainer(new Container(4, "Ananas", 1, "Oslo"));
	}

	@After
	public void tearDown(){
		instance = null;
	}

	@Test
	public void testGetNavn(){
		System.out.println("Navn");
		String expResult = "Frakt AS";
		String result = instance.getNavn();
		Assert.assertEquals(expResult,result);
	}

	@Test
	public void testGetVektMaks(){
		System.out.println("Lastekapasitet");
		int expResult = 15;
		int result = instance.getVektMaks();
		Assert.assertEquals(expResult,result);
	}
}