package com.emi.calculator.testcases;

import com.emi.calculator.screens.EmiCalculatorScreen;
import com.emi.calculator.screens.EmiDetailScreen;
import com.emi.calculator.screens.HomeScreen;
import com.emi.calculator.screens.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseTest{
    @Test
    public void EmiCalculateShouldSuccess(){
        EmiCalculatorScreen emiCalculatorScreen= screen.getInstance(HomeScreen.class)
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
}
