package com.app.pageutil;

import com.app.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/** Methods to interact with elements in Login Page
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class LoginUtil extends BaseUtil {

    LoginPage _login;

    public LoginUtil() {
        _login = PageFactory.initElements(driver, LoginPage.class);
    }

    public void login() throws IOException {
        maximizeBrowser();
        String url = projectDataUtil.getUrl();
        navigateTo(url);
        waitElementVisible(_login.getUsernameTextbox());
        String username = getUsername();
        String password = getPassword();
        enterText(_login.getUsernameTextbox(), username);
        enterText(_login.getPasswordTextbox(), password);
        click(_login.getLoginButton());
        waitForPageLoad(20000);
        waitElementClickable(_login.getLogoutLink());
    }

    public boolean isLogoutDisplayed() {
        return isElementDisplayed(_login.getLogoutLink());
    }

    public void logout() {
        if (isLogoutDisplayed()) {
            click(_login.getLogoutLink());
        }
        clearCookies();
        waitForPageLoad(20000);
    }

}
