package stepDefinition;

import cucumber.api.java.en.And;
import driver.Driver;
import hepsiburada.pages.ProductListPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class ProductListPageSteps {

    private final ProductListPage m_productListPage = new ProductListPage();
    protected static final String baseURL = PropertyUtil.getProperty("iphoneURL", "config.properties");

    @Given("navigate to website")
    public void navigate_to_website() {
        WebDriver driver = Driver.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @And("click to first product")
    public void clickToFirstProduct() {
        m_productListPage.clickFirstProduct();
    }
}
