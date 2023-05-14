package project.runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import project.tests.junit.DemoTests;
import project.tests.junit.SchoolTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({DemoTests.class, SchoolTests.class})
public class JUnitRunner {
}
