package mehmet.project;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

    private By UserName = By.xpath("//input[@name='username']");
	private By Password = By.xpath("//input[@name='password']");
	private By LoginButton = By.xpath("//input[@name='FormsButton2']");
	private By LoginStatus = By.xpath("//*[contains(@style,'')]/center/b");
	
	public void connectToURL() {
		String URL = "http://thedemosite.co.uk/login.php";
		driver.get(URL);
	}
	
	public void inputUserandPass(String username, String password) {
		waitUntilVisibleByLocator(UserName, 30); //check the expected URL page
		sendTexttoElement(UserName, username, 30);
		sendTexttoElement(Password, password, 30);
		clickWebElement(LoginButton, 30);	
	}
	
	public String getLoginStatus() {
		return getText(LoginStatus, 30);
	}
	
	public int selectLengthofUsername() {

		Random random = new Random();
		int randomNumber = random.nextInt(16 - 4) + 4;
		return randomNumber;
	}
	
	public int selectLengthofPassword() {

		Random random = new Random();
		int randomNumber = random.nextInt(8 - 4) + 4;
		return randomNumber;
	}

    public String createRandomString(int length) 
    { 
  
        int lowerLimit = 97; 
        int upperLimit = 122; 
  
        Random random = new Random(); 
        StringBuilder r = new StringBuilder(length); 
  
        for (int i = 0; i < length; i++) { 
            int nextRandomChar = lowerLimit + (int)(random.nextFloat() * (upperLimit - lowerLimit + 1)); 
            r.append((char)nextRandomChar); 
        } 
        return r.toString(); 
    } 

}
