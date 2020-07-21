package com.app.pageutil;

import com.app.pages.DashboardPage;
import org.openqa.selenium.support.PageFactory;

/** Methods to interact with elements in Dashboard Page
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class DashboardUtil extends BaseUtil {

    DashboardPage _dashboard;

    public DashboardUtil() {
        _dashboard = PageFactory.initElements(driver, DashboardPage.class);
    }

    public void waitForDashboard() {
        waitElementVisible(_dashboard.getHeader());
    }

    public void navigateToWorkItems() {
        click(_dashboard.getWorkItemsButton());
        waitForPageLoad(20000);
    }

}
