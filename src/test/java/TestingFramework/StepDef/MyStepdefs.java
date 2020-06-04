package TestingFramework.StepDef;

import TestingFramework.PageClasses.RestApiTestClass;
import TestingFramework.PageClasses.TestClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class MyStepdefs {
    public static WebDriver webDriver;
    public static ExtentTest testreport;
    public static ExtentReports report;
    static{
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
    }
    public MyStepdefs(){}


    @Before
    public void init(Scenario scenario){
        webDriver = new ChromeDriver();
        report = new ExtentReports(System.getProperty("user.dir")+"\\Execution_Reports\\ExtentReportResults.html");
        testreport = report.startTest("Scenario Name : "+scenario.getName());


    }

    @After
    public void tearDown(){
        webDriver.quit();
        report.endTest(testreport);
        report.flush();
    }


    @When("i launch google website")
    public void launchGoogle() {
        TestClass.launchGoogleWebsite(webDriver,testreport);
       // throw new io.cucumber.java.PendingException();
    }

    @When("i try a rest api automation")
    public void iTryARestApiAutomation() {
        RestApiTestClass.getAPIDetails();
    }

    @Then("i read values from config properties file")
    public void iReadValuesFromConfigPropertiesFile() {
        TestClass.readValueFromConfigFile(webDriver,testreport);
    }
}
