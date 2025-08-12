package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LibraryClass;
import Pages.FlipkartSignUpPage;
import Utilities.ReusableFunctions;

public class FlipkartSignUpPageTest extends LibraryClass{
	ReusableFunctions re;
	FlipkartSignUpPage signUp;
	
	 @BeforeClass
	    public void openapp() {
	        initializeBrowser();
//	        openApplication("https://www.flipkart.com/");
	        openApplication();
	        re = new ReusableFunctions(driver);
	        signUp = new FlipkartSignUpPage(driver);
	    }
	 
	 @Test
	    public void openSignUpPage() throws IOException, InterruptedException {
		 	Thread.sleep(5000);
	    	signUp.clickSignUpButton();
	    	Thread.sleep(5000);
	    	re.takescreenshot("src/test/resources/screenshot/flipkartsignup.png");
	    }
	 
	 @AfterClass
	    public void closeapp(){
	        re.getTitle();
	        closeBrowser();
	    }
}
