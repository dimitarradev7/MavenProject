import CalculatorTests.CalculatorDivTest;
import CalculatorTests.CalculatorSumTest;
import CalculatorTests.CalculatorTestSuite;
import JUnitTests.ErrorCollectorExampleTest;
import SeleniumTests.Tast1;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by dimitarrad
 * on 1/30/2021
 */
public class TestRunner {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(CalculatorTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.getRunCount());
        System.out.println(result.getRunTime());
        System.out.println(result.getFailureCount());
        System.out.println(result.getIgnoreCount());
                System.out.println(result.wasSuccessful());
    }
}
