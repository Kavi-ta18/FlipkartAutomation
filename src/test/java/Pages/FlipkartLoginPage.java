package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ReusableFunctions;

public class FlipkartLoginPage {
	public WebDriver driver;
	ReusableFunctions re;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginButton;
	
	public FlipkartLoginPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void clickLoginButton() {
		re = new ReusableFunctions(driver);
		re.waitforclickable(loginButton);
		loginButton.click();
	}
}
