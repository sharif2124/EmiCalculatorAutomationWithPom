package com.emi.calculator.testcases;

import com.emi.calculator.screens.BaseScreen;
import com.emi.calculator.screens.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver driver;
    Screen screen;
    @BeforeClass
    public void setUpAndroid(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("udid","e6e4dc80");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("platformVersion","10");
            capabilities.setCapability("appPackage","com.continuum.emi.calculator");
            capabilities.setCapability("appActivity","com.finance.emicalci.activity.Splash_screnn");
            capabilities.setCapability("automationName","UiAutomator2");



            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            screen=new BaseScreen(driver);

            //StartRecoding
            driver.startRecordingScreen();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public AndroidDriver getDriver(){
        return driver;
    }
}
