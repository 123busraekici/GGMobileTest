import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverAndLogin {


    public static AppiumDriver appiumDriver;


    @BeforeMethod
    public void Driver () throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("appPackage", "com.gittigidiyormobil");
        caps.setCapability("appActivity","com.gittigidiyormobil.view.startup.SplashScreen");
        caps.setCapability("noReset","false");
        appiumDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        appiumDriver.manage().timeouts().implicitlyWait(60l, TimeUnit.SECONDS);
    }

    @Test
    public void GGTest () throws InterruptedException {
        Login();
        Search();
        Favorite();
    }

    public void Login(){
        MobileElement mobileElement = (MobileElement) appiumDriver.findElementsById("account_icon");
        mobileElement.click();
        MobileElement mobileElement1 = (MobileElement) appiumDriver.findElementsById("llUserAccountLogin");
        mobileElement1.click();
        MobileElement mobileElement2 = (MobileElement) appiumDriver.findElementsById("etLoginEmail");
        mobileElement2.sendKeys("test.busrae@gmail.com");
        MobileElement mobileElement3 = (MobileElement) appiumDriver.findElementsById("etLoginPassword");
        mobileElement3.sendKeys("123456Ab.");
        MobileElement mobileElement4 = (MobileElement) appiumDriver.findElementsById("btnLoginLogin");
        mobileElement4.click();

    }

    public void Search(){
       MobileElement mb=(MobileElement) appiumDriver.findElementsById("actionSearchBoxACT");
       mb.click();
        MobileElement mb1=(MobileElement) appiumDriver.findElementsById("actionSearchBoxACT");
        mb1.sendKeys("Samsung");

    }
    public void Favorite(){
        Search();
        MobileElement mbe=(MobileElement) appiumDriver.findElementsByClassName("android.widget.ImageView[3]");
        mbe.click();
        MobileElement mbe2=(MobileElement) appiumDriver.findElementsById("actionFavorite");
        mbe2.click();

    }

    @AfterMethod
    public void teardown(){
        appiumDriver.quit();
    }
}

