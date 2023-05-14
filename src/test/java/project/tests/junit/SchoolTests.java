package project.tests.junit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project.driver.Driver;
import project.pages.google.MainPage;
import project.pages.school.SchoolMainPage;

import project.utils.ActionsFor;

public class SchoolTests {
    SchoolMainPage schools = new SchoolMainPage();
    ActionsFor actionsfor = new ActionsFor();
    MainPage google = new MainPage();

    public static final Logger LOGGER = Logger.getLogger(SchoolTests.class.getName());


    @Before
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
        Assert.assertEquals("Some links don't contain the 'Tutorial' word", google.displayedResultsCount().size(),
                google.displayedResultsCountContainsTutorial());

    }
    @After
    public void afterTests() {
        Driver.destroy();
        LOGGER.info("The SCHOOL test has finished");
    }
}
