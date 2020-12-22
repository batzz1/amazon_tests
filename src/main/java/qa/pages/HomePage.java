package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "rs_search_src_text")
    private WebElement searchBox;

    @FindBy(id = "iss_search_dropdown_item_text")
    private List<WebElement> searchBoxSuggestions;

    public HomePage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        tap(searchBox);
        sendKeys(searchBox, productName);
    }

    public ProductsPage selectFromSearchSuggestions() {
        waitForPresenceOfAllElements(By.id("iss_search_dropdown_item_text"));
        tap(searchBoxSuggestions.get(0));
        return new ProductsPage(driver);
    }
}
