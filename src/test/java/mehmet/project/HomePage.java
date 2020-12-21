package mehmet.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Log4j;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
    private By CloseGenderPopUp = By.xpath("//a[@class='fancybox-item fancybox-close']");
	private By PreLoginButton = By.id("accountBtn");
	private By MyAccount = By.xpath("//span[text()='Hesabım']");
	private By HeaderList = By.xpath("//ul[contains(@class,'main-nav')]/li");
	private By ActiveHeaderTab = By.xpath("//li[@class='tab-link active']/a");
	private By BigComponentList = By.xpath("//div[@class='component-list component-big-list']/article/a/span");
	private By SmallComponentList = By.xpath("//div[@class='component-list component-small-list']/article/a/span");
	private By BannerComponentList = By.xpath("//div[@class='banner-item loaded']/a");
	private By FirstBoutique = By.xpath("//div[@class='component-list component-big-list']/article[@class='component-item'][1]");
	private By BoutiqueProductList = By.xpath("//div[@class='image-container']");
	private By FirstProductInBoutique = By.xpath("//div[@class='image-container'][1]");
	private By AddToCart = By.xpath("//button[@class='pr-in-btn add-to-bs']");
	private By ProductNameOnDetailsPage = By.xpath("//h1[@class='pr-new-br']/span");
	private By ProductNameOnCartPage= By.xpath("//a[@class='pb-basket-item-details'][1]/p[1]/span");
	private By ShoppingCart = By.xpath("//li[@id='myBasketListItem']");
	private By Logout= By.xpath("//div[@class='account-link-container logout-link']");

	
	public void connectToURL() {
		String url = "https://www.trendyol.com";
		driver.get(url);
	}
	
	public void closeGenderPopUp() {
		sleep(5);
		Boolean genderPopUp = checkElementIsExistsByLocator (CloseGenderPopUp);
		if(genderPopUp) {
			clickWebElement(CloseGenderPopUp, 30);
			Log4j.info("Gender selection pop up was closed");
		}
		else {
			Log4j.info("Gender selection pop up has not been seen");
		}
	}
	
	public void clickSignInButton() {
		waitUntilVisibleByLocator(PreLoginButton, 30); //check the expected URL page
		clickWebElement(PreLoginButton, 30);
	}
	
	public String getUserInfo() {
		waitUntilVisibleByLocator(MyAccount, 30);
		return driver.findElement(By.xpath("//div[@class='user-email']")).getAttribute("innerHTML");
	}
	
	public void clickHeaderTab(String headerName) {
		
		List<WebElement> elementName = driver.findElements(HeaderList);
		int i = 0;
		for(i=0; i<elementName.size(); i++) {
			WebElement element = elementName.get(i);
			String headerText = element.findElement(By.tagName("a")).getText();
			if(headerText.equals(headerName)) {
				element.click();
				Log4j.info("The "+headerName+" button has been clicked");
				break;
			}
		}
	}
	
	public void checkImagesByComponentType(By locator){
		List<WebElement> elementName = driver.findElements(locator);
		int i = 0;
		for(i=0; i<elementName.size(); i++) {
			WebElement element = elementName.get(i);
			Boolean Image = element.findElement(By.tagName("img")).isEnabled();
			if(!Image){
				Log4j.error("Image was not found");
			}	
		}
		Log4j.info("All Image are avaliable in this Component ");
	}
	
	public void checkAllBoutiqueImagesByHeaderName(String requestedHeader){
		clickHeaderTab(requestedHeader);
		sleep(10); 
		String activeHeaderName = getText(ActiveHeaderTab, 30); // Verifying the header name
		if(activeHeaderName.equals(requestedHeader)) {
			Log4j.info("Verified that the "+requestedHeader+" button is the active Header");
			checkImagesByComponentType(BigComponentList);
			checkImagesByComponentType(BannerComponentList);
			checkImagesByComponentType(SmallComponentList);
		}
		else {
			Log4j.error("The Requested Header is the different from Active Header !! Please check Header Tab");
		}
	}
	
	public void checkAllProductImagesInFirstBoutiqueUnderHeaderName(String requestedHeader) {
		
		clickHeaderTab(requestedHeader);
		sleep(5); 
		String activeHeaderName = getText(ActiveHeaderTab, 30); // Verifying the header name
		if(activeHeaderName.equals(requestedHeader)) {
			Log4j.info("Verified that the "+requestedHeader+" button is the active Header");
			clickWebElement(FirstBoutique, 30);
			Log4j.info("The First Boutique has been clicked in the "+requestedHeader+" button ");
			sleep(5); // This sleep was added directly, since there is no fixed locator for each boutique when clicking on the boutiques.
			checkImagesByComponentType(BoutiqueProductList);
		}
		else {
			Log4j.error("The Requested Header is the different from Active Header !! Please check Header Tab");
		}
	}
	
	public void clickProductDetails() {
		waitUntilVisibleByLocator(FirstProductInBoutique, 30);
		clickWebElement(FirstProductInBoutique, 30);	
	}
	
	public String getProductNameOnDetailsPage() {
		waitUntilVisibleByLocator(ProductNameOnDetailsPage, 30);
		return getText(ProductNameOnDetailsPage, 30);
	}
	
	public String getProductNameOnCartPage() {
		waitUntilVisibleByLocator(ProductNameOnCartPage, 30);
		return getText(ProductNameOnCartPage, 30);
	}
	
	public void addProductToCart() {
		waitUntilVisibleByLocator(AddToCart, 30);
		clickWebElement(AddToCart, 30);
		sleep(5);
	}
	
	public void clickShoppingCart() {
		waitUntilVisibleByLocator(ShoppingCart, 30);
		clickWebElement(ShoppingCart, 30);
	}
	
	public void clickFirstBoutique() {
		clickWebElement(FirstBoutique, 30);
	}
	
    public void logOut() {
		clickWebElement(Logout, 30);
	}
		
}

