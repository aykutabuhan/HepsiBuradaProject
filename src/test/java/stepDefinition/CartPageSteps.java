package stepDefinition;

import cucumber.api.java.en.And;
import driver.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class CartPageSteps {

    protected static final String baseURL = PropertyUtil.getProperty("cartPageURL", "config.properties");

    @Given("navigate to cart page")
    public void navigateToCartPage() {
        WebDriver driver = Driver.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @And("click to complete the shopping button")
    public void clickToCompleteTheShoppingButton() {
        // Bunla ilgili method yazılacak(Locator bulunacak)

    }
}
