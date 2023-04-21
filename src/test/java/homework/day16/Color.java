package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Color {
    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void colorTest() {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Берлин");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Берлин']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-10']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-15']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'",
                driver.findElement(By.xpath("//*[@data-testid='property-card'][10]//descendant:: div[@data-testid='title']")));
        Assert.assertEquals("The text color is wrong", "color: red;", driver.findElement(By.xpath("//*[@data-testid='property-card'][10]//descendant:: div[@data-testid='title']")).getAttribute("style"));


    }

    @After
    public void afterTests() {
        driver.quit();
    }
}



