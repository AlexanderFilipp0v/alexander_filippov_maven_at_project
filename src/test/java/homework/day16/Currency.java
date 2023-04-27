package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Currency {
    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver);

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
    }

    @Test
    public void currencyTest() {
        actions.moveToElement(driver.findElement(By.cssSelector("[data-testid='header-currency-picker-trigger']")));
        actions.perform();
        String tooltip = driver.findElement(By.xpath("//*[@id=':R2cl:']/div")).getText();
        Assert.assertEquals("Incorrect tooltip", "Выберите валюту", tooltip);
    }

    @Test
    public void languageTest() {
        actions.moveToElement(driver.findElement(By.cssSelector("[data-testid='header-language-picker-trigger']")));
        actions.perform();
        String tooltip = driver.findElement(By.xpath("//*[@id=':R2kl:']/div")).getText();
        Assert.assertEquals("Incorrect tooltip", "Выберите язык", tooltip);
    }

    @After
    public void afterTests() {
        driver.quit();
    }

}
