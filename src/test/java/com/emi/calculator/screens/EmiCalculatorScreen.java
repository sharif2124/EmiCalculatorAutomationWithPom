package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiCalculatorScreen extends BaseScreen{
    private By btnDetail =By.id("btnDetail");
    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }
    public EmiCalculatorScreen fillAmount(int amount){
        getWebElement(By.id("etLoanAmount")).sendKeys(String.valueOf(amount));
        return this;
    }
    public EmiCalculatorScreen fillInterest(int InterestRate){
        getWebElement(By.id("etInterest")).sendKeys(String.valueOf(InterestRate));
        return this;
    }
    public EmiCalculatorScreen fillYear(int Year){
        getWebElement(By.id("etYears")).sendKeys(String.valueOf(Year));
        return this;
    }
    public EmiCalculatorScreen fillMonth(int Month){
        getWebElement(By.id("etMonths")).sendKeys(String.valueOf(Month));
        return this;
    }
    public EmiCalculatorScreen fillProcessFee(int ProcessFee){
        getWebElement(By.id("etFee")).sendKeys(String.valueOf(ProcessFee));
        return this;
    }
    public EmiCalculatorScreen tapOnCalculateBtn(){
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }
    public EmiCalculatorScreen tapOnResestBtn(){
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
