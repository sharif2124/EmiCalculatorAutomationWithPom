package com.emi.calculator.testcases;

import com.emi.calculator.screens.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{
    @Test
    public void CheckEmiCalculatorBtnShouldSuccess(){
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasEmiCalculatorBtn());

    }

    @Test
    public void CheckCompareLoansBtnShouldSuccess(){
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasCompareLoansBtn());
    }
}
