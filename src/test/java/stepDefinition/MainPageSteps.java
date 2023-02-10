package stepDefinition;

import driver.Driver;
import hepsiburada.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import util.PropertyUtil;

public class MainPageSteps {

    private final MainPage m_mainPage = new MainPage();
    private static final String PRODUCT_SEARCH_NAME = "Iphone";
    protected static final String baseURL = PropertyUtil.getProperty("webURL", "config.properties");


    @And("click to accept cookies")
    public void clickToAcceptCookies() {
        m_mainPage.acceptCookies();
    }

    @And("search product and click")
    public void searchProductAndClick() {
        m_mainPage.searchProductNameAndClick(PRODUCT_SEARCH_NAME);
    }


}
