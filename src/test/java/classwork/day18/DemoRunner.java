package day18;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"day18"},
        features = {"src/test/resources/features/first.feature"}
        //tags = "@QA"
)
public class DemoRunner {
}
