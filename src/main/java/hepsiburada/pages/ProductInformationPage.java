package hepsiburada.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductInformationPage extends BasePage{

    @FindBy(css = "div[class*='thumbsUp']")
    private List<WebElement> thumbsUpButtons;

    @FindBy(css = "#productReviewsTab")
    private WebElement commentsLocator;

    @FindBy(css = "[id=addToCart]")
    private WebElement addToCartButton;

    @FindBy(css = "[class=checkoutui-ProductOnBasketHeader-zdTSacusLu4Cu0LDpmnB] [type=\"button\"]")
    private WebElement goToTheCart;

    @FindBy(css = "div[id=comments-containe] a")
    private WebElement assessmentField;

    public ProductInformationPage(WebDriver driver) {
        super(driver);
    }

    public void clickComments(){
        clickElement(commentsLocator);
    }
    public void clickThumpsUp(int index){
        clickElement(thumbsUpButtons.get(index));
    }

    public void clickAddToCart(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(addToCartButton));
        clickElement(addToCartButton);
    }

    public void goToCart(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(goToTheCart));
        clickElement(goToTheCart);
    }

    public boolean isOnProductInformationPage(){
        return isDisplayed(addToCartButton);
    }

    public boolean isOnAddProductInformationPage(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(goToTheCart));
        return isDisplayed(assessmentField);
    }
}
