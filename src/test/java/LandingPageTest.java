/**
 * Project Name    : first_appium_test
 * Developer       : youvegotnigel
 * Version         : 1.0.0
 * Date            : 09/08/2020
 * Description     :
 **/

import com.github.lkkushan101.appiumlocator.Locator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class LandingPageTest {

    private final String menuItemNamePlaceholder = "#menuItemName";
    private final String menuItemXpath = "//android.widget.TextView[@content-desc=\"" + menuItemNamePlaceholder + "\"]";

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        String PROJECT_ROOT = System.getProperty("user.dir");
        String ANDROID_APK_PATH = "/src/test/resources/ApiDemos.apk";

        DesiredCapabilities caps = new DesiredCapabilities();

        //real device
//        caps.setCapability("deviceName", "31f89655");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "10.0.0");

        //genymotion device
        caps.setCapability("deviceName", "192.168.26.101:5555");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.1");

        caps.setCapability("app", new File(PROJECT_ROOT + ANDROID_APK_PATH).getAbsolutePath());
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("noReset", true);
        caps.setCapability("fullReset", false);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(priority = 1)
    public void toolBarTest() {
        By toolBarTitle = By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView");

        // Wait until application tool bar is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (toolBarTitle));

        // Verify that the tool bar title is API Demos
        Assert.assertEquals(driver.findElement(toolBarTitle).getText(), "API Demos");
    }

    @Test(priority = 1)
    public void accessibilityMenuTest() {
        // Verify Accessibility menu item is visible
        MobileElement accessibilityMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Accessibility")));

        Assert.assertTrue(accessibilityMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void animationMenuTest() {
        // Verify Animation menu item is visible
        MobileElement animationMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Animation")));

        Assert.assertTrue(animationMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void appMenuTest() {
        // Verify App menu item is visible
        MobileElement appMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "App")));

        Assert.assertTrue(appMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void contentMenuTest() {
        // Verify Content menu item is visible
        MobileElement contentMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Content")));

        Assert.assertTrue(contentMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void graphicsMenuTest() {
        // Verify Graphics menu item is visible
        MobileElement graphicsMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Graphics")));

        Assert.assertTrue(graphicsMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void mediaMenuTest() {
        // Verify Media menu item is visible
        MobileElement mediaMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Media")));

        Assert.assertTrue(mediaMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void nfcMenuTest() {
        // Verify NFC menu item is visible
        MobileElement nfcMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "NFC")));

        Assert.assertTrue(nfcMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void osMenuTest() {
        // Verify OS menu item is visible
        MobileElement osMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "OS")));

        Assert.assertTrue(osMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void preferenceMenuTest() {
        // Verify Preference menu item is visible
        MobileElement preferenceMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Preference")));

        Assert.assertTrue(preferenceMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void textMenuTest() {
        // Verify Text menu item is visible
        MobileElement textMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Text")));

        Assert.assertTrue(textMenuItem.isDisplayed());
    }

    @Test(priority = 1)
    public void viewsMenuTest() {
        // Verify Views menu item is visible
        MobileElement viewsMenuItem = driver.findElement
                (By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Views")));

        Assert.assertTrue(viewsMenuItem.isDisplayed());
    }

    @Test(priority = 2)
    public void scrollTest(){

        //click on Views menu
        MobileElement viewsMenuItem = driver.findElement(By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "Views")));
        viewsMenuItem.click();

        //vertical scroll to ScrollBars option

        //capture all list items
        AndroidElement list = (AndroidElement)driver.findElementById("android:id/list");

        //scroll down till element is found
        MobileElement listItem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"ScrollBars\"));"));


        //click on ScrollBars option
        MobileElement scrollBarsMenuItem = driver.findElement(By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "ScrollBars")));
        scrollBarsMenuItem.click();


        By button = By.xpath(menuItemXpath.replace(menuItemNamePlaceholder, "1. Basic"));

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button));

        //verify text "1. Basic" is displayed
        MobileElement basicMenuItem = driver.findElement(button);
        Assert.assertTrue(basicMenuItem.isDisplayed());


    }

    @Test(enabled = false)
    public void appiumLocator()
    {
        Locator.GetAppiumLocators(); //Call this method
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

}