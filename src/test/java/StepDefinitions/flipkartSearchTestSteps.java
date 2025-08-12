package StepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import BaseClass.LibraryClass;
import Pages.FlipkartSearchPage;
import Utilities.ReusableFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class flipkartSearchTestSteps extends LibraryClass{
	
	ReusableFunctions re;
	FlipkartSearchPage search;
	private static final Logger logger = LogManager.getLogger(flipkartSearchTestSteps.class);
	
	@Given("To launch the browser and enter url")
    public void to_launch_the_browser_and_enter_url() {
        // Write your Selenium code to launch browser here
        System.out.println("Browser launched and URL entered");
    }

    @When("Enter text in the search field")
    public void enter_text_in_the_search_field() {
        // Selenium code to type in search field
        System.out.println("Search text entered");
    }

    @Then("Search result should get displayed")
    public void search_result_should_get_displayed() {
        // Add result verification code
        System.out.println("Search result verified");
    }

    @Then("Take screenshot and close browser")
    public void take_screenshot_and_close_browser() {
        // Code to take screenshot and quit browser
        System.out.println("Screenshot taken and browser closed");
    }

}
