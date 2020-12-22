package qa.base;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriverWait wait;
    public AndroidDriver driver;


    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 40);
    }

    /***
     * Type Text
     * @param element
     * @param text
     */
    public void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element).click();
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Tap on Element
     *
     * @param element
     */
    public void tap(WebElement element) {
        waitForElementToBeClickable(element, 20).clear();
    }

    /**
     * Get Text from a WebElement
     *
     * @param element
     * @return
     */
    public String getText(WebElement element) {
        return waitForElementToBeVisible(element, 20).getText();
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForPresenceOfAllElements(By by) {
        sleep(3000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    /**
     * General method to put thread to sleep
     *
     * @param millis
     */
    public void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
