package qa.base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestBase {

    public static AndroidDriver driver;
    public static Properties props;

    public TestBase() {
        try {
            props = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                    + "src/main/resources/config.properties");
            props.load(fileInputStream);
        } catch (FileNotFoundException fNException) {
            fNException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void initialization() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        System.out.printf("This " + props.getProperty("androidAutomationName"));
        System.out.printf("This " + props.getProperty("androidAppPackage"));
        System.out.printf("This " + props.getProperty("androidAppActivity"));
        desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
        desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
        desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
        desiredCapabilities.setCapability("app", props.getProperty("androidAppLocation"));
        try {
            driver = new AndroidDriver(new URL(props.getProperty("appiumURL")), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
