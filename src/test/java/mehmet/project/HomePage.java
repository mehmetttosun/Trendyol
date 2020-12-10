package mehmet.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utilities.Log4j;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	private By PreLoginButton = By.id("myAccount");
	private By LoginButton = By.id("login");
	private By ShoppingCart = By.xpath("//span[contains(@id,'shoppingCart')]");
	private By UserName = By.xpath("//input[@name='username']");
	private By Password = By.xpath("//input[@name='password']");
	private By AccountLoginButton = By.xpath("//button[@name='btnLogin']");
	private By SearchBox = By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']");
	private By SearchButton = By.xpath("//div[contains(@class,'SearchBoxOld-buttonContainer')]");
	private By Selectedproduct = By.xpath("//li[contains(@class,'search-item col lg-1 md-1 sm-1')][1]");
	private By AddToCart = By.xpath("//button[@id='addToCart']");
	private By CloseInfoPopUp = By.xpath("//div[contains(@class,'sf-SalesFrontCash-3zIbr hb_sfc_close')]");
	private By CartItemCount = By.xpath("//span[@id='cartItemCount']");
	private By FirstOfferFromOtherSellers = By.xpath("//tr[contains(@data-bind,'click: $parent.goToMerchant.bind($parent, true)')][1]");
	private By SellerInfo = By.xpath("//span[text()='Satıcı:']/following::a[1]");
	private By FirstProductName = By.xpath("//li[contains(@class,'basket_item_1rDra')][1]/div/div/div/div[contains(@class,'product_name_3Lh3t')]/a");
	private By SecondProductName= By.xpath("//li[contains(@class,'basket_item_1rDra')][2]/div/div/div/div[contains(@class,'product_name_3Lh3t')]/a");
	private By FirstProductSellerName= By.xpath("//li[contains(@class,'basket_item_1rDra')][1]/div/div/div/div[contains(@class,'product_detail_2vvbg')]/div/span/a");
	private By SecondProductSellerName= By.xpath("//li[contains(@class,'basket_item_1rDra')][2]/div/div/div/div[contains(@class,'product_detail_2vvbg')]/div/span/a");
	private By Logout= By.xpath("//li[contains(@class,'sf-OldMyAccount-1PsmN')][5]");
	

	public void connectToURL() {
		String URL = "https://www.hepsiburada.com";
		driver.get(URL);
	}
	
	public void clickSignInButton() {
		waitUntilVisibleByLocator(PreLoginButton, 30); //check the expected URL page
		clickWebElement(PreLoginButton, 30);
		waitUntilVisibleByLocator(LoginButton, 30); //check the list of PreLoginButton
		clickWebElement(LoginButton, 30);
	}
	
	public void signInAccount(String username, String password) {
		waitUntilVisibleByLocator(UserName, 30); //check the expected UyelikGiris URL page
		sendTexttoElement(UserName, username, 30);
		sendTexttoElement(Password, password, 30);
		clickWebElement(AccountLoginButton, 30);
	}
	
	public String getTheAccountName() {
		waitUntilVisibleByLocator(ShoppingCart, 30);
		return driver.findElement(By.xpath("//span[contains(@class,'sf-OldMyAccount-1k66b')]")).getAttribute("innerHTML");
	}
	
	public void searchAndSelectProduct(String productName) {
		sendTexttoElement(SearchBox, productName, 30);
		clickWebElement(SearchButton, 30);
		waitUntilVisibleByLocator(Selectedproduct, 30);
		clickWebElement(Selectedproduct, 30);	
	}
	
	public void addToCartFirstProduct() {
		waitUntilVisibleByLocator(AddToCart, 30);
		clickWebElement(AddToCart, 30);
		waitUntilVisibleByLocator(CloseInfoPopUp, 30);
		clickWebElement(CloseInfoPopUp, 30);
	}
	
	public String getSellerInfo() {
		waitUntilVisibleByLocator(SellerInfo, 30);
		return getText(SellerInfo, 30);
	}
	
	public String getCartItemCount() {
		waitUntilVisibleByLocator(CartItemCount, 30);
		return getText(CartItemCount, 30);
	}
	
	public void addToCartFromOtherSeller(String firstSellerInfo) {
		clickWebElement(FirstOfferFromOtherSellers, 30);
		waitUntilVisibleByLocator(AddToCart, 30);
		
		String secondSellerInfo = getSellerInfo();
		Assert.assertNotEquals(firstSellerInfo, secondSellerInfo);
		
		clickWebElement(AddToCart, 30);	
		waitUntilVisibleByLocator(CloseInfoPopUp, 30);
		clickWebElement(CloseInfoPopUp, 30);
	}
	
	public void checkTheProducts() {
		clickWebElement(ShoppingCart, 30);
		String firstProductName = getText(FirstProductName, 30);
		String secondProductName = getText(SecondProductName, 30);
		String firstProductSellerName = getText(FirstProductSellerName, 30);
		String secondProductSellerName = getText(SecondProductSellerName, 30);
		
			if(!firstProductName.equals(secondProductName) && firstProductSellerName.equals(secondProductSellerName)) {
				Log4j.error("The different products have been added to the basket by the same seller");
			}
			else if(!firstProductName.equals(secondProductName) && !firstProductSellerName.equals(secondProductSellerName)) {
				Log4j.error("The different products have been added to the basket by the different seller");
			}
			else if(firstProductName.equals(secondProductName) && !firstProductSellerName.equals(secondProductSellerName)) {
				Log4j.info("The products have been correctly added to the basket");
			}
			else{
				Log4j.error("Undefined Error");
			}	
	}
	
	public void logOut() {
		clickWebElement(Logout, 30);
	}
		
}

