package src;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AndroidBasicInteractionsTest extends BaseTest {
    private AndroidDriver<WebElement> driver;
    private final String SEARCH_ACTIVITY = ".app.SearchInvoke";
    private final String ALERT_DIALOG_ACTIVITY = ".app.AlertDialogSamples";
    private final String OPEN_ACTIVITY = ".ui.activity.SplashAty";
    private final String MAIN_ACTIVITY = ".ui.activity.MainAty";
    private final String PACKAGE = "cn.ibos";

    @BeforeClass
    public void setUp() throws IOException, InterruptedException{
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/main/resources");
        File app = new File(appDir.getCanonicalPath(), "normal_V2.3.4.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "4c9a77d"); //Give Device ID of your mobile phone
        capabilities.setCapability("deviceName", "Android kubangong");
//        capabilities.setCapability("app", app.getAbsolutePath());

        capabilities.setCapability("appPackage", "cn.ibos");
        capabilities.setCapability("appActivity", ".ui.activity.SplashAty");

        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");

        capabilities.setCapability("AppWaitActivity", MAIN_ACTIVITY);
        driver = new AndroidDriver<WebElement>(getServiceUrl(), capabilities);
//        driver.startActivity(new Activity(PACKAGE, OPEN_ACTIVITY));

        AndroidElement contact = (AndroidElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("cn.ibos:id/edtLoginNum")));

        AndroidElement userName = (AndroidElement) driver.findElementById("cn.ibos:id/edtLoginNum");
        userName.sendKeys("18600186000");
        AndroidElement password = (AndroidElement) driver.findElementById("cn.ibos:id/edtLoginPsw");
        password.sendKeys("123456");
        AndroidElement login = (AndroidElement) driver.findElementById("cn.ibos:id/btnLogin");
        login.click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test()
    public void testSendKeys() {
//        driver.startActivity(new Activity(PACKAGE, OPEN_ACTIVITY));
//        driver.startActivity(new Activity(PACKAGE, MAIN_ACTIVITY));

        AndroidElement contact = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("cn.ibos:id/rdibContacts")));
        contact.click();
        AndroidElement search = (AndroidElement) driver.findElementById("cn.ibos:id/txtSearch");
        search.click();
        AndroidElement searchTxt = (AndroidElement) driver.findElementById("cn.ibos:id/et_search");
        searchTxt.sendKeys("李四");
        AndroidElement searchTextValue = (AndroidElement) driver.findElementById("cn.ibos:id/tv_contactName");
        Assert.assertEquals(searchTextValue.getText(), "李四海");
    }

    @Test()
    public void wtest() {
        AndroidElement cancle = (AndroidElement) driver.findElementById("cn.ibos:id/tv_cancel");
        cancle.click();
        AndroidElement search = (AndroidElement) driver.findElementById("cn.ibos:id/txtSearch");
        search.click();
        AndroidElement searchTxt = (AndroidElement) driver.findElementById("cn.ibos:id/et_search");
        searchTxt.setValue("邓");
//        Assert.assertEquals(searchTextValue, "Hello world!");
    }

//    @Test
//    public void testOpensAlert() {
//        // Open the "Alert Dialog" activity of the android app
//        driver.startActivity(new Activity(PACKAGE, ALERT_DIALOG_ACTIVITY));
//
//        // Click button that opens a dialog
//        AndroidElement openDialogButton = (AndroidElement) driver.findElementById("io.appium.android.apis:id/two_buttons");
//        openDialogButton.click();
//
//        // Check that the dialog is there
//        AndroidElement alertElement = (AndroidElement) driver.findElementById("android:id/alertTitle");
//        String alertText = alertElement.getText();
//        Assert.assertEquals(alertText, "Lorem ipsum dolor sit aie consectetur adipiscing\nPlloaso mako nuto siwuf cakso dodtos anr koop.");
//        AndroidElement closeDialogButton = (AndroidElement) driver.findElementById("android:id/button1");
//
//        // Close the dialog
//        closeDialogButton.click();
//    }
}