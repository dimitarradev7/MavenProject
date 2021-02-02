package Calculator;

import org.openqa.selenium.InvalidArgumentException;

/**
 * Created by dimitarrad
 * on 1/30/2021
 */
public class Calculator {
    public double sum(double a, double b){
        return a+b;
    }

    public double subtract(double a, double b){
        return a - b;
    }
    public double divide(double a, double b){
      if (a==0 || b==0){
          throw new InvalidArgumentException("Invalid operation");
      }
      return a/b;
    }

    public double multiply(double a, double b){
        return a*b;
    }
}
