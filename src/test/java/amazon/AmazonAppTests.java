package amazon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.TestBase;

public class AmazonAppTests extends TestBase {

    public AmazonAppTests() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test(priority = 1)
    public void searchForProduct() {

    }
}
