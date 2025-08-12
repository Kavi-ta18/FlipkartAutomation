package TestRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.Plugin;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestStepFinished;

public class CucumberExtentReportPlugin implements Plugin, ConcurrentEventListener {
    private static ExtentReports extent;
    private static ExtentTest scenarioTest;

    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::onTestStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);
    }

    public CucumberExtentReportPlugin() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    private void onTestCaseStarted(TestCaseStarted event) {
        scenarioTest = extent.createTest(event.getTestCase().getName());
    }

    private void onTestStepFinished(TestStepFinished event) {
        Status status = event.getResult().getStatus();
        if (status == Status.PASSED) {
            scenarioTest.pass("Step passed");
        } else if (status == Status.FAILED) {
            Throwable error = event.getResult().getError();
            scenarioTest.fail(error != null ? error.getMessage() : "Unknown error");
        } else if (status == Status.SKIPPED) {
            scenarioTest.skip("Step skipped");
        }
    }

    private void onTestCaseFinished(TestCaseFinished event) {
        Status status = event.getResult().getStatus();
        if (status == Status.FAILED) {
            Throwable error = event.getResult().getError();
            scenarioTest.fail("Scenario failed: " + (error != null ? error.getMessage() : "Unknown error"));
        }
        extent.flush();
    }
}
