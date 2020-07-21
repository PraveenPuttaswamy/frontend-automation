package com.app.sharedutil;

import utils.ProjectDataUtil;
import utils.WebDriverUtil;

import java.io.IOException;

/** Declare methods common to all Utils
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class SharedUtil extends WebDriverUtil {

    ProjectDataUtil projectDataUtil = new ProjectDataUtil();

    public String getUsername() throws IOException {
        return projectDataUtil.getProjectData().getProperty("username");
    }

    public String getPassword() throws IOException {
        return projectDataUtil.getProjectData().getProperty("password");
    }
}
