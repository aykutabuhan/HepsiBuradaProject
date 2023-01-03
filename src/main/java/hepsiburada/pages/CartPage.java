package hepsiburada.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    @FindBy (css = "[class=basket_headerTop_15H0U]")
    private WebElement myBasketLocator;

    @FindBy(css = "button[class=\"sc-AxjAm cxvjoB button_next_step_Dj-RE\"]")
    private WebElement goToPaymentButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnBasketPage(){
        m_WaitPage.until(ExpectedConditions.visibilityOf(myBasketLocator));
        return isDisplayed(goToPaymentButton);
    }
}
