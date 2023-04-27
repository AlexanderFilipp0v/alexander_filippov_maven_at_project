package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Hotels {

    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void hotelTest() {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Берлин");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Берлин']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-05']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-10']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("There are no hotels", driver.findElements(By.cssSelector("[data-testid='property-card']")).size() > 0);
    }

    @After
    public void afterTests() {

        driver.quit();
    }

}


