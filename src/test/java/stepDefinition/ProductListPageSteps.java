package stepDefinition;

import driver.Driver;
import hepsiburada.pages.ProductListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class ProductListPageSteps {

    private final ProductListPage m_productListPage = new ProductListPage();
    protected static final String baseURL = PropertyUtil.getProperty("iphoneURL", "config.properties");

    @And("click to first product")
    public void clickToFirstProduct() {
        m_productListPage.clickFirstProduct();
    }
}
