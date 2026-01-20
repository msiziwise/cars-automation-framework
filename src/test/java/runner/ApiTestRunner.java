package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/feature/api"},
        glue = {"api"},
        tags = "@api",
        plugin = {"pretty","json:target/cucumber-reports/api.json","html:target/cucumber-reports/api.html"}
)
public class ApiTestRunner {
}
