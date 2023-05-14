package project.pages.school;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

public class SchoolMainPage {
    WebDriver driver = Driver.getWebDriver();

    private static final Logger LOGGER =
            Logger.getLogger(SchoolMainPage.class.getName());

    public void getJavaUrl() {
        driver.get("https://www.w3schools.com/java/");
    }

    public WebElement findTutorial() {
        return driver.findElement(By.xpath("//h1/span[contains(text(),'Tutorial')]"));
    }
}
