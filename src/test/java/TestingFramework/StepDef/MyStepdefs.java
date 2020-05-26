package TestingFramework.StepDef;

import TestingFramework.PageClasses.TestClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
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
    public static ExtentTest test;
    public static ExtentReports report;
    static{
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
    }
    public MyStepdefs(){}


    @Before
    public void init(Scenario scenario){
        webDriver = new ChromeDriver();
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("Scenario Name : "+scenario.getName());


    }

    @After
    public void tearDown(){
        webDriver.quit();
        report.endTest(test);
        report.flush();
    }

    public static String capture(WebDriver driver) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
                + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }



    @When("i launch google website")
    public void launchGoogle() {
        TestClass.launchGoogleWebsite(webDriver,test);
       // throw new io.cucumber.java.PendingException();
    }
}
