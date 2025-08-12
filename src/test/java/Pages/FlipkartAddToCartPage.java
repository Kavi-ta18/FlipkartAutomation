package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableFunctions;

public class FlipkartAddToCartPage {
	public WebDriver driver;
	ReusableFunctions re;
	
	@FindBy(xpath="(//div[@class='KzDlHZ'])[1]")
	WebElement firstsearch;
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addButton;
	
	public FlipkartAddToCartPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void clickResult() {
		re = new ReusableFunctions(driver);
		re.waitforclickable(firstsearch);
		firstsearch.click();
	}
	
	public void addProduct() {
		re = new ReusableFunctions(driver);
		re.waitforclickable(addButton);
		addButton.click();
	}

}
