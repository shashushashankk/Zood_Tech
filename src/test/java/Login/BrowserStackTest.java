package Login;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackTest {
    @Test
    void launchAppBrowserStack() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Samsung Galaxy S23 Ultra");
        caps.setCapability("appium:platformVersion", "13.0");
        caps.setCapability("appium:app", "bs://d9c01799a740f253ed04248a6e4e0905cf34cb82");
        caps.setCapability("appium:autoGrantPermissions", true);
// BrowserStack specific options
        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("projectName", "My Appium Project");
        bstackOptions.put("sessionName", "Login Test");
        caps.setCapability("bstack:options", bstackOptions);
        AndroidDriver driver = new AndroidDriver(new URL("http://bharath_OWBVv1:pdiqjyHbRJgqPET6JpsQ@hub.browserstack.com/wd/hub"), caps);
        Thread.sleep(3000);
    }

}
