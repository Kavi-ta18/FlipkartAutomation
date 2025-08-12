package TestRunnerJUnit;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

	    features = {"src/test/resources/Features"},      // Path to feature files

	    glue = {"StepDefinitions"}, 

	    		tags = "@smoke",

	    		plugin = {

	    		        "pretty",

	    		        "html:target/cucumber-html-report",

	    		        "json:target/cucumber.json",

	    		        "rerun:target/rerun.txt",

	    		        "TestRunner.CucumberExtentReportPlugin"

	    		       	    		    },

	    		 monochrome = false


	)

	public class JUnitTestRunner {

	    // Empty class - the annotations drive the configuration

}
