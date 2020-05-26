package TestingFramework.TestRunners;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/FeatureFiles/StoryFile.feature",
        glue = "classpath:TestingFramework",
        plugin = { "pretty", "html:target/cucumber-reports"},
        monochrome = true

)
public class RunnerClass{

}



