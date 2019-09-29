import org.junit.Test;
import org.junit.Assert;

public class LandTestSelv{
	@Test
	public void testRegBy(){
		Land testLand = new Land("Testland", 2, "Hansen");
		By testBy = new By("Testby", 1, 10, "Olsen");
		boolean result = testLand.regBy(testBy);

		Assert.assertTrue(result);
		Assert.assertTrue(testLand.finnes(testBy));

		result = testLand.regBy(testBy);
		Assert.assertFalse(result);
		try{
			By ugyldigBy = new By("Ugyldig By", 10, 1, "Hitler");
			Assert.fail();
		}catch(IllegalArgumentException e){
		}

		By by2 = new By("By2", 1, 10, "Dennis");
		result = testLand.regBy(by2);
		Assert.assertTrue(result);

		By by3 = new By("By3", 1, 15, "Tom");
		result = testLand.regBy(by3);
		Assert.assertFalse(result);
	}
}