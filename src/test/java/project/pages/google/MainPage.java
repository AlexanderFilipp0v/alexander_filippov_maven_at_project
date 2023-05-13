package project.pages.google;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver = Driver.getWebDriver();

    private static final Logger LOGGER =
            Logger.getLogger(MainPage.class.getName());

    public void getUrl() {
        driver.get("https://google.com");
    }

    public WebElement findSearchField() {
        return driver.findElement(By.cssSelector("[name='q']"));
    }

    public List<WebElement> displayedResultsCount() {
        List<WebElement> allResults = driver.findElements(By.xpath("//*[@id='rso']/div//descendant:: a[@href]/h3"));
        List<WebElement> displayedResults = new ArrayList<>();
        for (WebElement item : allResults) {
            if (item.isDisplayed()) {
                displayedResults.add(item);
            }
        }
        return displayedResults;
    }

    public int displayedResultsCountContainsTutorial() {
        int counter = 0;
        for (WebElement item : displayedResultsCount()) {
            if (item.getText().toLowerCase().contains("tutorial")) {
                counter++;
            }
        }
        return counter;
    }
}
