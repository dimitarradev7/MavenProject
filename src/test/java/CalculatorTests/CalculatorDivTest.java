package CalculatorTests;

import Calculator.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dimitarrad
 * on 1/30/2021
 */
public class CalculatorDivTest {
    @Test
    public void calculatorDivTest() {
        Calculator  cal = new Calculator();

        double a = 4;
        double b = 2;
        double result = 3;
        Assert.assertEquals(result,cal.divide(a,b),0.1);
    }
}
