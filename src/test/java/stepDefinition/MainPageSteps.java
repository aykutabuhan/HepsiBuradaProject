package stepDefinition;

import cucumber.api.java.en.And;
import driver.Driver;
import hepsiburada.pages.MainPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class MainPageSteps {

    private final MainPage m_mainPage = new MainPage();
    private static final String PRODUCT_SEARCH_NAME = "Iphone";
    protected static final String baseURL = PropertyUtil.getProperty("webURL", "config.properties");

    @Given("navigate to website")
    public void navigate_to_website() {
        WebDriver driver = Driver.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @And("click to accept cookies")
    public void clickToAcceptCookies() {
        m_mainPage.acceptCookies();
    }

    @And("search product and click")
    public void searchProductAndClick() {
        m_mainPage.searchProductNameAndClick(PRODUCT_SEARCH_NAME);
    }


}
