package stepDefinition;

import cucumber.api.java.en.And;
import driver.Driver;
import hepsiburada.pages.CartPage;
import hepsiburada.pages.ProductInformationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.PropertyUtil;

public class ProductInformationPageSteps {

    private final ProductInformationPage m_productInformationPage = new ProductInformationPage();
    private final CartPage m_cartPage = new CartPage();
    protected static final String baseURL = PropertyUtil.getProperty("iphoneDetailURL", "config.properties");
    private static final int PRODUCT_COMMENTS_LIKE_INDEX = 0;

    @Given("navigate to website")
    public void navigate_to_website() {
        WebDriver driver = Driver.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @And("click to comments")
    public void clickToComments() {
        m_productInformationPage.clickComments();
    }

    @And("click to thumps up")
    public void clickToThumpsUp() {
        m_productInformationPage.clickThumpsUp(PRODUCT_COMMENTS_LIKE_INDEX);
    }

    @And("click to add to cart")
    public void clickToAddToCart() {
        m_productInformationPage.clickAddToCart();
    }

    @When("click to go to cart")
    public void clickToGoToCart() {
        m_productInformationPage.goToCart();

    }

    @Then("verify in cart page")
    public void verifyInCartPage() {
        Assert.assertTrue(m_cartPage.isOnBasketPage(), "Not on the Basket Page");
    }
}
