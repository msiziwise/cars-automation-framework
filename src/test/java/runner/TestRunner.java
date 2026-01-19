package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/feature/ui"},
        glue = {"steps"},
        tags = "@Tesing",
        plugin = {"pretty","json:target/cucumber.json","html:target/cucumber-reports.html"}
)
public class TestRunner {
}
