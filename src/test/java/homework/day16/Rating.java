package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rating {
    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void hotelRatingTest() {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Берлин");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-result']/div/div[text()='Берлин']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-15']")).click();
        driver.findElement(By.cssSelector("[data-date='2023-05-21']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label/span[2]")).click();
        int rating = Integer.valueOf(driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label//div[@data-testid='filters-group-label-content']")).getText().replaceAll("[^0-9]", ""));
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid='overlay-spinner']"))
        );
        driver.get(driver.findElement(By.xpath("//*[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='title']/..")).getAttribute("href"));
        Assert.assertTrue("Rating is less than 9",
                Integer.valueOf(driver.findElement(By.xpath("//*[@data-testid='review-score-right-component']/div[1]")).getText().replaceAll("[^0-9]", "")) >= rating
        );
    }

    @After
    public void afterTests() {

        driver.quit();
    }

}
