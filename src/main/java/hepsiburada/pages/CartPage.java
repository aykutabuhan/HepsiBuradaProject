package hepsiburada.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    @FindBy (css = "div[class*=basket] h1")
    private WebElement myBasketLocator;

    public boolean isOnBasketPage(){
        waitUntil(ExpectedConditions.visibilityOf(myBasketLocator), 5);
        return isDisplayed(myBasketLocator);
    }
}
