package day17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver webDriver;

    private static Config config;

    public static void setConfig(Config config) {

        Driver.config = config;
    }


    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(Config.CHROME);
            setTimeOuts(10);

        }

        return webDriver;
    }

    private static void setTimeOuts(int seconds) {
        if (webDriver != null) {
            webDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }
    }


}
