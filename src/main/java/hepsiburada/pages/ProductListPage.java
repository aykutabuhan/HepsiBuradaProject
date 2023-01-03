package hepsiburada.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPage extends  BasePage{

    @FindBy(css ="div[data-test-id='product-info-wrapper'] [data-test-id='product-card-name']")
    protected WebElement productsListLocator;

    @FindBy(css = "div[class=heroContent-scyHeKiKHlG11h80SgmH]")
    private WebElement productNameText;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void selectProductForClick(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(productsListLocator));
        clickElement(productsListLocator);
    }

    public boolean isOnProductListPage(){
        return isDisplayed(productNameText);
    }
}
