package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Driver {
    protected WebDriver m_driver;

    @BeforeClass
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        m_driver = new ChromeDriver();
        m_driver.manage().window().maximize();
    }

    @AfterClass
    public void endDriver(){
        m_driver.quit();
    }
}
