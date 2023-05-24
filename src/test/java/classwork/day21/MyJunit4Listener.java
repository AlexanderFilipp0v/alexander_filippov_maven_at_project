package classwork.day21;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MyJunit4Listener extends RunListener {

    boolean isFailed;
    public void testStarted(Description description) throws Exception {
        System.out.println("Started test: " + description.getDisplayName());
        String id = description.getAnnotation(TestCaseID.class).id();
        System.out.println("Test ID is: " + id);
    }
    public void testFinished(Description description) throws Exception {
        if(!isFailed){
            String id = description.getAnnotation(TestCaseID.class).id();
            TestRailReporter.reportResult("2200", id, new Result(1));
        }
        System.out.println("Finished test: " + description.getDisplayName());
        isFailed = false;

    }
    public void testFailure(Failure failure) throws Exception {
        isFailed = true;
        System.out.println("Failed test: " + failure.getDescription().getDisplayName());
        String id = failure.getDescription().getAnnotation(TestCaseID.class).id();
        TestRailReporter.reportResult("2200", id, new Result(5));

    }
}