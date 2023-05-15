package project.pages.trashmail;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.time.Duration;

public class MainPage {

    private static final Logger LOGGER =
            Logger.getLogger(MainPage.class.getName());
    public static String emailCreation() {
        Driver.getWebDriver().get("https://trashmail.com/");
        LOGGER.trace("Open the https://trashmail.com/");
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fe-mob-forward']")));
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getWebDriver().findElement(By.xpath("//input[@id='fe-mob-forward']")).sendKeys("filipppov86@gmail.com");
        Driver.getWebDriver().findElement(By.xpath("//select[@id='fe-mob-fwd-nb']")).click();
        Driver.getWebDriver().findElement(By.xpath("//select[@id='fe-mob-fwd-nb']/option[@value='1']")).click();
        Driver.getWebDriver().findElement(By.xpath("//select[@id='fe-mob-life-span']")).click();
        Driver.getWebDriver().findElement(By.xpath("//select[@id='fe-mob-life-span']/option[@value='1']")).click();
        Driver.getWebDriver().findElement(By.xpath("//button[@id='fe-mob-submit']")).click();
        return Driver.getWebDriver().findElement(By.xpath("//input[@id='fe-dea']")).getAttribute("value");
    }
}
