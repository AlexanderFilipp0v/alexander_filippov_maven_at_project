package classwork.day17;

import org.openqa.selenium.WebDriver;


import java.time.Duration;


public class Driver {

        private static WebDriver webDriver;

        public static Config config;

        public static void setConfig(Config theConfig) {
        config = null == theConfig ? Config.valueOf(System.getProperty("CONFIG")) : theConfig;
    }

        public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
            setTimeOuts(10, 10, 10);
        }
        return webDriver;
    }

        public static void setTimeOuts(int scriptTimeout, int pageLoadTimeout, int implicitlyWait) {
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
    }

    }
