package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen{
    private By btnStart = By.id("btnStart");
    private By btnCompare = By.id("btnCompare");
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorScreen tapOnEmiCalculatorBtn(){
       getWebElement(btnStart).click();
       return getInstance(EmiCalculatorScreen.class);
    }
    public CompareLoansScreen tapOnCompareLoansBtn(){
        getWebElement(btnCompare).click();
        return getInstance(CompareLoansScreen.class);
    }
 public Boolean hasEmiCalculatorBtn(){
      return   getWebElements(btnStart).size()>0;
 }
 public Boolean hasCompareLoansBtn(){
        return getWebElements(btnCompare).size()>0;
 }
}
