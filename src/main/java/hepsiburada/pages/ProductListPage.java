package hepsiburada.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPage extends  BasePage{
    @FindBy(css ="h3[data-test-id='product-card-name']")
    protected WebElement productsListLocator;
    @FindBy(css = "div[class*=heroContent] div")
    private WebElement productNameText;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }
    public void clickFirstProduct(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(productsListLocator));
        clickElement(productsListLocator);
    }
    public String productListText(){
        return getText(productNameText);
    }

}
