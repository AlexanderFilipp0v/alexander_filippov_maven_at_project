package day18;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class DemoSteps {
    @Given("I open demoG7 site")
    public void iOpenDemoGSite() {
        System.out.println("I opened the site");
    }

    @When("I fill {string} in the form")
    public void iFillInTheForm(String arg) {
        System.out.printf("Then I printed '%s' string", arg);

    }

    @Then("I need to see something")
    public void iNeedToSeeSomething() {
        Assert.assertTrue(true);
        System.out.println("I finished");
    }
}
