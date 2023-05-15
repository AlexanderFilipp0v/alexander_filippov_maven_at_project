package project.tests.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.driver.Driver;
import project.objects.Menu;
import project.pages.demo.SelectPage;
import project.tests.junit.DemoTests;

public class DemoTestsNG {
    SelectPage selectPage = new SelectPage();
    Menu Menu = new Menu();
    public static final Logger LOGGER = Logger.getLogger(DemoTestsNG.class.getName());

    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The DEMO test has started");
    }

    @Test
    public void selectTest() {
        selectPage.getUrlToSelectMenu();
        selectPage.clickSelectValueDropdown();
        Menu.selectGroup1Option1OfSelectValue();
        selectPage.clickSelectOneDropdown();
        Menu.selectDrOfSelectOne();
        Menu.selectBlueOfOldStyleSelectMenu();
        selectPage.clickMultiSelectDropdown();
        Menu.selectGreenOfMultiSelectDropdown();
        Menu.selectAudiOfStandardMultiSelect();
        LOGGER.debug("'selectTest' is running");
    }
    @AfterTest
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The DEMO test has finished");
    }
}
