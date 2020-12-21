package mehmet.project;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Log4j;
import org.apache.log4j.Logger;

public class ImageContolAndAddProductTest extends BaseTest {
	
	protected static final Logger log = Logger.getLogger(ImageContolAndAddProductTest.class);
	private HomePage homePage = null;
	private UserLoginPage userLoginPage = null;
	
	@Test
	public void ImageContolAndAddProduct() {


			String username = "mehmett4665@gmail.com";
			String password = "021146";
			String browserName = "Chrome"; //Select the browser; For ChromeBrowser input "Chrome" , For FirefoxBrowser input "Firefox" , For InternerExplorer input "IE"
			
			browserlaunch(browserName);
			homePage = new HomePage(getDriver());
			homePage.connectToURL();
			homePage.closeGenderPopUp();
			homePage.clickSignInButton();
			
			userLoginPage = new UserLoginPage(getDriver());
			userLoginPage.signInAccount(username, password);
			userLoginPage.closeDiscountPopUp();
			
			String accountInfo = homePage.getUserInfo(); 
			Assert.assertEquals(accountInfo, username);
			Log4j.info("The user information has been verified");
									
			homePage.checkAllBoutiqueImagesByHeaderName("KADIN");		
			homePage.checkAllBoutiqueImagesByHeaderName("ERKEK");
            homePage.checkAllBoutiqueImagesByHeaderName("ÇOCUK");
			homePage.checkAllBoutiqueImagesByHeaderName("EV & YAŞAM");
			homePage.checkAllBoutiqueImagesByHeaderName("SÜPERMARKET");
			homePage.checkAllBoutiqueImagesByHeaderName("KOZMETİK");
			homePage.checkAllBoutiqueImagesByHeaderName("AYAKKABI & ÇANTA");
			homePage.checkAllBoutiqueImagesByHeaderName("SAAT & AKSESUAR");
			homePage.checkAllBoutiqueImagesByHeaderName("ELEKTRONİK");
			
			String headerNameToCheckProductInFirstBoutique = "KADIN"; // Select the HeaderName to check all product images in First Boutique
			homePage.checkAllProductImagesInFirstBoutiqueUnderHeaderName(headerNameToCheckProductInFirstBoutique);
			
			homePage.clickProductDetails();			
			homePage.addProductToCart();

			homePage.logOut();
		
		
	}
	
	
}
