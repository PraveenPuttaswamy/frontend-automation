package com.app.smoketest;

import com.app.TestBase;
import com.app.pageutil.DashboardUtil;
import com.app.pageutil.LoginUtil;
import configuration.CustomListener;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;

@Listeners(value = CustomListener.class)

/** Example tests
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class SmokeTest extends TestBase {

    LoginUtil login;
    DashboardUtil dashboard;

    @BeforeTest
    public void beforeTestConfig() {
        login = new LoginUtil();
        dashboard = new DashboardUtil();
    }

    @BeforeMethod
    public void beforeMethodConfig() {
        errors = new ArrayList<>();
    }

    @AfterMethod
    public void afterMethodConfig() {
        login.logout();
    }

    @Test
    public void passTest() throws IOException {

        //Login
        login.login();
        dashboard.waitForDashboard();

        //Assertions
        $.assertTrue(login.isLogoutDisplayed(), "Login is successful");
        $.assertEquals(getPageTitle(), "ACME System 1 - Dashboard", "Page Title");

        //Assert all errors at end of test - Mandatory
        $.assertAll(errors);
    }

    @Test
    public void failTest() throws IOException {

        //Login
        login.login();
        dashboard.waitForDashboard();

        //Assertions
        $.assertTrue(login.isLogoutDisplayed(), "Login is successful");
        $.assertFalse(true, "Manually failing 1");

        dashboard.navigateToWorkItems();

        //Assertions
        $.assertFalse(true, "Manually failing 2");

        //Assert all errors at end of test - Mandatory
        $.assertAll(errors);

    }
}
