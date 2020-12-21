package mehmet.project;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Log4j;


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
	
	protected synchronized boolean checkElementIsExistsByLocator(By locator) {
		Boolean isPresent = driver.findElements(locator).size() > 0;
		return isPresent;
	}
	
	public void sleep(int second) {

		try {

			Log4j.info("SLEEP...");
			long duration = new Long(second).longValue();
			Sleeper.SYSTEM_SLEEPER.sleep(
					new org.openqa.selenium.support.ui.Duration(duration, java.util.concurrent.TimeUnit.SECONDS));
			Log4j.info("Time to wake up!");

		} catch (Exception e) {
			throw new Error("Sleep Error!", e);
		}
		
	}

}
	