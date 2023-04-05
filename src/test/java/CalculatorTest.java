import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void myCalcAddTest() {

        Assert.assertEquals("Addition returned wrong result", 10,calculator.add(3, 7));

    }

    @Test
    public void myCalcSubtractTest() {


        Assert.assertEquals("Subtraction returned wrong result", 4, calculator.subtract(7, 3));

    }

    @Test
    public void myCalcMultiplyTest() {


        Assert.assertEquals("Multiplication returned wrong result", 21, calculator.multiply(3, 7));

    }

    @Test
    public void myCalcDivideTest() {


        Assert.assertEquals("Division returned wrong result", 4, calculator.divide(8, 2));

    }
}

