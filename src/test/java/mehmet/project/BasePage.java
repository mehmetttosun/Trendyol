package mehmet.project;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public WebDriver driver;
	public WebElement element;
	public WebDriverWait driverWait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, 30);
	}
	
	public synchronized WebElement getWebElementByLocator(By locator) {
		return driver.findElement(locator);
	}
	
	public void clickWebElement(By locator, int timeOut) {
		driver.findElement(locator).click();
	}
	
	public void sendTexttoElement(By locator, String key, int timeout) {
		driver.findElement(locator).sendKeys(key);
	}
	
	public String getText(By locator, int timeOut) {
		return driver.findElement(locator).getText();
	}
	
	public void waitUntilVisibleByLocator(By locator, int timeout) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void clearWebElement(By locator, int timeout) {
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
	