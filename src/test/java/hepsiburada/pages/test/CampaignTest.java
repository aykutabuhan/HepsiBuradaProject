package hepsiburada.pages.test;

import driver.Driver;
import hepsiburada.pages.MainPage;
import org.testng.annotations.*;

import static hepsiburada.pages.test.ProductAddToCartTest.baseURL;

public class CampaignTest extends Driver {

    private MainPage m_mainPage;

    @BeforeClass
    public void loadDriver(){
        setDriver();
        m_mainPage = new MainPage(m_driver);
        m_mainPage.navigateTo(baseURL);
    }

    @Test
    public void clickCampaign(){
        m_mainPage.clickCampaignLocator();
    }

    @AfterClass
    public void quitDriver(){
        endDriver();
    }
}
