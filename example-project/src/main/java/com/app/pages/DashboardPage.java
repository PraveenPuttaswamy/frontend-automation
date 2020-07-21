package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Dashboard page objects
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class DashboardPage {

    @FindBy(css = "h1[class=page-header]")
    private WebElement header;

    @FindBy(css = "a[href*=work-items] button")
    private WebElement workItemsButton;

    public WebElement getHeader() {
        return header;
    }

    public WebElement getWorkItemsButton() {
        return workItemsButton;
    }
}
