package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/feature/ui"},
        glue = {"ui"},
        tags = "@ui",
        plugin = {"pretty","json:target/cucumber.json","html:target/uicucumber-reports.html"}
)
public class UiTestRunner {
}
