package CalculatorTests;

import Calculator.Calculator;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by dimitarrad
 * on 1/30/2021
 */
public class CalculatorDivTest {
    @Test
    public void calculatorDivTest() {
        Calculator  cal = new Calculator();
        System.out.println("calculatorMultiplyTest from DIV test1");
        double a = 6;
        double b = 2;
        double result = 3;
        Assert.assertEquals(result,cal.divide(a,b),0.001);
    }
   // @Ignore("has defect")
    @Test
    public void calculatorDivErrorTest() {
        Calculator  cal = new Calculator();
        System.out.println("calculatorMultiplyTest from DIV test2");
        double a = 3;
        double b = 2;
        double result = 3;
        Assert.assertTrue(result!=cal.divide(a,b));
    }
}
