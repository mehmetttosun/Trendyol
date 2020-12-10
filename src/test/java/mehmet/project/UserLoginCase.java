package mehmet.project;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Log4j;
import org.apache.log4j.Logger;

public class UserLoginCase extends BaseTest {
	
	protected static final Logger log = Logger.getLogger(UserLoginCase.class);
	
	private HomePage homePage = null;
	@Test
	public void UserLoginCase() {
		
		String username = "mehmett4665@gmail.com";
		String password = "Mt021146";
		String expectedAccountName = "Mehmet Tosun";// Assume that we've the user's name and surname
		String productName = "bilgisayar";
		
		homePage = new HomePage(driver);
		homePage.connectToURL();
		homePage.clickSignInButton();
		homePage.signInAccount(username, password);
		
		String accountName = homePage.getTheAccountName(); 
		Assert.assertEquals(accountName, expectedAccountName);
		Log4j.info("The user information has been verified");
		
		homePage.searchAndSelectProduct(productName);
		homePage.addToCartFirstProduct();
		String firstSellerInfo = homePage.getSellerInfo();
		
		homePage.addToCartFromOtherSeller(firstSellerInfo);
		String cartItemCount = homePage.getCartItemCount();
		Assert.assertEquals(cartItemCount, "2"); //Verifying items is in the cart
		homePage.checkTheProducts();
		homePage.logOut();
	}
}
