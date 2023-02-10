package stepDefinition;

import driver.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class BasePageSteps {
    protected static final String baseURL = PropertyUtil.getProperty("cartPageURL", "config.properties");

    @Given("navigate to website")
    public void navigate_to_website() {
        WebDriver driver = Driver.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
}
