package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class School {

    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tutorialTest() {
        driver.get("https://www.w3schools.com/java/");
        Actions make = new Actions(driver);
        make
                .doubleClick(driver.findElement(By.xpath("//h1/span[contains(text(),'Tutorial')]")))
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        driver.get("https://google.com");
        make
                .click(driver.findElement(By.cssSelector("[name='q']")))
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .build()
                .perform();
        int counter = 0;
        for (int i = 1; i <= driver.findElements(By.xpath("//*[@id='rso']/div//descendant:: h3")).size() - 1; i++) {
            if (driver.findElement(By.xpath("//*[@id='rso']/div[" + i + "]//descendant:: h3")).getText().toLowerCase().contains("tutorial")) {
                counter++;
            }
        }
        Assert.assertEquals("Some links don't contain the 'Tutorial'",
                driver.findElements(By.xpath("//*[@id='rso']/div//descendant:: h3")).size() - 1, counter);
    }

    @After
    public void afterTests() {

        driver.quit();
    }

}
