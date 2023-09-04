package com.emi.calculator.testcases;

import com.emi.calculator.screens.BaseScreen;
import com.emi.calculator.screens.Screen;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
            driver.startRecordingScreen();
            screen=new BaseScreen(driver);

            //StartRecoding
            driver.startRecordingScreen();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void tearDown(ITestContext iTestContext){
        stopRecording(iTestContext);
        driver.quit();
    }
    private void stopRecording(ITestContext iTestContext) {
        String projectHomeDirectory = System.getProperty("user.dir");
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = projectHomeDirectory + "/build/videos";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        //String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        String filePath = destinationPath + "/" + iTestContext.getSuite().getName() + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AndroidDriver getWebDriver(){
        return driver;
    }
}
