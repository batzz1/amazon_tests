package qa.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static AndroidDriver driver;
    public static Properties props;

    public TestBase() {
        try {
            props = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                    + "/src/main/resources/config.properties");
            props.load(fileInputStream);
        } catch (FileNotFoundException fNException) {
            fNException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void initialization() {
        String appPath = System.getProperty("user.dir") + File.separator + "app" + File.separator;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
        desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
        desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
        desiredCapabilities.setCapability("app", props.getProperty("androidAppLocation"));
        desiredCapabilities.setCapability("app", appPath +
                props.getProperty("appName"));

        try {
            driver = new AndroidDriver(new URL(props.getProperty("appiumURL")), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
