package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LibraryClass;
import Pages.FlipkartSearchPage;
import Utilities.ReusableFunctions;

public class FlipkartSearchTest extends LibraryClass {
		ReusableFunctions re;
	    FlipkartSearchPage search;
	 
	    // Constructor
	    public FlipkartSearchTest() {
	        // Do NOT initialize driver here, because it's null before @BeforeTest
	        // Initialization should happen after browser is launched
	    }
	 
	    @BeforeClass
	    public void openapp() {
	        initializeBrowser();
//	        openApplication("https://www.flipkart.com/");
	        openApplication();
	        re = new ReusableFunctions(driver);
	        search = new FlipkartSearchPage(driver);
	    }
	 
	    @Test
	    public void searchmobile() {
	        search.search("Mobiles");

	        search.clicksearch(); // Remove null parameter if not required
	    }
	 
	    @AfterClass
	    public void closeapp() throws IOException {
	        re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");
	        re.getTitle();
	        closeBrowser();
	    }
}

