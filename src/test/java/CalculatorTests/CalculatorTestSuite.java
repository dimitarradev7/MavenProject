package CalculatorTests;


import JUnitTests.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        CalculatorDivTest.class,
        CalculatorSumTest.class,
        ParameterizedTest.class
})
public class CalculatorTestSuite {

}
