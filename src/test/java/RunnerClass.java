
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty",
        "json:reports/cucumber.json",
        "html:reports/cucumber-report",
        "junit:reports/cucumber.xml"},
        features = {"src/test/java/featureFiles1"}, // Update the directory path to src/test/features
        glue = {"Stepdef"},
        tags = "@nt-thai and not @ignore and not @PCRF")
public class RunnerClass {
}
