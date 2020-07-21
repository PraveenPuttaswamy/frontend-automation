package configuration;

import base.WebDriverBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.ProjectDataUtil;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Paths;

/** Configure report and enter logs
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class CustomListener implements ITestListener {

    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest test;
    String reportPath;
    ProjectDataUtil projectDataUtil = new ProjectDataUtil();
    WebDriverBase webDriverBase = new WebDriverBase();

    /**
     * Initialize Report stream
     */
    public void initReporter() {

        reportPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "report" + File.separator +"report.html";
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentHtmlReporter.config().setDocumentTitle("Test Automation Report");
        extentHtmlReporter.config().setReportName("Test Automation Report");
        extentHtmlReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        try {
            extentReports.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            extentReports.setSystemInfo("Host Name", "Unknown");
        }
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Environment", projectDataUtil.getEnvironment());
        extentReports.setSystemInfo("Browser", WebDriverBase.getBrowser());
        extentReports.setSystemInfo("Headless", String.valueOf(System.getProperty("headless") != null));
        extentReports.setSystemInfo("Application", projectDataUtil.getModule());
        try {
            extentReports.setSystemInfo("Url", projectDataUtil.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add Test name to HTML reporter stream
     * @param testName Name of the test to be executed
     */
    public void createTest(String testName) {
        test = extentReports.createTest(testName);
    }

    /**
     * Log info messages to HTML reporter stream and log message to console
     * @param message Info message to be shown
     */
    public void logInfo(String message) {
        test.log(Status.INFO, message);
        Reporter.log(message, true);
    }

    /**
     * Mark a test as PASS in HTML reporter stream and log message to console
     * @param message Pass message
     */
    public void logPass(String message) {
        test.log(Status.PASS, message);
        Reporter.log(message, true);
    }

    /**
     * Mark a test as FAIL in HTML reporter stream and log message to console
     * @param message exception message
     */
    public void logFail(String message) {
        test.log(Status.FAIL, message);
        try {
            String path = String.valueOf(Paths.get(WebDriverBase.getScreenshot()).getFileName());
            test.fail("", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log(message, true);
    }

    /**
     * Log Warning messages to HTML reporter stream and log message to console
     * @param message Message to be shown
     */
    public void logWarn(String message) {
        test.log(Status.WARNING, message);
        Reporter.log(message, true);
    }

    /**
     * Mark a step as SKIP if dependant method fail in HTML reporter stream and log message to console
     * @param message
     */
    public void logSkip(String message) {
        test.log(Status.SKIP, message);
        Reporter.log(message, true);
    }

    /**
     * Save HTML reporter
     */
    public void endReporter() {
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logPass(iTestResult.getName() + " - PASS");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, iTestResult.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        logSkip(iTestResult.getName() + " - SKIP");
        logSkip("Exception - " + iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //Implementation is not required
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        initReporter();
        webDriverBase.initDriver();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        webDriverBase.endDriver();
        endReporter();
        Reporter.log("Report Path " + reportPath, true);
    }

}
