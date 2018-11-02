package com;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Start {

    private static AndroidDriver driver;
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/main/resources");
        File app = new File(appDir, "normal_V2.3.4.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("udid", "4c9a77d"); //Give Device ID of your mobile phone
        capabilities.setCapability("deviceName", "小米手机");
        capabilities.setCapability("platformVersion", "5.0.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "cn.ibos");
        capabilities.setCapability("appActivity", ".ui.activity.SplashAty");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(10000);
        driver.quit();

    }

}