package classwork.day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        return switch (config) {
            case CHROME -> getChromeDriver();
            case FF -> getFirefoxDriver();
            case EDGE -> getEDGEDriver();
            //default -> throw null;
        };
    }

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();

    }

    private static WebDriver getFirefoxDriver() {
        return null;

    }

    private static WebDriver getEDGEDriver() {

        return null;
    }
}
