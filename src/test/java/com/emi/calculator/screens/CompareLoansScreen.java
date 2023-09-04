package com.emi.calculator.screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareLoansScreen extends BaseScreen{
    public CompareLoansScreen(AndroidDriver driver) {
        super(driver);
    }
    public CompareLoansScreen fillLoan1Amount(int loanAmount){
        WebElement etLoanAmount1 =getWebElement(By.id("etLoanAmount1"));
        etLoanAmount1.clear();
        etLoanAmount1.sendKeys(String.valueOf(loanAmount));
        return this;
    }
    public CompareLoansScreen fillInterest1(int Interest1){
        WebElement etInterest1 =getWebElement(By.id("etInterest1"));
        etInterest1.clear();
        etInterest1.sendKeys(String.valueOf(Interest1));
        return this;
    }
    public CompareLoansScreen fillMonth1(int Month1){
        WebElement etPeriod1 = getWebElement(By.id("etPeriod1"));
        etPeriod1.clear();
        etPeriod1.sendKeys(String.valueOf(Month1));
        return this;
    }
    public CompareLoansScreen fillLoan2Amount(int loanAmount2){
        WebElement etLoanAmount2 = getWebElement(By.id("etLoanAmount2"));
        etLoanAmount2.clear();
        etLoanAmount2.sendKeys(String.valueOf(loanAmount2));
        return this;
    }
    public CompareLoansScreen fillInterest2(int Interest2){
        WebElement etInterest2 = getWebElement(By.id("etInterest2"));
        etInterest2.clear();
        etInterest2.sendKeys(String.valueOf(Interest2));
        return this;
    }
    public CompareLoansScreen fillMonth2(int Month2){
        WebElement etPeriod2 = getWebElement(By.id("etPeriod2"));
        etPeriod2.clear();
        etPeriod2.sendKeys(String.valueOf(Month2));
        return this;
    }
    public CompareLoansScreen tapOnCalculateBtn(){
    getWebElement(By.id("btnCalculate")).click();
    return this;
    }
    public CompareLoansScreen tapOnResetBtn(){
        getWebElement(By.id("btnReset")).click();
        return this;
    }

    public Boolean hasResultLayout(){
       return getWebElements(By.id("layoutTable")).size()>0;
    }
}
