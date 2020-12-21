package mehmet.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Log4j;

public class UserLoginPage extends BasePage {

	public UserLoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By UserName = By.xpath("//input[@name='login email']");
	private By Password = By.xpath("//input[@name='login-password']");
	private By AccountLoginButton = By.xpath("//button[@type='submit']");
	private By CloseDiscountPopUp = By.xpath("//div[@class='modal-close']");
	
	
	public void signInAccount(String username, String password) {
		waitUntilVisibleByLocator(UserName, 30); //check the expected UyelikGiris URL page
		sendTexttoElement(UserName, username, 30);
		sendTexttoElement(Password, password, 30);
		clickWebElement(AccountLoginButton, 30);
	}
	
	public void closeDiscountPopUp() {
		Boolean discountPopUp = checkElementIsExistsByLocator (CloseDiscountPopUp);
		if(discountPopUp) {
			waitUntilVisibleByLocator(CloseDiscountPopUp, 30);
			clickWebElement(CloseDiscountPopUp, 30);
		}
		else {
			Log4j.info("Discount information pop up has not been seen");
		}
	}


}
