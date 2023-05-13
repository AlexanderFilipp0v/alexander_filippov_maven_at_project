package project.pages.booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import project.driver.Driver;

public class RegistrationPage {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(RegistrationPage.class.getName());

    public void enterEmail(String myEmail) {
        driver.findElement(By.id("username")).sendKeys(myEmail);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void clickSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("new_password")).sendKeys(password);
        driver.findElement(By.id("confirmed_password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public WebElement getCaptcha() {
        return driver.findElement(By.xpath("//div[@aria-label='Нажать и удерживать']"));
    }
}
