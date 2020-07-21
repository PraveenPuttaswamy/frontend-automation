package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Login Page objects
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class LoginPage {

    @FindBy(id="email")
    private WebElement usernameTextbox;

    @FindBy(id="password")
    private WebElement passwordTextbox;

    @FindBy(id = "buttonLogin")
    private WebElement loginButton;

    @FindBy(linkText="Log Out")
    private WebElement logoutLink;

    public WebElement getUsernameTextbox() { return usernameTextbox; }

    public WebElement getPasswordTextbox() {
        return passwordTextbox;
    }

    public WebElement getLoginButton() { return loginButton; }

    public WebElement getLogoutLink() {
        return logoutLink;
    }
}
