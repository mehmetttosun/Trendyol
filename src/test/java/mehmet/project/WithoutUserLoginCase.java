package mehmet.project;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Log4j;
import org.apache.log4j.Logger;

public class WithoutUserLoginCase extends BaseTest {
	
	protected static final Logger log = Logger.getLogger(WithoutUserLoginCase.class);
	
	private HomePage homePage = null;
	
	@Test
	public void WithoutUserLoginCase() {
		
		String productName = "bilgisayar";
		homePage = new HomePage(driver);
		homePage.connectToURL();
		
		homePage.searchAndSelectProduct(productName);
		homePage.addToCartFirstProduct();
		String firstSellerInfo = homePage.getSellerInfo();
		
		homePage.addToCartFromOtherSeller(firstSellerInfo);
		String cartItemCount = homePage.getCartItemCount();
		Assert.assertEquals(cartItemCount, "2"); //Verifying items is in the cart
		homePage.checkTheProducts();
		
	}

}
