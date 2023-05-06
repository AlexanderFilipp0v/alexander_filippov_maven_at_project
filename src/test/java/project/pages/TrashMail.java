package pages;


import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrashMail {

    static WebDriver driver = Driver.getWebDriver();


    public String createDisposableEmail() {
        driver.get("https://trashmail.com/");
        driver.findElement(By.id("fe-mob-forward")).sendKeys("filipppov86@gmail.com");
        driver.findElement(By.id("fe-mob-fwd-nb")).click();
        driver.findElement(By.xpath("//*[@value='10']")).click();
        driver.findElement(By.id("fe-mob-submit")).click();
        return driver.findElement(By.xpath("//h4[@class='text-center']")).getText();
    }
}
