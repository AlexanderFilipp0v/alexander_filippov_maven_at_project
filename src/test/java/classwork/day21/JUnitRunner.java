package classwork.day21;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;


public class JUnitRunner extends RunListener {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        runner.addListener(new MyJunit4Listener());
        runner.run(EmptyTest.class);

    }
}
