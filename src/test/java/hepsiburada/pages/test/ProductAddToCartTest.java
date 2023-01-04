package hepsiburada.pages.test;

import driver.Driver;
import util.PropertyUtil;
import hepsiburada.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductAddToCartTest extends Driver{
//cmd + option + shift + L = testng.xml dosyası içinde.
    private MainPage m_mainPage;
    private ProductListPage m_productListPage;
    private ProductInformationPage m_productInformationPage;
    private BasePage m_basePage;
    private static final String PRODUCT_NAME = "Iphone";
    private CartPage m_cartPage;
    protected static final String baseURL = PropertyUtil.getProperty("webURL", "config.properties");


    @BeforeClass
    public void loadDriver(){
        setDriver();
        m_mainPage = new MainPage(m_driver);
        m_productListPage = new ProductListPage(m_driver);
        m_productInformationPage = new ProductInformationPage(m_driver);
        m_basePage = new BasePage(m_driver);
        m_cartPage = new CartPage(m_driver);
        m_driver.get(baseURL);

    }

    @Test
    public void searchProductName(){
        m_mainPage.AcceptCookies();
        m_mainPage.searchProductName(PRODUCT_NAME);
        Assert.assertTrue(m_productListPage.isOnProductListPage(), "Not on Product List Page");
    }

    @Test
    public void choiceProduct(){
        m_productListPage.selectProductForClick();
    }

    @Test
    public void clickCommentButtons(){
        m_basePage.switchToNewTab(1);
        Assert.assertTrue(m_productInformationPage.isOnProductInformationPage(), "Not on the Product Information Page");
        m_productInformationPage.clickComments();
    }

    @Test
    public void clickFirstThumbButton(){
        m_productInformationPage.clickThumpsUp(0);
    }

    @Test
    public void productAddToCart(){
        m_productInformationPage.clickAddToCart();
        Assert.assertTrue(m_productInformationPage.isOnAddProductInformationPage(), "Not on the Go To The Cart Page");

    }

    @Test
    public void goToCart(){
        m_productInformationPage.goToCart();
        Assert.assertTrue(m_cartPage.isOnBasketPage(), "Not on the Basket Page");

    }
    @AfterClass
    public void quitDriver(){
        endDriver();
    }
}
