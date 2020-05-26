package TestingFramework.PageClasses;

import TestingFramework.StepDef.MyStepdefs;
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
            webDriver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
            System.out.println(firstResult.getAttribute("textContent"));
            test.log(LogStatus.PASS, "Navigated to the specified URL" , test.addScreenCapture(MyStepdefs.capture(webDriver)));
        } catch(Exception e){
            test.log(LogStatus.FAIL, "Test Failed");
            e.printStackTrace();
        }
    }
}

