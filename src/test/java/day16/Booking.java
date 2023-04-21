package day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public class Booking {

    WebDriver driver = new ChromeDriver();

    @Before
    public void beforeTests() {
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test
    public void search() {
        SimpleDateFormat needFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(new Date());
        myCalendar.add(Calendar.DAY_OF_MONTH, 3);
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys("Париж");
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'Париж')]")).click();
        driver.findElement(By.cssSelector("[data-date='" + needFormat.format(myCalendar.getTime()) + "']")).click();
        myCalendar.add(Calendar.DAY_OF_MONTH, 7);
        driver.findElement(By.cssSelector("[data-date='" + needFormat.format(myCalendar.getTime()) + "']")).click();
        driver.findElement((By.cssSelector("[data-testid='occupancy-config']"))).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            driver.findElement(By.xpath("//*[@id='filter_group_pri_:Rcq:']//descendant::div[@data-filters-item='pri:pri=5']//descendant::span[2]")).click();
        } catch (NoSuchElementException e) {
            Actions make = new Actions(driver);
            make
                    .clickAndHold(driver.findElement(By.xpath("//*[@id='filter_group_price_:Rcq:']//descendant::div[@data-testid='filters-group-histogram']//following-sibling::div/div/div[1]")))
                    .moveByOffset(200, -25)
                    .release()
                    .build()
                    .perform();
        }
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid='overlay-spinner']"))
        );
        driver.findElement(By.cssSelector("[data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.cssSelector("[data-id='price']")).click();
        try {
            Assert.assertTrue("The price per night is more than filter price",
                    Integer.valueOf(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7 >=
                            Integer.valueOf(driver.findElement(By.xpath("//*[@id='filter_group_pri_:Rcq:']//descendant::div[@data-filters-item='pri:pri=5']//descendant::div[@data-testid='filters-group-label-content']")).getText().replaceAll("[^0-9]", ""))
            );
        } catch (NoSuchElementException e) {
            Assert.assertTrue("The price per night is more than filter price",
                    Integer.valueOf(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7 >=
                            Integer.valueOf(driver.findElement(By.xpath("//*[@id='filter_group_price_:Rcq:']//descendant::div[@data-testid='filters-group-histogram']//following-sibling::div/div/input[1]")).getAttribute("value"))
            );
        }
    }

    @After
    public void afterTests() {
        driver.quit();
    }

}
