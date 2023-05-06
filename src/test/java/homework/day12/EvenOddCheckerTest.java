import org.junit.Assert;
import org.junit.Test;

public class EvenOddCheckerTest {

    @Test
    public void EvenCheckerTest() {

        Assert.assertTrue("Returned wrong result", EvenOddChecker.check(32));
    }

    @Test
    public void OddCheckerTest() {

        Assert.assertFalse("Returned wrong result", EvenOddChecker.check(23));
    }
}
