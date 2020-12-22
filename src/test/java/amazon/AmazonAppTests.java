package amazon;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.Constants;
import qa.base.TestBase;
import qa.pages.HomePage;
import qa.pages.LoginPage;
import qa.pages.ProductDetailsPage;
import qa.pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

   //TODO Add Price Not Null Assertion and Check if Product is available then proceed

    @Test(priority = 1)
    public void searchForProduct() {
        assertEquals(loginPage.getSignInText(), Constants.LOGIN_LABEL_TEXT);
        homePage = loginPage.skipSignIn();
        assertTrue(homePage.isCartIconDisplayed(),"Cart icon is not displayed");
        homePage.searchProduct(props.getProperty("productName"));
        productsPage = homePage.selectFromSearchSuggestions();
        productDetailsPage = productsPage.selectRandomProduct();
        productDetailsPage.tapOnAddToCart();
        assertTrue(productDetailsPage.isProductAddedToCart(), "Product Not added To Cart");
        productDetailsPage.tapOnCheckOut();
    }
}
