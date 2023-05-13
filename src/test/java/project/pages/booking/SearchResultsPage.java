package project.pages.booking;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.driver.Driver;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage {
    WebDriver driver = Driver.getWebDriver();
    public static final Logger LOGGER = Logger.getLogger(SearchResultsPage.class.getName());

    public static final String MAX_PRICE_PER_NIGHT_XPATH_FLAG = "//*[@id='filter_group_pri_:Rcq:']/div/div[@data-filters-item='pri:pri=5']//descendant::%s";
    public static final String MAX_PRICE_PER_NIGHT_XPATH_SCROLL = "//*[@id='filter_group_price_:Rcq:']//descendant::div[@data-testid='filters-group-histogram']//following-sibling::div/div/%s";

    public void clickOnTheMaxPricePerNight() {
        try {
            driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "span[2]"))).click();

        } catch (NoSuchElementException e) {
            Actions make = new Actions(driver);
            make
                    .clickAndHold(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "div[1]"))))
                    .moveByOffset(200, -25)
                    .release()
                    .build()
                    .perform();
        }
    }

    public void waitForSpinner() {
        WebDriverWait element = new WebDriverWait(driver, Duration.ofSeconds(10));
        element.until(
                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid='overlay-spinner']"))
        );
    }

    public void clickOnTheSortDropdown() {
        driver.findElement(By.cssSelector("[data-testid='sorters-dropdown-trigger']")).click();
    }

    public void clickOnThePriceSorting() {
        driver.findElement(By.cssSelector("[data-id='price']")).click();
    }

    public void assertPricePerNight() {
        int hotelPricePerNight = Integer.parseInt(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7;
        int filterPricePerNight;
        try {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']"))).getText().replaceAll("[^0-9]", ""));
        } catch (NoSuchElementException e) {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]"))).getAttribute("value"));
        }
        Assert.assertTrue("The price per night is more than filter price", hotelPricePerNight >= filterPricePerNight);
    }

    public void assertPricePerNightTestNG() {
        int hotelPricePerNight = Integer.parseInt(driver.findElement(By.xpath("//*[@data-block-id='hotel_list']//descendant::div[@data-testid='property-card'][1]//descendant::span[@data-testid='price-and-discounted-price']")).getText().replaceAll("[^0-9]", "")) / 7;
        int filterPricePerNight;
        try {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_FLAG, "div[@data-testid='filters-group-label-content']"))).getText().replaceAll("[^0-9]", ""));
        } catch (NoSuchElementException e) {
            filterPricePerNight = Integer.parseInt(driver.findElement(By.xpath(String.format(MAX_PRICE_PER_NIGHT_XPATH_SCROLL, "input[1]"))).getAttribute("value"));
        }
        org.testng.Assert.assertTrue(hotelPricePerNight >= filterPricePerNight, "The price per night is more than filter price");

    }

    public List<WebElement> findHotels() {
        return driver.findElements(By.xpath("//*[@data-testid='property-card']"));
    }

    public WebElement findHotel(int numberOfHotel) {

        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]"));
    }

    public WebElement findHotelTitle(int numberOfHotel) {
        return driver.findElement(By.xpath("//*[@data-testid='property-card'][" + numberOfHotel + "]//descendant:: div[@data-testid='title']"));
    }

    public void clickOnTheMaxRating() {
        driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label/span[2]")).click();
    }

    public int getNumberOfMaxRating() {
        return Integer.parseInt(driver.findElement(By.xpath("//div[@id='left']//div[@data-filters-group='review_score']/div[@data-filters-item='review_score:review_score=90']/label//div[@data-testid='filters-group-label-content']")).getText().replaceAll("[^0-9]", ""));
    }

    public void openFirstHotelUrl() {
        driver.get(driver.findElement(By.xpath("//*[@id='search_results_table']//div[@data-testid='property-card'][1]//div[@data-testid='title']/..")).getAttribute("href"));
    }
}
