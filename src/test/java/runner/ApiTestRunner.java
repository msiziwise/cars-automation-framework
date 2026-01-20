package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/feature/api"},
        glue = {"api"},
        tags = "@api",
        plugin = {"pretty","json:target/cucumber.json","html:target/apicucumber-reports.html"}
)
public class ApiTestRunner {
}
