package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    public static WebDriver getDriver(String browserName){

        WebDriver driver;

        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            return driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("Safafi")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            return driver = new SafariDriver();
        }
        else 
            return driver = null;
    }
}
