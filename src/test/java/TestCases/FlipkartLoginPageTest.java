package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LibraryClass;
import Pages.FlipkartLoginPage;
import Utilities.ReusableFunctions;

public class FlipkartLoginPageTest extends LibraryClass{
	ReusableFunctions re;
	FlipkartLoginPage login;
	
	 @BeforeClass
	    public void openapp() {
	        initializeBrowser();
//	        openApplication("https://www.flipkart.com/");
	        openApplication();
	        re = new ReusableFunctions(driver);
	        login = new FlipkartLoginPage(driver);
	    }
	 
	 @Test
	    public void openLoginPage() throws IOException, InterruptedException {
	    	login.clickLoginButton();
	    	Thread.sleep(5000);
	    	re.takescreenshot("src/test/resources/screenshot/flipkartlogin.png");
	    }
	 
	 @AfterClass
	    public void closeapp(){
	        re.getTitle();
	        closeBrowser();
	    }
}
