package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/feature/ui"},
        glue = {"ui"},
        tags = "@ui",
        plugin = {"pretty","json:target/cucumber-reports/ui.json","html:target/cucumber-reports/ui"}
)
public class UiTestRunner {
}
