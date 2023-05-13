package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import project.driver.Driver;
import project.pages.google.MainPage;
import project.pages.school.SchoolMainPage;
import project.utils.ActionsFor;

public class School {
    SchoolMainPage schools = new SchoolMainPage();
    ActionsFor actions = new ActionsFor();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(School.class.getName());

    @Before(value = "@schools")
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The SCHOOL test has started");
    }

    @Given("I open the \"w3schools.com\"")
    public void openW3Schools() {
        schools.getJavaUrl();
    }

    @When("I copy \"Tutorial\" word")
    public void copyTutorial() {
        actions.selectingCopyElement(schools.findTutorial());
    }

    @When("I open the \"google.com\"")
    public void openGoogle() {
        google.getUrl();
    }

    @When("I paste \"Tutorial\" to the search field and click the Enter")
    public void pasteTutorial() {
        actions.selectingPasteElement(google.findSearchField());
    }

    @Then("I check that all result links contain the word \"Tutorial\"")
    public void checkResults() {
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());
    }

    @After(value = "@schools")
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The SCHOOL test has finished");
    }
}
