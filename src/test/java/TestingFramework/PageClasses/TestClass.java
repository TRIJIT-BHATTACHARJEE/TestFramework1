package TestingFramework.PageClasses;

import TestingFramework.StepDef.MyStepdefs;
import TestingFramework.Utility.ConfigPropertiesHelper;
import TestingFramework.Utility.ScreenshotHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestClass {
    public static void launchGoogleWebsite(WebDriver webDriver, ExtentTest test){

//        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        try {
            webDriver.get("https://google.com");
            webDriver.findElement(By.name("q")).sendKeys("Trijit Bhattacharjee" + Keys.ENTER);
            test.log(LogStatus.PASS, "Navigated to the specified URL" , test.addScreenCapture(ScreenshotHelper.capture(webDriver)));
        } catch(Exception e){
            test.log(LogStatus.FAIL, "Test Failed");
            e.printStackTrace();
        }
    }

    public static void readValueFromConfigFile(WebDriver webDriver, ExtentTest testreport) {
        try{
            String value1=ConfigPropertiesHelper.getValueFromConfig("Key1");
            if(value1.length()!=0) {
                testreport.log(LogStatus.PASS, "Value of Key is "+value1, testreport.addScreenCapture(ScreenshotHelper.capture(webDriver)));
            }else{
                testreport.log(LogStatus.FAIL, "Value of Key is "+value1, testreport.addScreenCapture(ScreenshotHelper.capture(webDriver)));

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

