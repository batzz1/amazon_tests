package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

public class ProductsPage extends BasePage {

    public ProductsPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
