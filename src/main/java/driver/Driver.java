package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    protected WebDriver m_driver;
    protected String baseUrl = "https://www.hepsiburada.com/";

    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/util/chromedriver");
        m_driver = new ChromeDriver();
        m_driver.manage().window().maximize();
    }

    public void endDriver(){
        m_driver.quit();
    }
}
