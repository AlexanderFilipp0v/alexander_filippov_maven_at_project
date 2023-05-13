package project.pages.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import project.driver.Driver;

public class SelectPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER =
            Logger.getLogger(SelectPage.class.getName());
    public void getUrlToSelectMenu() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void clickSelectValueDropdown() {
        driver.findElement(By.id("withOptGroup")).click();
    }

    public void clickSelectOneDropdown() {
        driver.findElement(By.id("selectOne")).click();
    }

    public void clickMultiSelectDropdown() {
        driver.findElement(By.xpath("//*[@id='react-select-4-input']/../../..")).click();
    }
}
