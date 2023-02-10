package stepDefinition;

import io.cucumber.java.en.And;
import util.PropertyUtil;

public class CartPageSteps {

    protected static final String baseURL = PropertyUtil.getProperty("cartPageURL", "config.properties");

    @And("click to complete the shopping button")
    public void clickToCompleteTheShoppingButton() {
        // Bunla ilgili method yazılacak(Locator bulunacak)

    }
}
