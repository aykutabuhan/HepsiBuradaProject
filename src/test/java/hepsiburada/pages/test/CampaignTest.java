package hepsiburada.pages.test;

import driver.Driver;
import hepsiburada.pages.MainPage;
import org.testng.annotations.*;

public class CampaignTest extends Driver {

    private MainPage m_mainPage;

    @BeforeClass
    public void loadDriver(){
        setDriver();
        m_mainPage = new MainPage(m_driver);
        m_mainPage.navigateTo(baseUrl);
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
