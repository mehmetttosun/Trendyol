package mehmet.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
    public void initializing () {
		driver = new ChromeDriver();
	}
	
    @AfterClass
    public void finishing () {
        driver.quit();
    }
	
}
