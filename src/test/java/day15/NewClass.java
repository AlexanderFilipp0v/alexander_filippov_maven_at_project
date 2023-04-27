package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClass {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Погода Минск", Keys.ENTER);
        driver.findElement(By.xpath("//div[@aria-label='понедельник']")).click();
        WebElement el = driver.findElement(By.xpath("//*[contains(@aria-label, понедельник 12:00')]"));
        String str = el.getText();
        System.out.println(str + "° в 12:00");


    }
}
