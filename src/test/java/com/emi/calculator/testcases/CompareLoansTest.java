package com.emi.calculator.testcases;

import com.emi.calculator.screens.CompareLoansScreen;
import com.emi.calculator.screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoansTest extends BaseTest{
    CompareLoansScreen compareLoansScreen;
    @Test(priority = 0)
    public void CompareLoanShouldSuccess(){
         compareLoansScreen = screen.getInstance(HomeScreen.class)
                .tapOnCompareLoansBtn();

        compareLoansScreen = compareLoansScreen
                .fillLoan1Amount(5000000)
                .fillInterest1(10)
                .fillMonth1(10)
                .fillLoan2Amount(300000)
                .fillInterest2(5)
                .fillMonth2(6)
                .tapOnCalculateBtn();
       Assert.assertTrue(compareLoansScreen.hasResultLayout());
    }
    @Test(priority = 1)
    public void resetBtnShouldSuccess(){
        compareLoansScreen=compareLoansScreen
                .tapOnResetBtn();
        Assert.assertFalse(compareLoansScreen.hasResultLayout());
    }
}
