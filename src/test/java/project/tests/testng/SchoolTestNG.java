package project.tests.testng;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.driver.Driver;
import project.pages.google.MainPage;
import project.pages.school.SchoolMainPage;

import project.tests.junit.DemoTests;
import project.utils.ActionsFor;

public class SchoolTestNG {
    SchoolMainPage schools = new SchoolMainPage();
    ActionsFor actionsfor = new ActionsFor();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(SchoolTestNG.class.getName());

    @BeforeTest
    public void beforeTests() {
        Driver.getWebDriver();
        LOGGER.info("The SCHOOL test has started");
    }

    @Test
    public void tutorialTest() {
        schools.getJavaUrl();
        actionsfor.selectingCopyElement(schools.findTutorial());
        google.getUrl();
        actionsfor.selectingPasteElement(google.findSearchField());
        Assert.assertEquals(google.displayedResultsCountContainsTutorial(), google.displayedResultsCount().size(), "Some links don't contain the 'Tutorial' word");
        LOGGER.debug("'tutorialTest' is running");
    }
    @AfterTest
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The SCHOOL test has finished");
    }
}
