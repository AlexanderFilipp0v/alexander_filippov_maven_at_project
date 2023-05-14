package project.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary"},
        glue = {"homework.project.steps"},
        features = "src/test/resources/features/project.feature"
)

public class CucumberRunner {

}
