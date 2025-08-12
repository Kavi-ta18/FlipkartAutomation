package TestCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.LibraryClass;
import Pages.FlipkartAddToCartPage;
import Pages.FlipkartResultPage;
import Pages.FlipkartSearchPage;
import Utilities.ReusableFunctions;

public class FlipkartAddToCartTest extends LibraryClass{
	ReusableFunctions re;
	FlipkartSearchPage search;
    FlipkartResultPage result;
    FlipkartAddToCartPage addToCart;
    
 
    @BeforeClass
    public void openapp() {
        initializeBrowser();
//        openApplication("https://www.flipkart.com/");
        openApplication();
        re = new ReusableFunctions(driver);
        search = new FlipkartSearchPage(driver);
        result = new FlipkartResultPage(driver);
        addToCart = new FlipkartAddToCartPage(driver);
    }

    @Test(priority=1)
    public void searchmobile() {
        search.search("Mobiles");
        search.clicksearch(); // Remove null parameter if not required
        logger.info("Search mobile");
    }
 
    @Test(priority=2)
    public void resultclick() throws IOException, InterruptedException {
    	
    	String parent = driver.getWindowHandle();
    	result.clickResult();
    	Thread.sleep(5000);
    	Set<String> childWindows = driver.getWindowHandles();
    	for(String child: childWindows) {
    		if(!child.equals(parent)) {
    			driver.switchTo().window(child);
    			break;
    		}
    	}
    	
    	WebElement title = driver.findElement(By.xpath("//span[@class='VU-ZEz']"));
    	
    	System.out.println(title.getText());
    	re.takescreenshot("src/test/resources/screenshot/flipkartresult.png");
    }
    
    @Test(priority=3)
    public void addToCart() throws IOException, InterruptedException {
    	addToCart.addProduct();
    	Thread.sleep(5000);
    	re.takescreenshot("src/test/resources/screenshot/flipkartcart.png");
    }
    
    @AfterClass
    public void closeapp(){
        re.getTitle();
        closeBrowser();
    }
}
