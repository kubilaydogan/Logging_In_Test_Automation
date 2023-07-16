package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            option.addArguments("--disable notifications");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, option);
            option.merge(cp);
            driver.set(new ChromeDriver(option));
        }
        return driver.get();
    }

    public static void close() {
        driver.get().quit();
        driver.remove();
    }
}
