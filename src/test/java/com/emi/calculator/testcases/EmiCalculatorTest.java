package com.emi.calculator.testcases;

import com.emi.calculator.screens.EmiCalculatorScreen;
import com.emi.calculator.screens.EmiDetailScreen;
import com.emi.calculator.screens.HomeScreen;
import com.emi.calculator.screens.Screen;
import com.emi.calculator.util.General;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseTest{
    EmiCalculatorScreen emiCalculatorScreen;
    EmiDetailScreen detailScreen;
    private int amount =10000;
    @Test(priority = 0)
    public void EmiCalculateShouldSuccess(){
        emiCalculatorScreen= screen.getInstance(HomeScreen.class)
                .tapOnEmiCalculatorBtn();

              emiCalculatorScreen=emiCalculatorScreen
                .fillAmount(300000)
                .fillInterest(3)
                .fillYear(1)
                .fillMonth(6)
                .fillProcessFee(10)
                .tapOnCalculateBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailButton());
    }

    @Test(priority = 1)
    public void resetShouldSuccess(){
        emiCalculatorScreen=emiCalculatorScreen
                .fillAmount(300000)
                .fillInterest(3)
                .fillYear(1)
                .fillMonth(6)
                .fillProcessFee(10)
                .tapOnResetBtn();
        General.WaitForDom();
        General.WaitForDom();
    }

    @Test(priority = 2)
    public void checkDetailShouldSuccess(){
        emiCalculatorScreen=emiCalculatorScreen
                .fillAmount(amount)
                .fillInterest(3)
                .fillYear(1)
                .fillMonth(6)
                .fillProcessFee(10)
                .tapOnCalculateBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailButton());

        detailScreen = emiCalculatorScreen.tapOnDetailBtn();
        Assert.assertTrue(detailScreen.hasDetailLayout());
    }
    @Test(priority = 3)
    public void checkDetailAmountShouldSuccess(){
      Assert.assertEquals(amount,detailScreen.getLoanAmount());
    }
    @Test(priority = 4)
    public void clickBackBtnShouldSuccess(){
        emiCalculatorScreen = detailScreen.clickBackBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailButton());
    }
}
