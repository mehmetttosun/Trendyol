package mehmet.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;


import utilities.Log4j;

public class BaseTest {
	
	private WebDriver driver;
	
    public void browserlaunch(String browserName){
		if(browserName != null && !browserName.isEmpty()) {
            driver = initializing(browserName);
		}else {
			//throw new Exception("BrowserName can not be null");
			Log4j.error("BrowserName can not be null");
		}
    }
	
    public WebDriver initializing (String browserName) {
		// If the browser is Firefox
        if(browserName.equalsIgnoreCase("Firefox")){
            // Set the path for geckodriver.exe
            System.setProperty("webdriver.firefox.marionette"," E://Selenium//Selenium_Jars//geckodriver.exe ");
            driver = new FirefoxDriver();
        }
        // If the browser is Chrome
        else if(browserName.equalsIgnoreCase("Chrome")){
        	ChromeOptions chromeOptions= new ChromeOptions();
 		    chromeOptions.addArguments("--disable-notifications"); 
 		    chromeOptions.addArguments("--disable-popup-blocking"); 
 		    driver = new ChromeDriver(chromeOptions);
        }
        // If the browser is IE
        else if(browserName.equalsIgnoreCase("IE")){
        	// Set the path for IEdriver.exe
            System.setProperty("webdriver.ie.driver","E://Selenium//Selenium_Jars//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;
	}
	
	
    @AfterClass
    public void finishing () {
        driver.quit();
    }
    
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
