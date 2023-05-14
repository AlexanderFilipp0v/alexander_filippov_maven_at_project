package project.pages.booking;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.time.Duration;

public class BookingHomePage {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(BookingHomePage.class.getName());

    public void getUrl() {
        driver.get("https://booking.com");
    }

    public void skipSignInOffer() {
        driver.findElement(By.xpath("//div[@role='dialog'][@aria-modal='true']//button")).click();
    }

    public void selectingPlace(String placeName) {
        driver.findElement(By.cssSelector("[name='ss']")).sendKeys(placeName);
        driver.findElement(By.xpath("//*[@data-testid='autocomplete-results']/li[1]/descendant:: div[contains(text(),'" + placeName + "')]")).click();
    }

    public void selectingDate(String date) {
        driver.findElement(By.cssSelector("[data-date='" + date + "']")).click();
    }

    public void clickOnOccupancyDropdown() {
        driver.findElement((By.cssSelector("[data-testid='occupancy-config']"))).click();
    }

    public void clickOnTheAdults() {
        driver.findElement(By.xpath("//input[@id='group_adults']/following-sibling::div/button[2]")).click();
    }

    public void clickOnTheApartments() {
        driver.findElement(By.xpath("//input[@id='no_rooms']/following-sibling::div/button[2]")).click();
    }

    public void clickOnTheSubmit() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public WebElement findCurrency() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='header-currency-picker-trigger']"))
        );
        return driver.findElement(By.cssSelector("[data-testid='header-currency-picker-trigger']"));
    }

    public WebElement findLanguage() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='header-language-picker-trigger']"))
        );

        return driver.findElement(By.cssSelector("[data-testid='header-language-picker-trigger']"));
    }

    public String getCurrencyTooltip() {
        return driver.findElement(By.xpath("//*[@id=':R2cl:']/div")).getText();
    }

    public String getLanguageTooltip() {
        return driver.findElement(By.xpath("//*[@id=':R2kl:']/div")).getText();
    }

    public void clickRegister() {
        driver.findElement(By.xpath("//*[@data-testid='header-sign-up-button']")).click();
    }
}
