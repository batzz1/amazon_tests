package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.Button[@text='Proceed to checkout']")
    private WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Added to cart']")
    private WebElement addedToCartlabel;

    public ProductDetailsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void tapOnAddToCart() {
        scrollAndClick("Add to Cart");
    }

    public void tapOnCheckOut() {
        tap(proceedToCheckOutBtn);
    }

    public boolean isProductAddedToCart() {
        return waitForElementToBeVisible(addedToCartlabel).isDisplayed();
    }
}
