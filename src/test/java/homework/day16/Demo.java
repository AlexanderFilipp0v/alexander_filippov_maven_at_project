package homework.day16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Demo {
    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void selectTest() {
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.id("withOptGroup")).click();
        driver.findElement(By.id("react-select-2-option-0-0")).click();
        driver.findElement(By.id("selectOne")).click();
        driver.findElement(By.id("react-select-3-option-0-0")).click();
        new Select(driver.findElement(By.id("oldSelectMenu"))).selectByValue("1");
        driver.findElement(By.xpath("//*[@id='react-select-4-input']/../../..")).click();
        driver.findElement(By.id("react-select-4-option-0")).click();
        new Select(driver.findElement(By.id("cars"))).selectByValue("audi");
    }

    @After
    public void afterTests() {

        driver.quit();
    }

}
