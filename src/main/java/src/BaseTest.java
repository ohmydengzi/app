package src;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;

import java.io.IOException;
import java.net.URL;

public abstract class BaseTest {

    private static AppiumDriverLocalService service;

    @BeforeSuite
    public void globalSetup () throws IOException {
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
    }

    @AfterSuite
    public void globalTearDown () {
//        service.stop();
    }

    public URL getServiceUrl () {
//        return service.getUrl();
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e){
            e.getMessage();
        }
        return url;
    }

}
