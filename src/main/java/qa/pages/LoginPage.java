package qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "skip_sign_in_button")
    private WebElement skipSignInBtn;

    public LoginPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage skipSignIn() {
        tap(skipSignInBtn);
        return new HomePage(driver);
    }
}
