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
    @FindBy(css = "a[class*='sf-OldMyAccount'] span[id=shoppingCart]")
    private WebElement goToTheCart;
    @FindBy(css = "a[id='breadcrumbFor-apple'] span[itemprop='name']")
    private WebElement productNameText;
    @FindBy(css = "span[class*='hermes-ReviewCard-module-e']")
    private WebElement thumbsLikedText;
    @FindBy(css = "a[class*='sf-OldMyAccount'] span[id=cartItemCount]")
    private WebElement cartCounter;

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
        clickOutside();
    }
    public void goToCart(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(goToTheCart));
        clickElement(goToTheCart);
    }
    public String productInformationNameText(){
        return getText(productNameText);
    }
    public String thumbsLikeText(){
        waitUntil(ExpectedConditions.visibilityOf(thumbsLikedText));
        return getText(thumbsLikedText);
    }
    public String cartCount(){
        scrollUpPage(cartCounter);
        return getText(cartCounter);
    }
}
