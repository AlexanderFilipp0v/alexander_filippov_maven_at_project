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
    }

    @When("I click on the Select Value Dropdown")
    public void clickSelectValueDropdown() {
        selectPage.clickSelectValueDropdown();
    }

    @When("I select Group1 Option1")
    public void selectGroup1Option1OfSelectValue() {
        Menu.selectGroup1Option1OfSelectValue();
    }

    @When("I click on the Select One Dropdown")
    public void clickSelectOneDropdown() {
        selectPage.clickSelectOneDropdown();
    }

    @When("I select Dr")
    public void selectDrOfSelectOne() {
        Menu.selectDrOfSelectOne();
    }

    @When("I select Blue Of Old Style Select Menu")
    public void selectBlueOfOldStyleSelectMenu() {
        Menu.selectBlueOfOldStyleSelectMenu();
    }

    @When("I click on the Multi Select Dropdown")
    public void clickMultiSelectDropdown() {
        selectPage.clickMultiSelectDropdown();
    }

    @When("I select Green")
    public void selectGreenOfMultiSelectDropdown() {
        Menu.selectGreenOfMultiSelectDropdown();
    }

    @When("I select Audi in the Standard Multi Select")
    public void selectAudiOfStandardMultiSelect() {
        Menu.selectAudiOfStandardMultiSelect();
    }

    @Then("I check that all fields are selected")
    public void checkAllFields() {
    }

    @After(value = "@demo")
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The DEMO test has finished");
    }
}
