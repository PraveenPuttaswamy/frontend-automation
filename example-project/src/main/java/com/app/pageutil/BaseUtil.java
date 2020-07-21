package com.app.pageutil;

import base.WebDriverBase;
import com.app.sharedutil.SharedUtil;
import org.openqa.selenium.WebDriver;
import utils.ProjectDataUtil;

/** Declare variable common to all Utils
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class BaseUtil extends SharedUtil {
    WebDriver driver = WebDriverBase.driver;
    ProjectDataUtil projectDataUtil = new ProjectDataUtil();
}
