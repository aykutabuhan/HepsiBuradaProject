package hepsiburada.pages;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage{
    protected WebDriver m_driver = Driver.getDriver("Chrome");
    protected WebDriverWait m_WaitPage;
    protected Actions m_actions;
    private static final int DEFAULT_TIMEOUT_DURATION = 10;

    public BasePage(){
        m_WaitPage = new WebDriverWait(m_driver, Duration.ofSeconds(7));
        PageFactory.initElements(m_driver, this);
        m_actions = new Actions(m_driver);
    }
    public void sendKeys(WebElement element, String text){
        element.sendKeys(text);
    }
    public void switchToNewTab(int pageNumber){
        List<String> webPagesName = new ArrayList<>(m_driver.getWindowHandles());
        m_driver.switchTo().window(webPagesName.get(pageNumber));
    }
    public String getText(WebElement element){
        return element.getText();
    }
    public WebElement centerElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) m_driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }
    public void clickElement(WebElement element){
        centerElement(element).click();
    }
    public void navigateTo(String url){
        m_driver.get(url);
    }
    public boolean isDisplayed(WebElement element){

        try {
            waitUntil(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public Wait<WebDriver> waitCondition(final int duration){
        return new FluentWait<>(m_driver)
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(duration))
                .ignoring(NoSuchElementException.class, WebDriverException.class);
    }
    public void waitUntil(final ExpectedCondition<?> expectedCondition, final int duration) {
        waitCondition(duration).until(expectedCondition);
    }
    public void waitUntil(final ExpectedCondition<?> expectedCondition) {
        waitCondition(DEFAULT_TIMEOUT_DURATION).until(expectedCondition);
    }
    public void clickOutside(){
        m_actions.moveByOffset(0,0).click().build().perform();
    }
    public void scrollUpPage(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)m_driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
    }

}
