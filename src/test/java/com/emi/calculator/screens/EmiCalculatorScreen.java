package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmiCalculatorScreen extends BaseScreen{
    private By btnDetail =By.id("btnDetail");
    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }
    public EmiCalculatorScreen fillAmount(int amount){
        WebElement etLoanAmount =getWebElement(By.id("etLoanAmount"));
        etLoanAmount.clear();
        etLoanAmount.sendKeys(String.valueOf(amount));
        return this;
    }
    public EmiCalculatorScreen fillInterest(int InterestRate){
        WebElement etInterest =  getWebElement(By.id("etInterest"));
        etInterest.clear();
       etInterest.sendKeys(String.valueOf(InterestRate));
        return this;
    }
    public EmiCalculatorScreen fillYear(int Year){
        WebElement etYears = getWebElement(By.id("etYears"));
        etYears.clear();
        etYears.sendKeys(String.valueOf(Year));
        return this;
    }
    public EmiCalculatorScreen fillMonth(int Month){
        WebElement etMonths = getWebElement(By.id("etMonths"));
        etMonths.clear();
        etMonths.sendKeys(String.valueOf(Month));
        return this;
    }
    public EmiCalculatorScreen fillProcessFee(int ProcessFee){
        WebElement etFee = getWebElement(By.id("etFee"));
        etFee.clear();
        etFee.sendKeys(String.valueOf(ProcessFee));
        return this;
    }
    public EmiCalculatorScreen tapOnCalculateBtn(){
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }
    public EmiCalculatorScreen tapOnResetBtn(){
        getWebElement(By.id("btnReset")).click();
        return this;
    }
    public EmiDetailScreen tapOnDetailBtn(){
        getWebElement(btnDetail).click();
        return getInstance(EmiDetailScreen.class);
    }

    public boolean hasDetailButton(){
        return getWebElements(btnDetail).size()>0;
    }
}
