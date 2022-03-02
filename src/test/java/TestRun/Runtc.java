package TestRun;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty", "html:test-output"},
        tags = "@regression"
)
public class Runtc {
}
