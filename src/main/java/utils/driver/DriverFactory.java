package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
    public static RemoteWebDriver getDriver() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/mac/chromedriver");

        String browser = System.getenv("BROWSER");
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        if ("CHROME".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("FIREFOX".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        return null;
    }

}