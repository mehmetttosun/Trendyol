package mehmet.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
		
	private HomePage homePage = null;

	@Test
	public void invalidUserandPass() {
		
		homePage = new HomePage(driver);
		int LengthofUser = homePage.selectLengthofUsername();
		int LengthofPass = homePage.selectLengthofPassword();
		String username = homePage.createRandomString(LengthofUser);
		String password = homePage.createRandomString(LengthofPass);

		homePage.connectToURL();
		homePage.inputUserandPass(username, password);
		String message = homePage.getLoginStatus();
		Assert.assertEquals(message, "**Failed Login**");
		
	}
	
	@Test
	public void validUserandInvalidPass() {
		
		int LengthofPass = homePage.selectLengthofPassword();
		String password = homePage.createRandomString(LengthofPass);
		String realUsername = "testuser";
		
		homePage.inputUserandPass(realUsername, password);
		String message = homePage.getLoginStatus();
		Assert.assertEquals(message, "**Failed Login**");
		
	}
	
	@Test
	public void invalidUserandvalidPass() {
		
		int LengthofUser = homePage.selectLengthofUsername();
		String username = homePage.createRandomString(LengthofUser);
		String realPassword = "testpass";
		
		homePage.inputUserandPass(username, realPassword);
		String message = homePage.getLoginStatus();
		//Assert.assertEquals(message, "**Failed Login**");
		Assert.assertEquals(message, "**Failed Login**");
		
	}
	
	@Test
	public void validUserandPass() {
		
		String realUsername = "testuser";
		String realPassword = "testpass";
		
		homePage.inputUserandPass(realUsername, realPassword);
		String message = homePage.getLoginStatus();
		Assert.assertEquals(message, "**Successful Login**");
		
	}
}
