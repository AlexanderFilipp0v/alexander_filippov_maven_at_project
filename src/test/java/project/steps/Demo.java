package project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import project.driver.Driver;
import project.pages.demo.SelectPage;
import project.objects.Menu;

public class Demo {
    SelectPage selectPage = new SelectPage();
    Menu Menu = new Menu();

    private static final Logger LOGGER =
            Logger.getLogger(Demo.class.getName());

    @Before(value = "@demo")
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The DEMO test has started");
    }

    @Given("I open \"demoQA.com\"")
    public void openDemoQA() {
        selectPage.getUrlToSelectMenu();
        LOGGER.debug("'I open \"demoQA.com\"' running");
    }

    @When("I click on the Select Value Dropdown")
    public void clickSelectValueDropdown() {
        selectPage.clickSelectValueDropdown();
        LOGGER.debug("'I click on the Select Value Dropdown' running");
    }

    @When("I select Group1 Option1")
    public void selectGroup1Option1OfSelectValue() {
        Menu.selectGroup1Option1OfSelectValue();
        LOGGER.debug("'I select Group1 Option1' running");
    }

    @When("I click on the Select One Dropdown")
    public void clickSelectOneDropdown() {
        selectPage.clickSelectOneDropdown();
        LOGGER.debug("'I click on the Select One Dropdown' running");
    }

    @When("I select Dr")
    public void selectDrOfSelectOne() {
        Menu.selectDrOfSelectOne();
        LOGGER.debug("'I select Dr' running");
    }

    @When("I select Blue Of Old Style Select Menu")
    public void selectBlueOfOldStyleSelectMenu() {
        Menu.selectBlueOfOldStyleSelectMenu();
        LOGGER.debug("'I select Blue Of Old Style Select Menu' running");
    }

    @When("I click on the Multi Select Dropdown")
    public void clickMultiSelectDropdown() {
        selectPage.clickMultiSelectDropdown();
        LOGGER.debug("'I click on the Multi Select Dropdown' running");
    }

    @When("I select Green")
    public void selectGreenOfMultiSelectDropdown() {
        Menu.selectGreenOfMultiSelectDropdown();
        LOGGER.debug("'I select Green' running");
    }

    @When("I select Audi in the Standard Multi Select")
    public void selectAudiOfStandardMultiSelect() {
        Menu.selectAudiOfStandardMultiSelect();
        LOGGER.debug("'I select Audi in the Standard Multi Select' running");
    }

    @Then("I check that all fields are selected")
    public void checkAllFields() {
        LOGGER.debug("'I check that all fields are selected' running");
    }

    @After(value = "@demo")
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The DEMO test has finished");
    }
}
