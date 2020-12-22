package amazon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.ProductDetailsPage;
import qa.pages.ProductsPage;

public class AmazonAppTests extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;

    public AmazonAppTests() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void searchForProduct() {
        homePage = loginPage.skipSignIn();
        homePage.searchProduct("65-inch tv");
        productsPage = homePage.selectFromSearchSuggestions();
        productDetailsPage = productsPage.selectRandomProduct();
        productDetailsPage.tapOnAddToCart();
    }
}
