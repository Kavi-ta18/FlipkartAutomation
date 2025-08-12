package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;

import BaseClass.LibraryClass;
import Pages.FlipkartSearchPage;
import Utilities.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchwithdatatable extends LibraryClass{
	ReusableFunctions re;
    FlipkartSearchPage search;
	@Given("I launch the browser and navigate to the application URL")
	public void launch_the_browser_and_enter_url() {
//		 initializeBrowser();
//	        openApplication();
	        logger.info("Application Launched");
	        re = new ReusableFunctions(driver);
	        search = new FlipkartSearchPage(driver);
	}  

 
	@When("I enter the following text in the Search field")
	public void enter_in_the_search_field(io.cucumber.datatable.DataTable dataTable) {
		 List<String> searchItems = dataTable.asList();
		    for (String item : searchItems) {
		        // your logic to enter text and search
		    	search.search(item);
		    	logger.info("Searched " + item);
			    search.clicksearch();
			    logger.info("Clicked Search");
		        // wait or validation logic here
		    }
	}

	@Then("The corresponding search results should be displayed")
	public void search_result_should_be_displayed() {
	    re.getTitle();
	    logger.info("Navigated to result page");
	}

	@Then("I verify the search")
	public void verify_the_reult() {
	    logger.info("Verified Result");
	}

}
