package hepsiburada.pages.test;

import driver.Driver;
import util.PropertyUtil;
import hepsiburada.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductAddToCartTest extends Driver{
    private MainPage m_mainPage;
    private ProductListPage m_productListPage;
    private ProductInformationPage m_productInformationPage;
    private BasePage m_basePage;
    private CartPage m_cartPage;
    private static final String PRODUCT_SEARCH_NAME = "Iphone";
    private static final String BRAND_FILTER_NAME = "Marka";
    private static final String PRODUCT_NAME = "Apple iPhone 11";
    private static final String THUMB_LIKE_TEXT = "Teşekkür Ederiz.";
    private static final String DEFAULT_CART_COUNT = "0";
    private static final int PRODUCT_COMMENTS_LIKE_INDEX = 0;
    private static final int SWITCH_WEBPAGE_NUMBER = 1;
    protected static final String baseURL = PropertyUtil.getProperty("webURL", "config.properties");

    @BeforeClass
    public void loadDriver(){
        m_mainPage = new MainPage(getDriver());
        m_productListPage = new ProductListPage(getDriver());
        m_productInformationPage = new ProductInformationPage(getDriver());
        m_basePage = new BasePage(getDriver());
        m_cartPage = new CartPage(getDriver());
        m_mainPage.navigateTo(baseURL);
    }
    @Test
    public void searchProductAndClick(){
        m_mainPage.AcceptCookies();
        m_mainPage.searchProductNameAndClick(PRODUCT_SEARCH_NAME);
        Assert.assertEquals(m_productListPage.productListText(), BRAND_FILTER_NAME,
                "Not on Product List Page");
    }
    @Test
    public void checkAndAddProductInCart() {
        m_productListPage.clickFirstProduct();
        m_basePage.switchToNewTab(SWITCH_WEBPAGE_NUMBER);
        Assert.assertEquals(m_productInformationPage.productInformationNameText(), PRODUCT_NAME,
                "Not on the Product Information Page");
        m_productInformationPage.clickComments();
        m_productInformationPage.clickThumpsUp(PRODUCT_COMMENTS_LIKE_INDEX);
        Assert.assertEquals(m_productInformationPage.thumbsLikeText(), THUMB_LIKE_TEXT,
                "Not clickable thumb button!");
        m_productInformationPage.clickAddToCart();
        Assert.assertNotEquals(m_productInformationPage.cartCount(), DEFAULT_CART_COUNT, "No product added");
        System.out.println(m_productInformationPage.cartCount());
    }
    @Test
    public void goToCart(){
        m_productInformationPage.goToCart();
        Assert.assertTrue(m_cartPage.isOnBasketPage(), "Not on the Basket Page");
    }

}
