package configuration;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/** Assertions to log failures in Reports
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class CustomAssert {

    public static List collector = new ArrayList();
    CustomListener reporter = new CustomListener();

    /**
     * Return List holding error objects if any assertions failed during test run
     * @return List
     */
    public List<String> getErrors(){
        return collector;
    }

    /**
     * Parse for assertion error(s) if any in a test run and fail resulting test
     * Should be called at the end of every test
     * @param errors Error list to be passed from each Class holding multiple tests
     */
    public void assertAll(List<String> errors) {
        try {
            if (getErrors().contains("Error") | getErrors().size() > 0) {
                errors.addAll(getErrors());
                Assert.fail("Test Failed due to the following error(s):\n" + getErrors());
            }
        }
        finally {
            getErrors().clear();
        }
    }

    /**
     * Assert if actual is equal to expected and add error object to Collector if assertion fails
     * @param actual Actual value from API
     * @param expected Expected Value for acceptance
     * @param message Message to provide more insight in the test report if the assertion fails
     * @param <T> Any data type can be passed as argument
     */
    public <T> void assertEquals(T actual, T expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
            reporter.logPass(message);
        } catch (Throwable t) {
            collector.add("Error Message: " + t.getMessage());
            reporter.logFail(t.getMessage());
        }
    }

    /**
     * Assert if a given condition is true and add error object to Collector if assertion fails
     * @param condition boolean value
     * @param message Message to provide more insight in the test report if the assertion fails
     */
    public void assertTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
            reporter.logPass(message);
        } catch (Throwable t) {
            collector.add("Error Message: " + t.getMessage());
            reporter.logFail(t.getMessage());
        }
    }

    /**
     * Assert if a given condition is false and add error object to Collector if assertion fails
     * @param condition boolean value
     * @param message Message to provide more insight in the test report if the assertion fails
     */
    public void assertFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
            reporter.logPass(message);
        } catch (Throwable t) {
            collector.add("Error Message: " + t.getMessage());
            reporter.logFail(t.getMessage());
        }
    }
}
