package hepsiburada.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    @FindBy(css = "input[placeholder='Ürün, kategori veya marka ara']")
    private WebElement searchSpace;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    @FindBy(css = "[title=\"Kampanyalar\"]")
    private WebElement campaignLocator;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void AcceptCookies(){
        acceptCookies.click();
    }
    public void searchProductName(String productName){
        m_WaitPage.until(ExpectedConditions.visibilityOf(searchSpace));
        sendKeys(searchSpace, productName);
        searchSpace.sendKeys(Keys.ENTER);
    }
    public void clickCampaignLocator(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(campaignLocator));
        clickElement(campaignLocator);
    }
}
