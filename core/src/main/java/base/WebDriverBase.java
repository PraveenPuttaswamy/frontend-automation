package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;

/** Create and destroy driver instance
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class WebDriverBase {

    public static WebDriver driver;

    /**
     * Initialize a global driver instance based in browser input
     */
    public void initDriver() {
        if (getBrowser().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (System.getProperty("headless") != null) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                driver = new FirefoxDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            if (System.getProperty("headless") != null) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
            } else {
                driver = new ChromeDriver();
            }
        }
    }

    /**
     * Destroy driver instance
     */
    public void endDriver() {
        if(null != driver) {
            driver.quit();
        }
    }

    /**
     * Get browser from Maven command. If not specified via debug return default
     * @return String
     */
    public static String getBrowser() {
        if (System.getProperty("browser") == null) {
            return "chrome";
        } else {
            return System.getProperty("browser").toLowerCase();
        }
    }

    /**
     * Get path of browser screenshot in an event of exception
     * @return String
     */
    public static String getScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) WebDriverBase.driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + "report" + File.separator + System.currentTimeMillis() + ".png";
        System.out.println(path);
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }



}
