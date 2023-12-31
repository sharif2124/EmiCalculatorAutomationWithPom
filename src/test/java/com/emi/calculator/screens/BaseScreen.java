package com.emi.calculator.screens;

import com.aventstack.extentreports.Status;
import com.emi.calculator.report.ReportTestManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseScreen extends Screen {
    public BaseScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            waitForWebElement(locator);
            webElement= driver.findElement(locator);
            addInfoLog("has been located " + locator.toString());
        }catch (Exception exception){
            System.out.println(locator.toString()+"No Data Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
      List<WebElement> webElements = null;
      try {
          waitForWebElement(locator);
          webElements=driver.findElements(locator);
      }catch (Exception exception){
          System.out.println(locator.toString()+"No Data Found");
      }
        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            System.out.println(locator.toString()+"Not Loading");
        }
    }
    public void addInfoLog(String message) {
        if (ReportTestManager.getTest() != null)
            ReportTestManager.getTest().log(Status.INFO, message);
    }
}
