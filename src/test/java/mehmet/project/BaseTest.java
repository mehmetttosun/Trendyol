package mehmet.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
    public void initializing () {
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.addArguments("--user-agent=Mozilla/5.0 (WghrXkuMnF) AppleWebKit/5.0 Chrome/8.0 Safari/5.0");
		//chromeOptions.addArguments("--start-maximized"); 
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
	}
	
    @AfterClass
    public void finishing () {
        driver.quit();
    }
	
}
