package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

public class ProductDetailsPage extends BasePage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartBtn;

    @FindBy(id = "a-autoid-2-announce")
    private WebElement proceedToCheckOutBtn;

    public ProductDetailsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void tapOnAddToCart() {
        scrollToAnElementByText(driver, "Add to Cart");
        tap(addToCartBtn);
    }

    public void tapOnCheckOut() {
        tap(proceedToCheckOutBtn);
    }
}
