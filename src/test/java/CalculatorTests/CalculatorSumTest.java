package CalculatorTests;

import Calculator.Calculator;
import org.junit.*;

import junit.framework.TestCase;




/**
 * Created by dimitarrad
 * on 1/30/2021
 */
public class CalculatorSumTest {

    Calculator cal;
    @Before
    public void setUp() {
        System.out.println("Test "+ this.getClass().getName()+ " will be executed");
        cal = new Calculator();
    }

    @Before
    public void setUp2() {
        System.out.println("setUp2 "+ this.getClass().getName()+ " will be executed");
        cal = new Calculator();
    }

    @AfterClass
    public static void tearDown()  {
        System.out.println("Test suite finished");
    }

    @Test
    public void calculatorSumTest() {

        String name = this.getClass().getName();
        System.out.println("Test Case Name = "+ name);
        double a = 4;
        double b = 6;
        double result = 10;
        Assert.assertEquals(result,cal.sum(a,b),0.1);

    }
    @Test
    public void calculatorMultiplyTest() {

        System.out.println("calculatorMultiplyTest from sum tests");
        double a = 4;
        double b = 6;
        double result = 24;

        Assert.assertEquals(result,cal.multiply(a,b),0.1);
    }

}
