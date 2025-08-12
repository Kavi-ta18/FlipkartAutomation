package Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.LibraryClass;
import Utilities.ReusableFunctions;

public class FlipkartSignUpPage {
	public WebDriver driver;
	ReusableFunctions re;
	Actions action;
	JavascriptExecutor js;
	
	public static final Logger logger = LogManager.getLogger(LibraryClass.class);
	
	public FlipkartSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath="//div[@class='H6-NpN _3N4_BX']")
	WebElement loginElement;
	
	@FindBy(xpath="//span[@class='_1Mikcj']")
	WebElement signUpButton;
	
	public void clickSignUpButton() {
		logger.info(loginElement.getText());
		action.moveToElement(loginElement).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement signUp = wait.until(ExpectedConditions.visibilityOf(signUpButton));
		logger.info(signUpButton.getText());
		signUp.click();
		logger.info("Clicked Sign up button");
	}
}
