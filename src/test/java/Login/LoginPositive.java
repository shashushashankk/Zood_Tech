package Login;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.zoodel.Generic.GlobalVariable;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginPositive extends GlobalVariable {
    {
        log = LogManager.getLogger(this.getClass());
    }

    //    @Test
    void userAbleToLoginTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "android");
        capabilities.setCapability("appium:automationName", "uiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.zoodel.kz.staging_main");
        capabilities.setCapability("appium:appActivity", "com.zoodel.kz.activities.ActivitySplash");
//        capabilities.setCapability("appium:app", appFilePath);
        capabilities.setCapability("appium:noReset", noReset);
        capabilities.setCapability("appium:autoGrantPermissions", autograntPermission);

        androidDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        log.info("Application launched successfully", true);
        log.info("Failed to launch the App. Reason is ", true);
    }
    WebDriver driver;
//    @Test(retryAnalyzer = com.zoodel.Generic.RetryAnalyzer.class)
    void loginSBO() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://staging-main-merchant.zoodmall.com/index.php");
        driver.findElement(By.id("username")).sendKeys("Seller_D4");
        driver.findElement(By.id("password")).sendKeys("Testqa@12345");
        driver.findElement(By.id("submit-form")).click();
        WebElement loader = driver.findElement(By.xpath("//div[@class='spinner']"));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        WebElement inPrep = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='In Preparation ']")));
        inPrep.click();
        driver.findElement(By.name("code")).sendKeys("Z2509000728186");
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
        search.click();
        Assert.fail();
    }
    @Test
    void  image(){
        getText();
        System.out.println("executed");
    }
    @Test
    public String getText(){
        String imagePath = "C:\\Users\\ER\\Downloads\\qr-code.png";
        String link = "";
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            MultiFormatReader reader = new MultiFormatReader();
            Result result = reader.decode(bitmap);
            link = result.getText();
            System.out.println("Successfully Fetched text from QR code "+link);
        } catch (Exception e) {
            System.out.println("Failled to fetch "+e.getLocalizedMessage());
        }
        return link;
    }
//    @AfterMethod
    void closeBrowser(){
        driver.quit();
    }
}