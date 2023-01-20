package hepsiburada.pages.test;

import driver.Driver;
import hepsiburada.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.*;

import static hepsiburada.pages.test.ProductAddToCartTest.baseURL;

public class CampaignTest extends Driver {
    private MainPage m_mainPage;
    private static final String CAMPAIGN_TEXT = "Kampanyalar";

    @BeforeClass
    public void loadDriver(){
        m_mainPage = new MainPage(m_driver);
        m_mainPage.navigateTo(baseURL);
    }
    @Test
    public void clickCampaign(){
        m_mainPage.clickCampaignLocator();
        Assert.assertEquals(m_mainPage.getCampaignText(), CAMPAIGN_TEXT, "Not on the campaign page!");
    }
}
