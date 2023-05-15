package project.tests.junit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project.driver.Driver;
import project.objects.Menu;
import project.pages.demo.SelectPage;

public class DemoTests {
    SelectPage selectPage = new SelectPage();
    Menu Menu = new Menu();
    public static final Logger LOGGER = Logger.getLogger(DemoTests.class.getName());

    @Before
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
    @After
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The DEMO test has finished");
    }
}
