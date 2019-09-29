import org.junit.Assert;
import org.junit.Test;

public class LandTest{
	@Test
	public void testRegBy(){
		Land testLand = new Land("TestLand", 2, "Filip");
		By testBy = new By("TestBy", 1, 10, "Tobias");
		boolean result = testLand.regBy(testBy);

		Assert.assertTrue(result);
		Assert.assertTrue(testLand.finnes(testBy));

		result = testLand.regBy(testBy);
		Assert.assertFalse(result);

		try{
			By ugyldigBy = new By("Ugyldig", 10, 1, "Tobias");
			Assert.fail();
		}catch(IllegalArgumentException e){
		}

		By by2 = new By("By2", 1, 1, "Geir");
		result = testLand.regBy(by2);
		Assert.assertTrue(result);

		By by3 = new By("By3", 1, 1, "Ove");
		result = testLand.regBy(by3);
		Assert.assertFalse(result);
	}
}