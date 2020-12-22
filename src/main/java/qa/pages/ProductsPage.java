package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProductsPage extends BasePage {

    @FindBy(id = "item_title")
    private List<WebElement> productTitleList;

    public ProductsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Selects Random Product from the list of displayed Products
     * Selects element from list with a random number between 0 and 3
     * This can be enhanced later, the development was done on a simulator hence only 4 products are displayed
     */
    //TODO Add scroll and select random product
    public ProductDetailsPage selectRandomProduct() {
        waitForPresenceOfAllElements(By.id("item_title"));
        int randomIndex = ThreadLocalRandom.current().nextInt(0, 4);
        tap(productTitleList.get(randomIndex));
        return new ProductDetailsPage(driver);
    }
}
