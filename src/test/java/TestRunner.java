import CalculatorTests.CalculatorTestSuite;
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

        System.out.println(result.wasSuccessful());
    }
}
