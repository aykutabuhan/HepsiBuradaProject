package stepDefinition;

import driver.Driver;
import hepsiburada.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import util.PropertyUtil;

public class CampaignPageSteps {

    private final MainPage m_mainPage = new MainPage();
    private static final String CAMPAIGN_TEXT = "Kampanyalar";
    protected static final String baseURL = PropertyUtil.getProperty("webURL", "config.properties");

    @When("click to campaign button")
    public void clickToCampaignButton() {
        m_mainPage.clickCampaignLocator();
    }
    @Then("verify campaign page")
    public void verifyCampaignPage() {
        Assert.assertEquals(m_mainPage.getCampaignText(), CAMPAIGN_TEXT, "Not on the campaign page!");
    }


}
