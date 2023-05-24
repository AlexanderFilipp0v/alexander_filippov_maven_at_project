package classwork.day21;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.notification.RunListener;

public class EmptyTest extends RunListener {
    @Test
    @TestCaseID(id = "156405")
    public void test1() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseID(id = "156406")
    public void test2() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseID(id = "156407")
    public void test3() {
        Assert.assertTrue(true);
    }

    @Test
    @TestCaseID(id = "156408")
    public void test4() {
        Assert.assertTrue(false);
    }

}
